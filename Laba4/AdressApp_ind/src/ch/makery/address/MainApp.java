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
import javafx.stage.Stage;
import ch.makery.address.model.Operation;
import ch.makery.address.view.OperationOverviewController;

public class MainApp extends Application {
    private Stage primaryStage;
    private BorderPane rootLayout;
    private ObservableList<Operation> operationData = FXCollections.observableArrayList();

    public MainApp() {
        // Добавьте несколько примеров данных операций
        operationData.add(new Operation(1, 1, 1, 1, LocalDate.now(), "Buy", 100.0, 0.0, 100.0));
        operationData.add(new Operation(2, 2, 2, 2, LocalDate.now(), "Sell", 50.0, 100.0, 50.0));
    }

    public ObservableList<Operation> getOperationData() {
        return operationData;
    }

    @Override
    public void start(Stage primaryStage) {
        this.primaryStage = primaryStage;
        this.primaryStage.setTitle("OperationApp"); // Обновите название приложения

        initRootLayout();
        showOperationOverview(); // Изменили метод для отображения операций
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

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public Stage getPrimaryStage() {
        return primaryStage;
    }

    public static void main(String[] args) {
        launch(args);
    }
}
