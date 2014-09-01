public class ColorPoint extends Point {
    public String color;

    public ColorPoint(String color, double x, double y) {
        super(x, y);
        this.color = color;
    }

    public ColorPoint() {
        this("Red", 0.0, 0.0);
    }

    public String getColor() {
        return color;
    }

    public String toString() {
        return super.toString() + " " + color;
    }

    public boolean equals(ColorPoint other) {
        return x == other.x && y == other.y && color  == other.color;
    }

    public boolean equals(Point other) {
        return super.equals(other);
    }
}
