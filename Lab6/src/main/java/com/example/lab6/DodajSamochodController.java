package com.example.lab6;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextField;
import javafx.stage.Stage;


public class DodajSamochodController {
    @FXML
    private TextField modelAddTextField;
    @FXML
    private TextField nrRejestracyjnyAddTextField;
    @FXML
    private TextField wagaAddTextField;
    @FXML
    private TextField speedAddTextField;

    @FXML
    private void onConfirmButton() {
        String model = modelAddTextField.getText();
        String registration = nrRejestracyjnyAddTextField.getText();
        double weight;
        int speed;
        try {
            weight = Double.parseDouble(wagaAddTextField.getText());
            speed = Integer.parseInt(speedTextField.getText());
        } catch (NumberFormatException e) {
            System.out.println("Niepoprawne dane. Spróbuj ponownie.");
            return;
        }
        MainController.addCarToList(model, registration, weight, speed);
        Stage stage = (Stage) confirmButton.getScene().getWindow();
        stage.close();
    }
}