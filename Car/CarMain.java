public class CarMain {
    public static void main(String[] args) 
    throws OutOfFuelException,
           ToMuchFuelException,
           CloneNotSupportedException {
        Car car = new Car();

        System.out.println(car);

        car.drive(new Point(5, 11));

        System.out.println(car);
    }
}
