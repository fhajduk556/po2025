package symulator;

public class SkrzyniaBiegów extends Komponent {
    private int aktualnyBieg;
    private float aktualnePrzelozenie;
    private int iloscBiegow;
    public Sprzęgło sprzeglo;

    public SkrzyniaBiegów(int iloscBiegow) {
        super();
        this.aktualnyBieg = 1;  //bieg 0 to wsteczny
        this.iloscBiegow = iloscBiegow + 1;
        this.sprzeglo = new Sprzęgło();
    }

    public SkrzyniaBiegów(String nazwa, int iloscBiegow) {
        super(nazwa);
        this.aktualnyBieg = 1;
        this.iloscBiegow = iloscBiegow + 1;
        this.sprzeglo = new Sprzęgło();
    }

    public SkrzyniaBiegów(String nazwa, String producent, String model, int iloscBiegow) {
        super(nazwa, producent, model);
        this.aktualnyBieg = 1;
        this.iloscBiegow = iloscBiegow + 1;
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
        if (this.aktualnyBieg > 0) {
            this.aktualnePrzelozenie = (float) this.aktualnyBieg * 0.1f;
        } else {
            this.aktualnePrzelozenie = (float) -1 * 0.1f;
        }

        return this.aktualnePrzelozenie;
    }
}
