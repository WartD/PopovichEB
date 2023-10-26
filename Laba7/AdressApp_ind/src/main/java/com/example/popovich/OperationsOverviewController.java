package com.example.popovich;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.FileChooser;
import javafx.stage.Stage;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.Marshaller;
import javax.xml.bind.Unmarshaller;
import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import java.util.prefs.Preferences;

public class OperationsOverviewController implements Initializable {
    @FXML
    private TableColumn<Operation, String> col_date, col_input, col_num, col_output, col_sum, col_type;

    @FXML
    private Label l_date,  l_input, l_num, l_output, l_sum, l_type;

    @FXML
    private TableView<Operation> operations_table;

    private Stage stage;

    ObservableList<Operation> operations = FXCollections.observableArrayList(
            new Operation("1", "22.10.2023", "12000", "Покупка",
                    "26000", "14000"),
            new Operation("2", "24.10.2023", "6000", "Продажа",
                    "14000", "20000")
    );

    @FXML
    void add(ActionEvent event) throws IOException {
        Stage dialog = new Stage();
        FXMLLoader loader = new FXMLLoader(MainApp.class.getResource("AddOperationOverview.fxml"));
        dialog.setScene(new Scene(loader.load(),600, 400));
        AddOperationController controller = loader.getController();
        controller.getDialogStage(dialog);
        controller.getOperation(operations);
        dialog.showAndWait();
        operations_table.setItems(FXCollections.observableList(operations));
    }

    @FXML
    void delete(ActionEvent event) {
        if (operations_table.getSelectionModel().getSelectedItem()!=null) {
            operations.remove(operations_table.getSelectionModel().getSelectedItem());
            operations_table.setItems(FXCollections.observableList(operations));
            l_num.setText("Операция №");
            l_date.setText("Дата: ");
            l_sum.setText("Сумма: ");
            l_type.setText("Тип транзакции: ");
            l_input.setText("Сальдо начальное: ");
            l_date.setText("Сальдо конечное: ");
        }
    }

    @FXML
    void edit(ActionEvent event) throws IOException {
        if (operations_table.getSelectionModel().getSelectedItem()!=null) {
            Stage stage = new Stage();
            FXMLLoader loader = new FXMLLoader(MainApp.class.getResource("EditOperationOverview.fxml"));
            stage.setScene(new Scene(loader.load(),600, 400));
            EditOperationController controller = loader.getController();
            controller.getDialogStage(stage);
            int id = operations.indexOf(operations_table.getSelectionModel().getSelectedItem());
            controller.getOperation(operations.get(id));
            stage.showAndWait();
            operations_table.setItems(operations);
            operations_table.getSelectionModel().clearSelection();
            operations_table.getSelectionModel().select(id);
            operations_table.refresh();
        }
    }

    public void getStage(Stage stage)
    {this.stage = stage;}

    public File getOperationsFilePath() {
        Preferences prefs = Preferences.userNodeForPackage(MainApp.class);
        String filePath = prefs.get("filePath", null);
        if (filePath != null) {
            return new File(filePath);
        } else {
            return null;
        }
    }

    public void setOperationsFilePath(File file) {
        Preferences prefs = Preferences.userNodeForPackage(MainApp.class);
        if (file != null) {
            prefs.put("filePath", file.getPath());

            // Обновление заглавия сцены.
            stage.setTitle("Operations - " + file.getName());
        } else {
            prefs.remove("filePath");

            // Обновление заглавия сцены.
            stage.setTitle("Operations");
        }
    }

    public void loadOperationsDataFromFile(File file) {
        try {

            JAXBContext context = JAXBContext
                    .newInstance(OperationsWrapper.class);
            Unmarshaller um = context.createUnmarshaller();
            // Чтение XML из файла и демаршализация.
            OperationsWrapper wrapper = (OperationsWrapper) um.unmarshal(file);

            operations = FXCollections.observableList(wrapper.getOperations());
            operations_table.setItems(operations);

            // Сохраняем путь к файлу в реестре.
            setOperationsFilePath(file);

        } catch (Exception e) { // catches ANY exception
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Ошибка");
            alert.setHeaderText("Не получилось открыть файл");
            alert.setContentText("Не получилось загрузить данные из файла:\n" + file.getPath());

            alert.showAndWait();
        }
    }

