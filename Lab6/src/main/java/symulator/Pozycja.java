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

    public double getX() { return x; }
    public double getY() { return y; }

    public void przenies(Pozycja cel, double V, double dt) {
        double dx = cel.x - this.x;
        double dy = cel.y - this.y;
        double odleglosc = Math.sqrt(dx * dx + dy * dy);
        if (odleglosc < 0.0001) {
            this.x = cel.x;
            this.y = cel.y;
            return;
        }
        double krok = V * dt;
        if (krok >= odleglosc) {
            this.x = cel.x;
            this.y = cel.y;
        } else {
            double wersor_x = dx / odleglosc;
            double wersor_y = dy / odleglosc;
            this.x += wersor_x * krok;
            this.y += wersor_y * krok;
        }
    }
}
