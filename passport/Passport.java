public class Passport {
    private String name;
    private String secondName;
    private Date date;
    private int serial;
    private char first, second;
    private static char lastSecond = 'A';
    private static char lastFirst = 'A';
    private static int lastSerial = 0;
    public class Char { 
        public char value;
        public Char(char value) {
            this.value = value;
        }
    }

    private boolean isLetter(Char symbol) {
        boolean letter = false;

        if ( symbol.value >= 'A' && symbol.value <= 'Z' || symbol.value >= 'a' && symbol.value <= 'z' ) {
            if ( symbol.value > 'Z' ) {
                int diff = 'a' - 'A';

                symbol.value -= diff;
            }
            letter = true;
        }

        return letter;
    }

    private void validate() throws NumbersOutException {
        lastSerial += 1;

        if ( lastSerial == 1000000 ) {
            lastSerial = 0;
            lastSecond += 1;

            if ( lastSecond == '[' ) {
                lastSecond = 'A';
                lastFirst += 1;

                if ( lastFirst == '[' ) {
                    throw new NumbersOutException();
                }
                
            }
        }

        serial = lastSerial;
        first = lastFirst;
        second = lastSecond;
    }

    public Passport(String name, String secondName, int day, int month, int year ) 
    throws NumbersOutException, InvalidDateException {
        validate();

        this.name = name;
        this.secondName = secondName;
        date = new Date(day, month, year);
    }

    public Passport() throws NumbersOutException, InvalidDateException {
        this("Ivan", "Petrov", 1, 1, 1970);
    }

    public void setSerial(char a, char b, int serial) throws InvalidSerialException {
        Char charA = new Char(a);
        Char charB = new Char(b);

        if ( !isLetter(charA) || !isLetter(charB) || serial > 999999 || serial < 0 ) {
            throw new InvalidSerialException();
        }

        first = charA.value;
        second = charB.value;
        this.serial = serial;
    }

    public void setSerial(char a, char b) throws InvalidSerialException {
        setSerial(a, b, 1);
    }

    public int getSerial() {
        return serial;
    }

    public String getName() {
        return name;
    }

    public String getSecondName() {
        return secondName;
    }

    public Date getDate() {
        return date;
    }

    public char getFirst() {
        return first;
    }

    public char getSecond() {
        return second;
    }

    public String toString() {
        StringBuffer out = new StringBuffer();

        out.append("serial number: " + first + second);
        for ( int i = 100000; i > serial; i /= 10 ) {
            out.append("0");
        }
        out.append(serial);
        out.append("\nborn: " + date);
        out.append("\nname: " + name + " " + secondName);

        return out.toString();
    }

}
