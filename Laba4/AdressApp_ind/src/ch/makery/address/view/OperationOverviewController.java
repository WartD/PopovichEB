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
    private TableColumn<Operation, Integer> transactionNumberColumn;
    @FXML
    private Label idLabel;
    @FXML
    private Label transactionNumberLabel;
    @FXML
    private Label dateLabel;
    @FXML
    private Label typeLabel;
    @FXML
    private Label sumLabel;
    @FXML
    private Label inputBalanceLabel;
    @FXML
    private Label outputBalanceLabel;

    private MainApp mainApp;

    public OperationOverviewController() {
    }

    @FXML
    private void initialize() {
        idColumn.setCellValueFactory(cellData -> cellData.getValue().idProperty().asObject());
        transactionNumberColumn.setCellValueFactory(cellData -> cellData.getValue().numberProperty().asObject());

        // Add listeners to show operation details when selected
        operationTable.getSelectionModel().selectedItemProperty().addListener(
                (observable, oldValue, newValue) -> showOperationDetails(newValue));
    }

    private void showOperationDetails(Operation operation) {
        if (operation != null) {
            idLabel.setText(Integer.toString(operation.getId()));
            transactionNumberLabel.setText(Integer.toString(operation.getNumber()));
            dateLabel.setText(operation.getDate().toString());
            typeLabel.setText(operation.getType());
            sumLabel.setText(Double.toString(operation.getSum()));
            inputBalanceLabel.setText(Double.toString(operation.getSaldoInput()));
            outputBalanceLabel.setText(Double.toString(operation.getSaldoOutput()));
        } else {
            idLabel.setText("");
            transactionNumberLabel.setText("");
            dateLabel.setText("");
            typeLabel.setText("");
            sumLabel.setText("");
            inputBalanceLabel.setText("");
            outputBalanceLabel.setText("");
        }
    }

    public void setMainApp(MainApp mainApp) {
        this.mainApp = mainApp;
        operationTable.setItems(mainApp.getOperationData());
    }
}
