package ch.makery.address;

import java.io.IOException;
import java.time.LocalDate;

import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.BorderPane;
import javafx.stage.Modality;
import javafx.stage.Stage;

import ch.makery.address.model.Operation;
import ch.makery.address.view.OperationOverviewController;
import ch.makery.address.view.OperationEditDialogController;

public class MainApp extends Application {

    private Stage primaryStage;
    private BorderPane rootLayout;

    private ObservableList<Operation> operationData = FXCollections.observableArrayList();

    public ObservableList<Operation> getOperationData() {
        return operationData;
    }

    @Override
    public void start(Stage primaryStage) {
        this.primaryStage = primaryStage;
        this.primaryStage.setTitle("OperationApp");

        initRootLayout();

        showOperationOverview();
    }

    public void initRootLayout() {
        try {
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(MainApp.class.getResource("view/RootLayout.fxml"));
            rootLayout = (BorderPane) loader.load();

            Scene scene = new Scene(rootLayout);
            primaryStage.setScene(scene);
            primaryStage.show();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void showOperationOverview() {
        try {
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(MainApp.class.getResource("view/OperationOverview.fxml"));
            AnchorPane operationOverview = (AnchorPane) loader.load();

            rootLayout.setCenter(operationOverview);

            OperationOverviewController controller = loader.getController();
            controller.setMainApp(this);

            // Создадим 10 объектов Operation с разными ID и Number
            for (int i = 1; i <= 10; i++) {
                Operation operation = new Operation();
                operation.setNumber("ID-" + i);
                operation.setSum(100.0 * i); // Устанавливаем разные суммы для каждой операции
                operationData.add(operation);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public Stage getPrimaryStage() {
        return primaryStage;
    }

    public boolean showOperationEditDialog(Operation operation) {
        try {
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(MainApp.class.getResource("view/OperationEditDialog.fxml"));
            AnchorPane page = (AnchorPane) loader.load();

            Stage dialogStage = new Stage();
            dialogStage.setTitle("Edit Operation");
            dialogStage.initModality(Modality.WINDOW_MODAL);
            dialogStage.initOwner(primaryStage);
            Scene scene = new Scene(page);
            dialogStage.setScene(scene);

            OperationEditDialogController controller = loader.getController();
            controller.setDialogStage(dialogStage);
            controller.setOperation(operation);

            dialogStage.showAndWait();

            return controller.isOkClicked();
        } catch (IOException e) {
            e.printStackTrace();
            return false;
        }
    }

    public static void main(String[] args) {
        launch(args);
    }
}
