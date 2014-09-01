public class PassportMain {
    public static void main(String[] args) throws InvalidDateException, InvalidSerialException, NumbersOutException {
        Passport a = new Passport("Yuriy", "Avilov", 10, 02, 1988);
        Character c = new Character('a');

        a.setSerial('a', 'S', 10);


        System.out.println(a);
    }
}
