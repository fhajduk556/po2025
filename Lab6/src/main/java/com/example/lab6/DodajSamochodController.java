package com.example.lab6;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import symulator.Silnik;
import symulator.SkrzyniaBiegów;


public class DodajSamochodController {
    @FXML private TextField modelAddTextField;
    @FXML private TextField nrRejestracyjnyAddTextField;
    @FXML private TextField wagaAddTextField;
    @FXML private TextField speedAddTextField;

    @FXML private ComboBox<Silnik> SilnikComboBox;
    @FXML private ComboBox<SkrzyniaBiegów> SkrzyniaComboBox;

    @FXML private Button confirmButton;
    @FXML private Button cancelButton;

    public void initialize() {
        ObservableList<Silnik> dostepneSilniki = FXCollections.observableArrayList(
                new Silnik("Diesel 1.9 TDI", 4500),
                new Silnik("Benzyna 2.0 Turbo", 7000),
                new Silnik("V8 Mustang", 8000),
                new Silnik("Silnik z kosiarki", 3000)
        );
        SilnikComboBox.setItems(dostepneSilniki);
        SilnikComboBox.getSelectionModel().selectFirst();

        ObservableList<SkrzyniaBiegów> dostepneSkrzynie = FXCollections.observableArrayList(
                new SkrzyniaBiegów("Manualna (5)", 5),
                new SkrzyniaBiegów("Sportowa (6)", 6),
                new SkrzyniaBiegów("Automat Truck (12)", 12)
        );
        SkrzyniaComboBox.setItems(dostepneSkrzynie);
        SkrzyniaComboBox.getSelectionModel().selectFirst();
    }

    @FXML
    private void onConfirmButton() {
        String model = modelAddTextField.getText();
        String registration = nrRejestracyjnyAddTextField.getText();
        double weight;
        int speed;
        try {
            weight = Double.parseDouble(wagaAddTextField.getText());
            speed = Integer.parseInt(speedAddTextField.getText());
        } catch (NumberFormatException e) {
            System.out.println("Niepoprawne dane. Spróbuj ponownie.");
            return;
        }

        Silnik wybranySilnik = SilnikComboBox.getValue();
        SkrzyniaBiegów wybranaSkrzynia = SkrzyniaComboBox.getValue();

        HelloController.addCarToList(model, registration, weight, speed, wybranySilnik, wybranaSkrzynia);
        Stage stage = (Stage) confirmButton.getScene().getWindow();
        stage.close();
    }
    @FXML
    private void onCancelButton() {
        Stage stage = (Stage) cancelButton.getScene().getWindow();
        stage.close();
    }
}