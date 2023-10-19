package ch.makery.address.view;

import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import ch.makery.address.model.Operation;
import ch.makery.address.util.DateUtil;

public class OperationEditDialogController {
    @FXML
    private TextField dateField;
    @FXML
    private TextField numberField;
    @FXML
    private TextField sumField;
    @FXML
    private TextField transactionTypeField;
    @FXML
    private TextField inputBalanceField;
    @FXML
    private TextField outputBalanceField;

    private Stage dialogStage;
    private Operation operation;
    private boolean okClicked = false;

    public void setDialogStage(Stage dialogStage) {
        this.dialogStage = dialogStage;
    }

    public void setOperation(Operation operation) {
        this.operation = operation;

        dateField.setText(DateUtil.format(operation.getDate()));
        numberField.setText(operation.getNumber());
        sumField.setText(Double.toString(operation.getSum()));
        transactionTypeField.setText(operation.getTransactionType());
        inputBalanceField.setText(Double.toString(operation.getInputBalance()));
        outputBalanceField.setText(Double.toString(operation.getOutputBalance()));
    }

    public boolean isOkClicked() {
        return okClicked;
    }

    @FXML
    private void handleOk() {
        if (isInputValid()) {
            operation.setDate(DateUtil.parse(dateField.getText()));
            operation.setNumber(numberField.getText());
            operation.setSum(Double.parseDouble(sumField.getText()));
            operation.setTransactionType(transactionTypeField.getText());
            operation.setInputBalance(Double.parseDouble(inputBalanceField.getText()));
            operation.setOutputBalance(Double.parseDouble(outputBalanceField.getText()));

            okClicked = true;
            dialogStage.close();
        }
    }

    @FXML
    private void handleCancel() {
        dialogStage.close();
    }

    private boolean isInputValid() {
        String errorMessage = "";

        if (dateField.getText() == null || dateField.getText().isEmpty()) {
            errorMessage += "No valid date!\n";
        } else {
            if (!DateUtil.validDate(dateField.getText())) {
                errorMessage += "Invalid date format. Please use the format dd.mm.yyyy!\n";
            }
        }

        if (numberField.getText() == null || numberField.getText().isEmpty()) {
            errorMessage += "No valid number!\n";
        }

        if (sumField.getText() == null || sumField.getText().isEmpty()) {
            errorMessage += "No valid sum!\n";
        } else {
            try {
                Double.parseDouble(sumField.getText());
            } catch (NumberFormatException e) {
                errorMessage += "Invalid sum. Please enter a valid number!\n";
            }
        }

        if (transactionTypeField.getText() == null || transactionTypeField.getText().isEmpty()) {
            errorMessage += "No valid transaction type!\n";
        }

        if (inputBalanceField.getText() == null || inputBalanceField.getText().isEmpty()) {
            errorMessage += "No valid input balance!\n";
        } else {
            try {
                Double.parseDouble(inputBalanceField.getText());
            } catch (NumberFormatException e) {
                errorMessage += "Invalid input balance. Please enter a valid number!\n";
            }
        }

        if (outputBalanceField.getText() == null || outputBalanceField.getText().isEmpty()) {
            errorMessage += "No valid output balance!\n";
        } else {
            try {
                Double.parseDouble(outputBalanceField.getText());
            } catch (NumberFormatException e) {
                errorMessage += "Invalid output balance. Please enter a valid number!\n";
            }
        }

        if (errorMessage.isEmpty()) {
            return true;
        } else {
            Alert alert = new Alert(AlertType.ERROR);
            alert.initOwner(dialogStage);
            alert.setTitle("Invalid Fields");
            alert.setHeaderText("Please correct invalid fields");
            alert.setContentText(errorMessage);

            alert.showAndWait();

            return false;
        }
    }
}

