public class MohicanMain {
    public static void main(String[] args) throws Throwable {
        Mohican m1 = new Mohican("m1");
        Mohican m2 = new Mohican("m2");
        Mohican m3 = new Mohican("m3");
        Mohican m4 = new Mohican("m4");
        Mohican m5 = new Mohican("m5");

        m3.destroy();
        m4.destroy();
        m5.destroy();

        Mohican m6 = new Mohican("m6");

        m6.destroy();

        System.out.println(Mohican.getLastMohican());
    }
}
