public class Mohican {
    private Mohican prev;
    private Mohican next;
    private String name;  
    private static Mohican lastMohican;

    public Mohican(String name) {
        this.name = name;

        if ( lastMohican != null ) {
            prev = lastMohican;
            prev.next = this;
        }
        lastMohican = this;

    }

    public static Mohican getLastMohican() {
        return lastMohican;
    }

    protected void finalize() throws Throwable {
        if ( lastMohican == this ) {
            lastMohican = prev;
        } else {
            next.prev = prev;
            prev.next = next;
        }
        super.finalize();
    }

    public void destroy() throws Throwable {
        this.finalize();
    }

    public String getName() {
        return name;
    }

    public String toString() {
        return name;
    }

}
