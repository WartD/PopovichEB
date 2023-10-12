package ch.makery.address.view;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import ch.makery.address.MainApp;
import ch.makery.address.model.Operation;

public class OperationOverviewController {
    @FXML
    private TableView<Operation> operationTable;
    @FXML
    private TableColumn<Operation, Integer> idColumn;
    @FXML
    private TableColumn<Operation, Integer> dealIdColumn;

    @FXML
    private Label idLabel;
    @FXML
    private Label dealIdLabel;
    @FXML
    private Label subAccountIdLabel;
    @FXML
    private Label numberLabel;
    @FXML
    private Label dateLabel;
    @FXML
    private Label typeLabel;
    @FXML
    private Label sumLabel;
    @FXML
    private Label saldoInputLabel;
    @FXML
    private Label saldoOutputLabel;

    private MainApp mainApp;

    public OperationOverviewController() {
    }

    @FXML
    private void initialize() {
        idColumn.setCellValueFactory(cellData -> cellData.getValue().idProperty().asObject());
        dealIdColumn.setCellValueFactory(cellData -> cellData.getValue().dealIdProperty().asObject());


        // Add listeners to show operation details when selected
        operationTable.getSelectionModel().selectedItemProperty().addListener(
                (observable, oldValue, newValue) -> showOperationDetails(newValue));
    }

    private void showOperationDetails(Operation operation) {
        if (operation != null) {
            idLabel.setText(Integer.toString(operation.getId()));
            dealIdLabel.setText(Integer.toString(operation.getDealId()));
            // Добавьте остальные поля операции

        } else {
            idLabel.setText("");
            dealIdLabel.setText("");
            // Очистите остальные поля
        }
    }

    public void setMainApp(MainApp mainApp) {
        this.mainApp = mainApp;

        operationTable.setItems(mainApp.getOperationData());
    }
}
