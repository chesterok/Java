public class ComplexMain {
    public static void main(String[] args) throws CloneNotSupportedException {
        Complex a = new Complex(4, -6);
        Complex b = new Complex(1, -3);
        Complex c = b.clone();
        Complex d = new Complex();

        System.out.println("a: " + a);
        System.out.println("b: " + b);
        System.out.println("c: " + c);
        System.out.println("d: " + d);

        if ( a.equals(b) ) {
            System.out.println( "a:" + a + " is equal to b:" + b );
        } else {
            System.out.println( "a:" + a + " is not equal to b:" + b );
        }

        System.out.println("sum(a, b): " + a.sum(b));
        System.out.println("diff(a, b): " + a.diff(b));

        a = a.sum(b);
        System.out.println("increment a += b: " + a);

        a = a.diff(b);
        System.out.println("decrement a -= b: " + a);

        System.out.println("Complex ABS: " + a.complexAbs());
    }
}
