public class IteratorMain {
	public static void main(String[] args) throws InvalidMultiplierException, InvalidFirstException, InvalidIndexException {
		Iterator seq = new Iterator(1,4,15);

	    for ( ; !seq.over(); seq.next() ) {
	       System.out.print(seq.getValue() + " ");
	    }
	    System.out.println(seq.getValue());

	    int a = seq.getValueAtIndex(5);

	    System.out.println(a);
	}
}
