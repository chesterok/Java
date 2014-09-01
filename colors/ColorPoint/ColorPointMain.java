public class ColorPointMain {
    public static void main(String[] args) {
        Point a = new Point(2, 2);
        Point b = new Point(4, 9);
        Point c = new Point();
        ColorPoint z = new ColorPoint("Red", 1, 2);
        ColorPoint x = new ColorPoint("Green", 1, 2);

        if ( z.equals(b) ) {
            System.out.println(z + " is equal to " + b);
        } else {
            System.out.println(z + " is not equal to " + b);
        }


        System.out.println("Distance: " + z.distance(b));
        System.out.println("a:" + a);
        System.out.println("b:" + b);
        System.out.println("c:" + c);
    }
}
