public class Paper {
    private int maxSymbols;
    private int symbols;
    private StringBuffer content;

    public Paper(int maxSymbols) {
        content = new StringBuffer();
        this.maxSymbols = maxSymbols;
        this.symbols = 0;
    }

    public Paper () {
        this(4096);
    }

    public int getMaxSymbols() {
        return maxSymbols;
    }

    public int getSymbols() {
        return symbols;
    }

    public void addContent (String message) throws OutOfSpaceException {
        int total = symbols + message.length();

        if ( maxSymbols == 0 ) {
            throw new OutOfSpaceException();
        }
        if ( total > maxSymbols ) {
            content.append(message.substring(0, maxSymbols));
            symbols += maxSymbols;
            maxSymbols = 0;
            throw new OutOfSpaceException();
        }
        content.append(message);
        maxSymbols -= message.length();
        symbols += message.length();
    }

    public void show() {
        System.out.println(content);
    }
}
