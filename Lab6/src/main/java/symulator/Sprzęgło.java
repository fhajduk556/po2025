package symulator;

public class Sprzęgło extends Komponent {
    public boolean stanSprzęgła;
    public Sprzęgło() {
        this.stanSprzęgła = false;
    }
    void wciśnij() {
        this.stanSprzęgła = true;
    }
    void zwolnij() {
        this.stanSprzęgła = false;
    }
}
