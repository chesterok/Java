public class Vector implements Cloneable {
    protected double x, y;

    public Vector(double x, double y) {
        this.x = x;
        this.y = y;
    }

    public Vector() {
        this(0.0, 0.0);
    }

    public double getX() {
        return x;
    }

    public double getY() {
        return y;
    }

    public void setY(double value) {
        y = value;
    }

    public void setX(double value) {
        x = value;
    }

    public double distance() {
        return Math.hypot(x, y);
    }

    public boolean equals(Vector other) {
        return x == other.x && y == other.y;
    }

    public void vectorIncrement(Vector other) {
        x += other.x;
        y += other.y;
    }

    public void vectorDecrement(Vector other) {
        x -= other.x;
        y -= other.y;
    }

    public Vector sum(Vector other) throws CloneNotSupportedException {
        Vector sum = this.clone();

        sum.vectorIncrement(other);

        return sum;
    }

    public Vector diff(Vector other) throws CloneNotSupportedException {
        Vector diff = this.clone();

        diff.vectorDecrement(other);

        return diff;
    }

    public String toString() {
        return "(" + x + ", " + y + ")";
    }

    public Vector clone() throws CloneNotSupportedException {
        return (Vector)super.clone();
    }
}
