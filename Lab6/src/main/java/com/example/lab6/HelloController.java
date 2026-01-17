package com.example.lab6;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextField;
import javafx.event.ActionEvent;
import javafx.stage.Stage;
import symulator.Samochód;
import symulator.Silnik;
import symulator.SkrzyniaBiegów;

public class HelloController {

    @FXML public ImageView carImageView;
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

    @FXML private ComboBox<Samochód> carComboBox;
    @FXML private Button startButton;
    @FXML private Button stopButton;
    @FXML private Button gearUpButton;
    @FXML private Button gearDownButton;

    private static HelloController instance;

    private ObservableList<Samochód> listaSamochodow = FXCollections.observableArrayList();
    private Samochód aktywnySamochod;

    @FXML
    public void initialize() {
        instance = this;
        System.out.println("HelloController initialized");
// Load and set the car image
        Image carImage = new Image(getClass().getResource("/images/car.png").toExternalForm());
        System.out.println("Image width: " + carImage.getWidth() + ", height: " + carImage.getHeight());
        carImageView.setImage(carImage);
        carImageView.setFitWidth(30);
        carImageView.setFitHeight(20);
        carImageView.setTranslateX(0);
        carImageView.setTranslateY(0);
//        Samochód s1 = new Samochód("Fiat 126p", "KR 12345");
//        Samochód s2 = new Samochód("Porsche 911", "W0 ROCKET");
//        listaSamochodow.add(s1);
//        listaSamochodow.add(s2);
        carComboBox.setItems(listaSamochodow);
    }

    private void odswiezWidok() {
        if (aktywnySamochod == null) return;
        modelTextField.setText(aktywnySamochod.model);
        plateTextField.setText(aktywnySamochod.nrRejestr);
        speedTextField.setText(String.format("%.2f km/h", aktywnySamochod.getAktPredkosc()));
        rpmTextField.setText(String.valueOf(aktywnySamochod.silnik.obroty));
        gearTextField.setText(String.valueOf(aktywnySamochod.skrzynia.getAktualnyBieg()));
    }

    public static void addCarToList(String model, String registration, double weight,
                                    int speed, Silnik silnik, SkrzyniaBiegów skrzynia) {
        if (instance == null) return;
        Samochód noweAuto = new Samochód(model, registration, weight, speed, silnik, skrzynia);
        instance.listaSamochodow.add(noweAuto);
        System.out.println("Dodano auto: " + model);
    }

    @FXML
    private void onCarSelect() {
        aktywnySamochod = carComboBox.getValue();
        odswiezWidok();
        System.out.println("Wybrano auto: " + aktywnySamochod);
    }

    @FXML
    private void onStartButton() {
        if (aktywnySamochod != null) {
            System.out.println("Włączam samochód: " + aktywnySamochod.model);
            aktywnySamochod.włącz();
            odswiezWidok();
        }
    }

    @FXML
    private void onStopButton() {
        if (aktywnySamochod != null) {
            System.out.println("Wyłączam samochód: " + aktywnySamochod.model);
            aktywnySamochod.wyłącz();
            odswiezWidok();
        }
    }

    @FXML
    private void onGearUpButton() {
        if (aktywnySamochod != null) {
            aktywnySamochod.skrzynia.zwiększBieg();
            System.out.println("Bieg w górę -> " + aktywnySamochod.skrzynia.getAktualnyBieg());
            odswiezWidok();
        }
    }

    @FXML
    private void onGearDownButton() {
        if (aktywnySamochod != null) {
            aktywnySamochod.skrzynia.zmniejszBieg();
            System.out.println("Bieg w dół -> " + aktywnySamochod.skrzynia.getAktualnyBieg());
            odswiezWidok();
        }
    }

    @FXML
    private void onGasAddButton() {
        if (aktywnySamochod != null && aktywnySamochod.stanWłączenia) {
            aktywnySamochod.silnik.zwiększObroty();
            odswiezWidok();
        }
    }

    @FXML
    private void onGasRemoveButton() {
        if (aktywnySamochod != null && aktywnySamochod.stanWłączenia) {
            aktywnySamochod.silnik.zmniejszObroty();
            odswiezWidok();
        }
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
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("DodajSamochod.fxml"));
            Stage stage = new Stage();
            stage.setTitle("Dodaj nowy samochód");
            stage.setScene(new Scene(loader.load()));
            stage.show();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @FXML
    private void onDeleteCarButton() {
        if (aktywnySamochod != null) {
            listaSamochodow.remove(aktywnySamochod);
            aktywnySamochod = null;
            modelTextField.clear();
            plateTextField.clear();
            //reszta czyszczenia
        }
    }

}
