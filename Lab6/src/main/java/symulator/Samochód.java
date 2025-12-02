package symulator;

public class Samochód {
    public Silnik silnik;
    public SkrzyniaBiegów skrzynia;
    public Pozycja aktualnaPozycja;
    public boolean stanWłączenia;
    public String nrRejestr;
    public String model;
    public int predkoscMax;
    public Samochód(){
        this.silnik = new Silnik();
        this.skrzynia = new SkrzyniaBiegów();
        this.predkoscMax = 250;
        this.stanWłączenia = false;
        aktualnaPozycja = new Pozycja(0, 0);
    }
    public void włącz() {
        this.silnik.uruchom();
        this.stanWłączenia = true;
    }
    public void wyłącz() {
        this.silnik.zatrzymaj();
        this.stanWłączenia = false;
    }
    public void JedźDo(Pozycja cel) {
        //
    }
    public float getAktPredkosc() {
        float teor_predkosc = (float) this.silnik.obroty * this.skrzynia.getAktPrzelozenie();
        if (teor_predkosc > this.predkoscMax) {
            return this.predkoscMax;
        } else {
            return teor_predkosc;
        }
    }
    public Pozycja getAktPozycja() {
        return this.aktualnaPozycja;
    }

}
