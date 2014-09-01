public class ColorVectorMain {
    public static void main(String[] args) throws CloneNotSupportedException {
        Vector a = new Vector(1, 2);
        Vector b = new Vector(3, 2);
        Vector c = new Vector();
        ColorVector x = new ColorVector("Red", 7, 2);
        ColorVector s = new ColorVector("Green", 7, 2);
        ColorVector w = new ColorVector();

        System.out.println(x);

        System.out.println("Vector len: " + x.distance());
        System.out.println(a);

    }
}
