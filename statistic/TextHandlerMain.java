import java.util.HashMap;
import java.util.Map;
import java.io.IOException;

public class TextHandlerMain {
    public static void main(String[] args) throws IOException {
        TextHandler handler = new TextHandler("symbols.txt");

        handler.parseText();

        System.out.println(handler);
    }
}