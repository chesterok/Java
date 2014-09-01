public class VectorMain {
    public static void main(String[] args) throws CloneNotSupportedException {
        Vector a = new Vector(4, 6);
        Vector b = new Vector(1, 3);
        Vector c = b.clone();
        Vector d = new Vector();

        System.out.println("a: " + a);
        System.out.println("b: " + b);
        System.out.println("c: " + c);
        System.out.println("d: " + d);

        if ( a.equals(b) ) {
            System.out.println( "a:" + a + " is equal to b:" + b );
        } else {
            System.out.println( "a:" + a + " is not equal to b:" + b );
        }

        System.out.println("distance a: " + a.distance());
        System.out.println("sum(a, b): " + a.sum(b));
        System.out.println("diff(a, b): " + a.diff(b));

        a = a.sum(b);
        System.out.println("increment a += b: " + a);

        a = a.diff(b);
        System.out.println("decrement a -= b: " + a);
    }
}
