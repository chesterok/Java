public class Complex implements Cloneable {
    private double real;
    private double imaginary;

    public Complex(double real, double imaginary) {
        this.real = real;
        this.imaginary = imaginary;
    }

    public Complex() {
        this(0.0, 0.0);
    }

    public double getReal() {
        return real;
    }

    public double getImaginary() {
        return imaginary;
    }

    public boolean equals(Complex other) {
        return real == other.real && imaginary == other.imaginary;
    }

    public Complex sum(Complex other) {
        Complex sum = new Complex(real, imaginary);

        sum.real += other.real;
        sum.imaginary += other.imaginary;

        return sum;
    }

    public Complex diff(Complex other) {
        Complex diff = new Complex(real, imaginary);

        diff.real -= other.real;
        diff.imaginary -= other.imaginary;

        return diff;
    }

    public Complex prod(Complex other) {
        Complex multiply = new Complex();

        multiply.real = real * other.real - imaginary * other.imaginary;
        multiply.imaginary = imaginary * other.real + real * other.imaginary;

        return multiply;
    }

    public double complexAbs() {
        return Math.hypot(real, imaginary);
    }

    public String toString() {
        if ( imaginary >= 0 ) {
           return "(" + real + "+" + imaginary + "i)";
        }
        return "(" + real + imaginary + "i)";
    }

    public Complex clone() throws CloneNotSupportedException {
        return (Complex) super.clone();
    }
}
