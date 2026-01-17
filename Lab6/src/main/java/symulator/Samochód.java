package symulator;

public class Samochód {
    public Silnik silnik;
    public SkrzyniaBiegów skrzynia;
    public Pozycja aktualnaPozycja;
    public boolean stanWłączenia;
    public String nrRejestr;
    public String model;
    public int predkoscMax;
    public double waga;
    public Samochód(){
        this.silnik = new Silnik();
        this.skrzynia = new SkrzyniaBiegów(6);
        this.predkoscMax = 250;
        this.stanWłączenia = false;
        aktualnaPozycja = new Pozycja(0, 0);
        this.model = "Nieznany";
        this.nrRejestr = "BRAK";
        this.waga = 1000.0;
    }

    public Samochód(String model, String nrRejestr, double waga, int predkoscMax,
                    Silnik silnik, SkrzyniaBiegów skrzynia) {
        this();
        this.model = model;
        this.nrRejestr = nrRejestr;
        this.waga = waga;
        this.predkoscMax = predkoscMax;
        this.silnik = silnik;
        this.skrzynia = skrzynia;
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

    public double getAktPredkosc() {
        double teor_predkosc = (double) this.silnik.obroty * this.skrzynia.getAktPrzelozenie();
        if (teor_predkosc > this.predkoscMax) {
            return this.predkoscMax;
        } else {
            return teor_predkosc;
        }
    }
    public Pozycja getAktPozycja() {
        return this.aktualnaPozycja;
    }

    @Override
    public String toString() {
        return model + " (" + nrRejestr + ")";
    }
}
