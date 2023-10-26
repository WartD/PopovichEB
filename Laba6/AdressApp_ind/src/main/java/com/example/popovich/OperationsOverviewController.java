package com.example.popovich;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class OperationsOverviewController implements Initializable {
    @FXML
    private TableColumn<Operation, String> col_date, col_input, col_num, col_output, col_sum, col_type;

    @FXML
    private Label l_date,  l_input, l_num, l_output, l_sum, l_type;

    @FXML
    private TableView<Operation> operations_table;

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