package symulator;

public class SkrzyniaBiegów extends Komponent {
    private int aktualnyBieg;
    private int iloscBiegow;
    public SkrzyniaBiegów() {
        this.aktualnyBieg = 1;  //bieg 0 to wsteczny
        this.iloscBiegow = 6;
    }
    public void zwiększBieg() {
        if (this.aktualnyBieg  < this.iloscBiegow - 1) {
            this.aktualnyBieg++;
        }
    }
    public void zmniejszBieg() {
        if (this.aktualnyBieg > 0) {
            this.aktualnyBieg--;
        }
    }
}
