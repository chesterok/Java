import java.util.Scanner;
import java.io.File;
import java.util.ArrayList;
import java.io.IOException;

public class Iterator {
    private Scanner sc;
    private ArrayList<Integer> tall;
    private int current;

    public Iterator(String fileName) throws IOException {
        this.sc = new Scanner(new File(fileName));
        this.tall = new ArrayList<Integer>();
        this.current = 0;
        tall.add(sc.nextInt());
    }

    public void next() throws IOException {
        if ( over() ) {
            return;
        }
        current += 1;
        tall.add(sc.nextInt());
    }

    public void previous() {
        if ( less() ) {
            return;
        }
        current -= 1;
    }

    public boolean less() {
        return current <= 0;
    }

    public boolean over() throws IOException {
        return !sc.hasNext();
    }

    public int getValue() {
        return tall.get(current);
    }
}
