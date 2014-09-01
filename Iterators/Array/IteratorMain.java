public class IteratorMain {
    public static void main(String[] args) throws InvalidIndexException {
        Integer array[] = { 1, 2, 3, 4, 5, 6, 7, 8, 9, 10 };
        Iterator<Integer> seq = new Iterator<Integer>(array, 10);

        for ( ; !seq.over(); seq.next() ) {
            System.out.print(seq.value() + " ");
        }
        System.out.println(seq.value());     
    }
}
