package symulator;

public class Sprzęgło extends Komponent {
    public boolean stanSprzęgła;
    public Sprzęgło() {
        this.stanSprzęgła = false;
    }
    public void wciśnij() {
        this.stanSprzęgła = true;
    }
    public void zwolnij() {
        this.stanSprzęgła = false;
    }
}