    public void saveOperationsDataToFile(File file) {
        try {
            JAXBContext context = JAXBContext
                    .newInstance(OperationsWrapper.class);
            Marshaller m = context.createMarshaller();
            m.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);

            // Обёртываем наши данные об преподавателях.
            OperationsWrapper wrapper = new OperationsWrapper();
            wrapper.setOperations(operations);

            // Маршаллируем и сохраняем XML в файл.
            m.marshal(wrapper, file);

            // Сохраняем путь к файлу в реестре.
            setOperationsFilePath(file);
        } catch (Exception e) { // catches ANY exception
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Ошибка");
            alert.setHeaderText("Не получилось открыть файл");
            alert.setContentText("Не получилось загрузить данные из файла:\n" + file.getPath());

            alert.showAndWait();
        }
    }

    @FXML
    private void new_file(ActionEvent event) {
        operations.clear();
        operations_table.setItems(operations);
        setOperationsFilePath(null);
    }

    @FXML
    private void open_file(ActionEvent event) {
        FileChooser fileChooser = new FileChooser();

        // Задаём фильтр расширений
        FileChooser.ExtensionFilter extFilter = new FileChooser.ExtensionFilter(
                "XML files (*.xml)", "*.xml");
        fileChooser.getExtensionFilters().add(extFilter);

        // Показываем диалог загрузки файла
        File file = fileChooser.showOpenDialog(stage);

        if (file != null) {
            loadOperationsDataFromFile(file);
        }
    }

    /**
     * Сохраняет файл в файл адресатов, который в настоящее время открыт.
     * Если файл не открыт, то отображается диалог "save as".
     */
    @FXML
    private void save_file(ActionEvent event) {
        File personFile = getOperationsFilePath();
        if (personFile != null) {
            saveOperationsDataToFile(personFile);
        } else {
            save_as_file(event);
        }
    }

    /**
     * Открывает FileChooser, чтобы пользователь имел возможность
     * выбрать файл, куда будут сохранены данные
     */
    @FXML
    private void save_as_file(ActionEvent event) {
        FileChooser fileChooser = new FileChooser();

        // Задаём фильтр расширений
        FileChooser.ExtensionFilter extFilter = new FileChooser.ExtensionFilter(
                "XML files (*.xml)", "*.xml");
        fileChooser.getExtensionFilters().add(extFilter);

        // Показываем диалог сохранения файла
        File file = fileChooser.showSaveDialog(stage);

        if (file != null) {
            // Make sure it has the correct extension
            if (!file.getPath().endsWith(".xml")) {
                file = new File(file.getPath() + ".xml");
            }
            saveOperationsDataToFile(file);
        }
    }

    /**
     * Открывает диалоговое окно about.
     */
    @FXML
    private void help_about(ActionEvent event) {
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle("Операции");
        alert.setHeaderText("О нас");
        alert.setContentText("Автор: Попович Екатерина \nГруппа: ИСТ-332");

        alert.showAndWait();
    }

    /**
     * Закрывает приложение.
     */
    @FXML
    private void exit(ActionEvent event) {
        System.exit(0);
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        col_num.setCellValueFactory(new PropertyValueFactory<Operation, String>("number"));
        col_date.setCellValueFactory(new PropertyValueFactory<Operation, String>("date"));
        col_sum.setCellValueFactory(new PropertyValueFactory<Operation,String>("sum"));
        col_type.setCellValueFactory(new PropertyValueFactory<Operation,String>("transactionType"));
        col_input.setCellValueFactory(new PropertyValueFactory<Operation,String>("inputBalance"));
        col_output.setCellValueFactory(new PropertyValueFactory<Operation,String>("outputBalance"));

        operations_table.setItems(operations);
        operations_table.getSelectionModel().selectedItemProperty().addListener((obs, oldSelection, newSelection) -> {
            if (newSelection != null) {
                Operation operations = operations_table.getSelectionModel().getSelectedItem();
                l_num.setText("Операция №"+operations.getNumber());
                l_date.setText("Дата: "+operations.getDate());
                l_sum.setText("Сумма: "+operations.getSum());
                l_type.setText("Тип транзакции: "+operations.getTransactionType());
                l_input.setText("Сальдо начальное: "+operations.getInputBalance());
                l_output.setText("Сальдо конечное: "+operations.getOutputBalance());
            }
        });
    }
}