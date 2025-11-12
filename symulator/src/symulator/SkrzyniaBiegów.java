package symulator;

public class SkrzyniaBiegów extends Komponent {
    private int aktualnyBieg;
    private float aktualnePrzelozenie;
    private int iloscBiegow;
    public Sprzęgło sprzeglo;
    public SkrzyniaBiegów() {
        this.aktualnyBieg = 1;  //bieg 0 to wsteczny
        this.iloscBiegow = 6;
        this.sprzeglo = new Sprzęgło();
    }
    public void zwiększBieg() {
        if (this.aktualnyBieg  < this.iloscBiegow - 1) {
            this.sprzeglo.wciśnij();
            this.aktualnyBieg++;
            this.sprzeglo.zwolnij();
        }
    }
    public void zmniejszBieg() {
        if (this.aktualnyBieg > 0) {
            this.sprzeglo.wciśnij();
            this.aktualnyBieg--;
            this.sprzeglo.zwolnij();
        }
    }
    public int getAktualnyBieg() {
        return this.aktualnyBieg;
    }
    public float getAktPrzelozenie() {
        this.aktualnePrzelozenie = (float) this.aktualnyBieg * 0.1f;
        return this.aktualnePrzelozenie;
    }
}
