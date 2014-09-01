public class Identifiable {
    private int id;
    private static int lastId = 0;

    public Identifiable() {
        lastId += 1;
        id = lastId;
    }

    public int getId() {
        return id;
    }
}
