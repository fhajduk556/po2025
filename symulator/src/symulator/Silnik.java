package symulator;

public class Silnik extends Komponent {
    public int maxObroty;
    public int obroty;
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
    public void zwiększObroty() {
        if (this.obroty < this.maxObroty) {
            this.obroty = this.obroty + 500;
        }
    }
    public void zmniejszObroty() {
        if (this.obroty > 200) {
            this.obroty = this.obroty - 500;
        }
    }
}
