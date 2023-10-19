package ch.makery.address.view;

import ch.makery.address.MainApp;
import ch.makery.address.model.Operation;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;

public class OperationOverviewController {
    @FXML
    private TableView<Operation> operationTable;
    @FXML
    private TableColumn<Operation, String> idColumn;
    @FXML
    private TableColumn<Operation, String> transactionNumberColumn;
    @FXML
    private Label dateLabel;
    @FXML
    private Label transactionNumberLabel;
    @FXML
    private Label sumLabel;
    @FXML
    private Label typeLabel;
    @FXML
    private Label inputBalanceLabel;
    @FXML
    private Label outputBalanceLabel;

    private MainApp mainApp;

    public OperationOverviewController() {
    }

    @FXML
    private void initialize() {
        idColumn.setCellValueFactory(cellData -> cellData.getValue().numberProperty());
        transactionNumberColumn.setCellValueFactory(cellData -> cellData.getValue().numberProperty());

        operationTable.getSelectionModel().selectedItemProperty().addListener(
                (observable, oldValue, newValue) -> showOperationDetails(newValue));
    }

    private void showOperationDetails(Operation operation) {
        if (operation != null) {
            dateLabel.setText(operation.getDate().toString());
            transactionNumberLabel.setText(operation.getNumber());
            sumLabel.setText(Double.toString(operation.getSum()));
            typeLabel.setText(operation.getTransactionType());
            inputBalanceLabel.setText(Double.toString(operation.getInputBalance()));
            outputBalanceLabel.setText(Double.toString(operation.getOutputBalance()));
        }
    }

    public void setMainApp(MainApp mainApp) {
        this.mainApp = mainApp;
        operationTable.setItems(mainApp.getOperationData());
    }

    @FXML
    private void handleNewButton() {
        mainApp.showOperationEditDialog(new Operation());
    }

    @FXML
    private void handleEditButton() {
        Operation selectedOperation = operationTable.getSelectionModel().getSelectedItem();
        if (selectedOperation != null) {
            mainApp.showOperationEditDialog(selectedOperation);
        }
    }

    @FXML
    private void handleDeleteButton() {
        int selectedIndex = operationTable.getSelectionModel().getSelectedIndex();
        if (selectedIndex >= 0) {
            operationTable.getItems().remove(selectedIndex);
        }
    }
}
