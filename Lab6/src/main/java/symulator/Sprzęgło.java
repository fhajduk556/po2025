package symulator;

public class Sprzęgło extends Komponent {
    public boolean stanSprzęgła; // true == wciśnięte
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
