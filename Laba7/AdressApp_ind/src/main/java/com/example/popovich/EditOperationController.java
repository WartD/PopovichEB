package com.example.popovich;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

public class EditOperationController {
    @FXML
    private TextField text_date, text_input, text_num, text_output, text_sum, text_type;

    private Stage dialog;

    private Operation operations;

    @FXML
    void edit(ActionEvent event) {
        if(!text_num.getText().isEmpty() && !text_date.getText().isEmpty() && !text_sum.getText().isEmpty()
                && !text_type.getText().isEmpty() && !text_input.getText().isEmpty() && !text_output.getText().isEmpty()){
            operations.setNumber(text_num.getText());
            operations.setDate(text_date.getText());
            operations.setSum(text_sum.getText());
            operations.setTransactionType(text_type.getText());
            operations.setInputBalance(text_input.getText());
            operations.setOutputBalance(text_output.getText());
            dialog.close();}
        else {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.initOwner(dialog);
            alert.setTitle("Пустое поле!");
            alert.setHeaderText("Одно или несколько полей пусты!");
            alert.showAndWait();
        }
    }

    @FXML
    void cancel(ActionEvent event) {
        dialog.close();
    }

    public void getDialogStage(Stage dialog){
        this.dialog = dialog;
    }

    public void getOperation(Operation operations){
        text_num.setText(operations.getNumber());
        text_date.setText(operations.getDate());
        text_sum.setText(operations.getSum());
        text_type.setText(operations.getTransactionType());
        text_input.setText(operations.getInputBalance());
        text_output.setText(operations.getOutputBalance());
        this.operations = operations;
    }
}
