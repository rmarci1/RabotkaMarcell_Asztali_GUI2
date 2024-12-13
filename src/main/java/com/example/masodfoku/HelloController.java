package com.example.masodfoku;

import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

public class HelloController {
    @FXML
    private TextField input_field1;
    @FXML
    private TextField input_field2;
    @FXML
    private TextField input_field3;
    @FXML
    private Label kiirat;


    @FXML
    protected void Onszamol() {
        try{

            if(input_field1.getText().isEmpty() || input_field2.getText().isEmpty() || input_field3.getText().isEmpty()){
                throw new IllegalArgumentException("Minden mező kitöltése kötelező");
            }
            double a = Double.parseDouble(input_field1.getText());
            double b = Double.parseDouble(input_field2.getText());
            double c = Double.parseDouble(input_field3.getText());
            if (a == 0) {
                throw new IllegalArgumentException("Az 'A' nem lehet nulla, mert nem másodfokú egyenlet.");
            }
            double discriminant = b * b - 4 * a * c;
            if (discriminant < 0) {
                kiirat.setText("Nem oldható meg a valós számok halmazán.");
            } else if (discriminant == 0) {
                double x = -b / (2 * a);
                kiirat.setText("x = " + x);
            } else {
                double x1 = (-b + Math.sqrt(discriminant)) / (2 * a);
                double x2 = (-b - Math.sqrt(discriminant)) / (2 * a);
                kiirat.setText("x1 = " + x1 + ", x2 = " + x2);
            }

        }
        catch (NumberFormatException e){
            showAlert("Hibás adat", "Csak számokat adjon meg");
        }
        catch (IllegalArgumentException e){
            showAlert("Hiba",e.getMessage());
        }
    }
    private void showAlert(String title, String message){
        Alert alert = new Alert(Alert.AlertType.ERROR);
        alert.setTitle(title);
        alert.setContentText(message);
        alert.showAndWait();
    }
}