package com.example.lab6;

import javafx.application.Platform;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;
import symulator.*;

import java.util.HashMap;
import java.util.Map;

public class HelloController implements Listener{

    @FXML private Pane mapa;

    @FXML private TextField modelTextField;
    @FXML private TextField plateTextField;
    @FXML private TextField weightTextField;
    @FXML private TextField speedTextField;

    @FXML private TextField gearboxNameTextField;
    @FXML private TextField gearTextField;

    @FXML private TextField engineNameTextField;
    @FXML private TextField rpmTextField;
    @FXML private TextField clutchStateTextField;

    @FXML private ComboBox<Samochód> carComboBox;

    @FXML private Button startButton;
    @FXML private Button stopButton;
    @FXML private Button gearUpButton;
    @FXML private Button gearDownButton;
    @FXML private Button gasAddButton;
    @FXML private Button gasRemoveButton;
    @FXML private Button clutchPressButton;
    @FXML private Button clutchReleaseButton;

    private static HelloController instance;

    private ObservableList<Samochód> listaSamochodow = FXCollections.observableArrayList();
    private Samochód aktywnySamochod;

    private Map<Samochód, ImageView> ikonySamochodow = new HashMap<>();
    private Image carImage;

    @FXML
    public void initialize() {
        instance = this;
        System.out.println("HelloController initialized");

        try {
            carImage = new Image(getClass().getResource("/images/car.png").toExternalForm());
        } catch (Exception e) {
            pokazBlad(e.getMessage());
        }
        carComboBox.setItems(listaSamochodow);

        mapa.setOnMouseClicked(event -> {
            if (aktywnySamochod != null) {
                double x = event.getX();
                double y = event.getY();
                System.out.println("Cel dla " + aktywnySamochod.model + ": " + x + ", " + y);

                Pozycja cel = new Pozycja(x - 15, y - 10);
                aktywnySamochod.JedźDo(cel);
            }
        });

        Silnik silnikStartowy = new Silnik("Diesel 1.9 TDI", 4500);
        SkrzyniaBiegów skrzyniaStartowa = new SkrzyniaBiegów("Manualna (5)", 5);
        addCarToList("VW Golf", "START", 1300.0, 190, silnikStartowy, skrzyniaStartowa);
        aktywnySamochod = listaSamochodow.get(0);
        odswiezWidok();

    }

    @Override
    public void update() {
        Platform.runLater(() -> {
            odswiezWidok();
        });
    }

    private void odswiezWidok() {
        for (Map.Entry<Samochód, ImageView> entry : ikonySamochodow.entrySet()) {
            Samochód auto = entry.getKey();
            ImageView icon = entry.getValue();

            Pozycja pos = auto.getAktPozycja();
            icon.setTranslateX(pos.getX());
            icon.setTranslateY(pos.getY());
        }

        if (aktywnySamochod == null) {
            modelTextField.setText("");
            plateTextField.setText("");
            weightTextField.setText("");
            speedTextField.setText("");
            gearboxNameTextField.setText("");
            gearTextField.setText("");
            engineNameTextField.setText("");
            rpmTextField.setText("");
            clutchStateTextField.setText("");
        }

        if (aktywnySamochod != null) {
            modelTextField.setText(aktywnySamochod.model);
            plateTextField.setText(aktywnySamochod.nrRejestr);
            weightTextField.setText(String.valueOf(aktywnySamochod.waga));

            speedTextField.setText(String.format("%.2f km/h", aktywnySamochod.getAktPredkosc()));

            if(aktywnySamochod.silnik != null) {
                engineNameTextField.setText(aktywnySamochod.silnik.getNazwa());
                rpmTextField.setText(String.valueOf(aktywnySamochod.silnik.obroty));
            }

            if(aktywnySamochod.skrzynia != null) {
                gearboxNameTextField.setText(aktywnySamochod.skrzynia.getNazwa());
                gearTextField.setText(String.valueOf(aktywnySamochod.skrzynia.getAktualnyBieg()));

                String sprzegloStatus = aktywnySamochod.skrzynia.sprzeglo.stanSprzęgła ? "Wciśnięte" : "Zwolnione";
                clutchStateTextField.setText(sprzegloStatus);
            }

            if (aktywnySamochod.stanWłączenia) {
                startButton.setDisable(true);
                stopButton.setDisable(false);
            } else {
                startButton.setDisable(false);
                stopButton.setDisable(true);
            }
        }
    }

