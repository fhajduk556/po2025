package symulator;

public class Pozycja {
    private double x;
    private double y;
    public Pozycja(double x, double y) {
        this.x = x;
        this.y = y;
    }
    public void aktualizacja(double deltaX, double deltaY) {
        this.x = this.x + deltaX;
        this.y = this.y + deltaY;
    }
    public String getPozycja() {
        return String.valueOf(x) + "," + String.valueOf(y);
    }
    public void przenies(Pozycja cel, float V) {
        float docelu_x = (float)(cel.x - this.x);
        float docelu_y = (float)(cel.y - this.y);
        float odleglosc = (float) Math.sqrt(docelu_y*docelu_y + docelu_x*docelu_x);
        float wersor_x = (float)(cel.x - this.x)/odleglosc;
        float wersor_y = (float)(cel.y - this.y)/odleglosc;

    }
}
