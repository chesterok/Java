public class UnitMain {
    public static void main(String[] args) throws
        UnitIsDeadException, CloneNotSupportedException {
        Unit barbarian = new Unit("Barbarian", 200, 20);
        Unit knight = new Unit("Knight", 180, 25);

        System.out.println(barbarian);
        System.out.println(knight);

        barbarian.attack(knight);

        System.out.println(barbarian);
        System.out.println(knight);
    }
}