    public static void pokazBlad(String wiadomosc) {
        Alert alert = new Alert(Alert.AlertType.ERROR);
        alert.setTitle("Błąd");
        alert.setHeaderText(null);
        alert.setContentText(wiadomosc);
        alert.showAndWait();
    }

    public static void addCarToList(String model, String registration, double weight,
                                    int speed, Silnik silnik, SkrzyniaBiegów skrzynia) {
        if (instance == null) return;
        Samochód noweAuto = new Samochód(model, registration, weight, speed, silnik, skrzynia);
        noweAuto.addListener(instance);
        instance.listaSamochodow.add(noweAuto);
        instance.stworzIkonkeDlaAuta(noweAuto);
        instance.carComboBox.getSelectionModel().select(noweAuto);
    }

    private void stworzIkonkeDlaAuta(Samochód auto) {
        ImageView icon = new ImageView();
        if (carImage != null) {
            icon.setImage(carImage);
        }
        icon.setFitWidth(40);
        icon.setFitHeight(25);
        icon.setPreserveRatio(true);

        icon.setTranslateX(auto.getAktPozycja().getX());
        icon.setTranslateY(auto.getAktPozycja().getY());

        ikonySamochodow.put(auto, icon);
        mapa.getChildren().add(icon);
    }

    @FXML private void onCarSelect() {
        aktywnySamochod = carComboBox.getValue();
        if (aktywnySamochod != null) {
            odswiezWidok();
        }
    }

    @FXML private void onStartButton() {
        if (aktywnySamochod != null) {
            aktywnySamochod.włącz();
            odswiezWidok();
        }
    }

    @FXML private void onStopButton() {
        if (aktywnySamochod != null) {
            aktywnySamochod.wyłącz();
            odswiezWidok();
        }
    }

    @FXML private void onGearUpButton() {
        if (aktywnySamochod != null) {
            aktywnySamochod.skrzynia.zwiększBieg();
            odswiezWidok();
        }
    }

    @FXML private void onGearDownButton() {
        if (aktywnySamochod != null) {
            aktywnySamochod.skrzynia.zmniejszBieg();
            odswiezWidok();
        }
    }

    @FXML private void onGasAddButton() {
        if (aktywnySamochod != null && aktywnySamochod.stanWłączenia) {
            aktywnySamochod.silnik.zwiększObroty();
            odswiezWidok();
        }
    }

    @FXML private void onGasRemoveButton() {
        if (aktywnySamochod != null && aktywnySamochod.stanWłączenia) {
            aktywnySamochod.silnik.zmniejszObroty();
            odswiezWidok();
        }
    }

    @FXML private void onClutchPressButton() {
        if (aktywnySamochod != null) {
            aktywnySamochod.skrzynia.sprzeglo.wciśnij();
            odswiezWidok();
        }
    }

    @FXML private void onClutchReleaseButton() {
        if (aktywnySamochod != null) {
            aktywnySamochod.skrzynia.sprzeglo.zwolnij();
            odswiezWidok();
        }
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
            pokazBlad("Nie udało się otworzyć okna: " + e.getMessage());
        }
    }

    @FXML
    private void onDeleteCarButton() {
        if (aktywnySamochod != null) {
            aktywnySamochod.wyłącz();

            ImageView icon = ikonySamochodow.get(aktywnySamochod);
            mapa.getChildren().remove(icon);
            ikonySamochodow.remove(aktywnySamochod);

            listaSamochodow.remove(aktywnySamochod);
            carComboBox.getSelectionModel().clearSelection();

            aktywnySamochod = null;
            odswiezWidok();
        }
    }

}
