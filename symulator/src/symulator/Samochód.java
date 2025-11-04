package symulator;

public class Samochód {
    private Silnik silnik;
    private SkrzyniaBiegów skrzynia;
    private Pozycja aktualnaPozycja;
    private boolean stanWłączenia;
    private String nrRejestr;
    private String model;
    private int predkoscMax;
    public void włącz() {
        this.silnik.uruchom();
    }
    public void wyłącz() {
        this.silnik.zatrzymaj();
    }
    public void JedźDo(Pozycja cel) {
        //
    }

}
