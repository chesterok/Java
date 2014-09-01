import java.io.IOException;

public class IteratorMain {
    public static void main(String[] args) throws IOException {
        Iterator file = new Iterator("task.in");


        for ( ; !file.over(); file.next() ) {
            System.out.print(file.getValue() + " ");
        }
        System.out.println(file.getValue());
    }
}
