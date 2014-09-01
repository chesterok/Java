public class Countable {
    private static int counter = 0;

    public Countable() {
        counter += 1;
    }

    public static int getCounter() {
        return counter;
    }

    protected void finalize() throws Throwable {
        counter -= 1;
        super.finalize();
    }

    public void destroy() throws Throwable {
        this.finalize();
    }


}
