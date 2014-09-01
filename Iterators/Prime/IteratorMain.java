public class IteratorMain {
    public static void main(String[] args) throws InvalidIndexException {
        Iterator seq = new Iterator(20);

        for ( ; !seq.over(); seq.next() ) {
            System.out.print(seq.getValue() + " ");
        }
        System.out.println(seq.getValue());
    }
}
