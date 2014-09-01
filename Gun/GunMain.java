public class GunMain {
    public static void main(String[] args) throws 
    NotReadyException, OutOfRoundsException {
        Gun gun = new Gun();
        Gun beretta = new Gun("Beretta", 10);

        System.out.println(beretta);
        System.out.println(gun);

        beretta.reload();
        beretta.prepare();

        beretta.shoot();

        System.out.println(beretta);
        System.out.println(gun);
    }
}
