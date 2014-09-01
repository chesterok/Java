public class IteratorMain {
	public static void main(String[] args) throws InvalidIndexException, InvalidParamException {
		Iterator seq = new Iterator();

		for ( ; !seq.over(); seq.next() ) {
			System.out.print(seq.getValue() + " ");
		}
		System.out.println(seq.getValue());
	}
}