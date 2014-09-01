public class PMain {
    public static void main(String[] args) throws CloneNotSupportedException {
        Point a = new Point(2, 8);
        Point b = new Point(2, 8);
        Point c = b.clone();

        System.out.println("b:" + b);
        System.out.println("c:" + c);

        c.setY(42);

        System.out.println("b:" + b);
        System.out.println("c:" + c); 

        if ( a.equals(b) ) {
            System.out.println("points are equals");
        } else {
            System.out.println("points are not equals");
        }
    }
}
