package com.example.popovich;

import javafx.beans.value.ObservableDoubleValue;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

public class AddOperationController {
    @FXML
    private TextField text_date, text_input, text_num, text_output, text_sum, text_type;

    private Stage dialog;

    private ObservableList<Operation> operations = FXCollections.observableArrayList();

    @FXML
    void add(ActionEvent event) {
        if(!text_num.getText().isEmpty() && !text_date.getText().isEmpty() && !text_sum.getText().isEmpty()
                && !text_type.getText().isEmpty() && !text_input.getText().isEmpty() && !text_output.getText().isEmpty()){
            operations.add(new Operation(text_num.getText(),text_date.getText(), text_sum.getText(),
                    text_type.getText(),text_input.getText(),text_output.getText()));
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

    public void getOperation(ObservableList<Operation> operations){
        this.operations = operations;
    }
}
