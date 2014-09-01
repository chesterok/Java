public class PointMain {
    public static void main(String[] args) throws CloneNotSupportedException {
        Point a = new Point(3, 5);
        Point b = new Point(5, 8);
        Point c = b.clone();
        Point d = new Point();

        System.out.println("a:" + a);
        System.out.println("b:" + b);
        System.out.println("c:" + c);
        System.out.println("d:" + d);

        c.setX(55);

        System.out.println("\nset C! c:" + c);

        if ( a.equals(b) ) {
            System.out.println( "a:" + a + " is equal to b:" + b );
        } else {
            System.out.println( "a:" + a + " is not equal to b:" + b );
        }

        System.out.println("distance between A and B: " + a.distance(b));
    }
}
