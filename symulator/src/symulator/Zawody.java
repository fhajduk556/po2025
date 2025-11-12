package symulator;

public class Zawody {
    private Samochód[] uczestnicy;
    private String nazwa;
    private String data;
    public Zawody() {
        this.uczestnicy = new Samochód[2];
        this.uczestnicy[0] = new Samochód();
        this.nazwa = "wyścigi";
        this.data = "04.11.2025";
    }
    public void rozegrajZawody() {
        //zawody
    }

    public static void main(String[] args) {
        Zawody wyscig = new Zawody();
        wyscig.uczestnicy[0].włącz();
        wyscig.uczestnicy[0].silnik.zwiększObroty();
        wyscig.uczestnicy[0].silnik.zwiększObroty();
        wyscig.uczestnicy[0].skrzynia.zwiększBieg();
        wyscig.uczestnicy[0].silnik.zwiększObroty();
        wyscig.uczestnicy[0].skrzynia.zwiększBieg();
        wyscig.uczestnicy[0].skrzynia.zmniejszBieg();
        wyscig.uczestnicy[0].silnik.zmniejszObroty();
        System.out.println(wyscig.uczestnicy[0].silnik.obroty);
        System.out.println(wyscig.uczestnicy[0].skrzynia.getAktualnyBieg());
        System.out.println(wyscig.uczestnicy[0].getAktPredkosc());

    }

}
