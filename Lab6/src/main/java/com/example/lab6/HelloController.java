package com.example.lab6;

import javafx.fxml.FXML;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextField;
import javafx.event.ActionEvent;
public class HelloController {

    @FXML private TextField modelTextField;
    @FXML private TextField plateTextField;
    @FXML private TextField weightTextField;
    @FXML private TextField speedTextField;

    @FXML private TextField gearboxNameTextField;
    @FXML private TextField gearboxPriceTextField;
    @FXML private TextField gearboxWeightTextField;
    @FXML private TextField gearTextField;

    @FXML private TextField engineNameTextField;
    @FXML private TextField enginePriceTextField;
    @FXML private TextField engineWeightTextField;
    @FXML private TextField rpmTextField;

    @FXML private ComboBox<String> carComboBox; //do zmiany na typ Samochód
    @FXML private Button startButton;
    @FXML private Button stopButton;
    @FXML private Button gearUpButton;
    @FXML private Button gearDownButton;

    @FXML
    private void onStartButton() {
        System.out.println("Samochód uruchomiony (Włącz)");
        // kod uruchomienia samochodu
    }

    @FXML
    private void onStopButton() {
        System.out.println("Samochód zatrzymany (Wyłącz)");
        // kod zatrzymania samochodu
    }

    @FXML
    private void onGearUpButton() {
        System.out.println("gearup");
    }

    @FXML
    private void onGearDownButton() {
        System.out.println("geardown");
    }

    @FXML
    private void onGasAddButton() {
        System.out.println("Dodano gazu");
    }

    @FXML
    private void onGasRemoveButton() {
        System.out.println("Ujęto gazu");
    }

    @FXML
    private void onClutchPressButton() {
        System.out.println("Clutch press");
    }

    @FXML
    private void onClutchReleaseButton() {
        System.out.println("Clutch release");
    }

    @FXML
    private void onAddCarButton() {
        System.out.println("Dodano auto");
    }

    @FXML
    private void onDeleteCarButton() {
        System.out.println("Usunięto auto");
    }

}
