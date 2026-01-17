package symulator;

public abstract class Komponent {
    private String producent;
    private String model;
    private String nazwa;

    public Komponent() {
        this.nazwa = "Nieznany";
        this.producent = "Nieznany";
        this.model = "Nieznany";
    }

    public Komponent(String nazwa) {
        this.nazwa = nazwa;
        this.producent = "Nieznany";
        this.model = "Nieznany";
    }

    public Komponent(String nazwa, String producent, String model) {
        this.nazwa = nazwa;
        this.producent = producent;
        this.model = model;
    }

    public String getProducent() {
        return producent;
    }
    public String getModel() {
        return model;
    }
    public String getNazwa() {
        return nazwa;
    }

    @Override
    public String toString() {
        return nazwa;
    }
}
