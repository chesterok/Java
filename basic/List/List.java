import java.util.ArrayList;

public class List {
    public static void main(String[] args) {
        ArrayList<Integer> lst = new ArrayList<Integer>();

        for ( int i = 1; i <= 10; i++ ) {
            lst.add(new Integer(i));
        }

        System.out.println(lst);
    }
}
