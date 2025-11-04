package symulator;

public class Silnik extends Komponent {
    private int maxObroty;
    private int obroty;
    public Silnik() {
        this.maxObroty = 9000;
        this.obroty = 0;
    }
    public void uruchom() {
        this.obroty = 200;
    }
    public void zatrzymaj() {
        this.obroty = 0;
    }
}
