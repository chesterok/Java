public class CountableMain {
    public static void main(String[] args) throws Throwable {
        Countable a = new Countable();
        Countable b = new Countable();
        Countable c = new Countable();

        c.destroy();

        System.out.println("Quantity: " + Countable.getCounter());

    } 
}
