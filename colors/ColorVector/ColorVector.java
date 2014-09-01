public class ColorVector extends Vector implements Cloneable {
    private String color;

    public ColorVector(String color, double x, double y) {
        super(x, y);
        this.color = color;
    }

    public ColorVector() {
        this("Red", 0.0, 0.0);
    }

    public ColorVector clone() throws CloneNotSupportedException {
        return (ColorVector)super.clone();
    }

    public void vectorIncrement(ColorVector other) {
        StringBuffer temp = new StringBuffer(color);

        temp.append("+" + other.color);
        color = temp.toString();
        super.vectorIncrement(other);
    }

    public void vectorIncrement(Vector other) {
        super.vectorIncrement(other);
    }

    public void vectorDecrement(ColorVector other) {
        StringBuffer temp = new StringBuffer(color);

        temp.append("-" + other.color);
        color = temp.toString();
        super.vectorDecrement(other);
    }

    public void vectorDecrement(Vector other) {
        super.vectorDecrement(other);
    }

    public ColorVector sum(ColorVector other) throws CloneNotSupportedException {
        ColorVector sum = this.clone();

        sum.vectorIncrement(other);

        return sum;
    }

    public ColorVector sum(Vector other) throws CloneNotSupportedException {
        ColorVector sum = this.clone();

        sum.vectorIncrement(other);

        return sum;
    }

    public ColorVector diff(ColorVector other) throws CloneNotSupportedException {
        ColorVector diff = this.clone();

        System.out.println("--- " + diff);
        System.out.println("*** " + other);


        diff.vectorDecrement(other);

        return diff;
    }

    public ColorVector diff(Vector other) throws CloneNotSupportedException {
        ColorVector diff = this.clone();

        diff.vectorDecrement(other);

        return diff;
    }

    public boolean equals(ColorVector other) {
        return x == other.x && y == other.y && color  == other.color;
    }

    public boolean equals(Vector other) {
        return super.equals(other);
    }

    public String toString() {
        return super.toString() + " " + color;
    }
}
