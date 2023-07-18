package smth.Units;

public class Coordinates{

    protected double X;
    protected double Y;

    public Coordinates(int x, int y) {
        this.X = x;
        this.Y = y;
    }

    @Override
    public String toString() {
        return X + ", " + Y;
    }
}
