public class Car implements Cloneable {
    private double fuelAmount;
    private double fuelCapacity;
    private double fuelConsumption;
    private Point location;
    private String model;

    public Car(double capacity, double consumption, Point location, String model) {
        this.fuelCapacity = capacity;
        this.fuelConsumption = consumption;
        this.location = location;
        this.model = model;
        this.fuelAmount = capacity;

    }

    public Car(double capacity, double consumption, double x, double y, String model) {
        this(capacity, consumption, new Point(x, y), model);
    }

    public Car() {
        this(60, 0.6, new Point(0, 0), "Mercedes");
    }


    public double getFuelAmount() {
        return fuelAmount;
    }
    
    public double getFuelCapacity() {
        return fuelCapacity;
    }
    
    public double getFuelConsumption() {
        return fuelConsumption;
    }
    
    public Point getLocation() {
        return location;
    }
    
    public String getModel() {
        return model;
    }

    public void drive(Point destination) throws OutOfFuelException {
        double fuelNeed = location.distance(destination) * fuelConsumption;

        if ( fuelNeed > fuelAmount ) { throw new OutOfFuelException(); }

        location = destination;
        fuelAmount -= fuelNeed;
    }
    
    public void drive(double x, double y) throws OutOfFuelException {
        drive(new Point(x, y));
    }
    
    public void refill(double fuel) throws ToMuchFuelException {
        if ( fuel > 0 ) {
            double newFuel = fuel + fuelAmount;

            if ( newFuel > fuelCapacity ) { throw new ToMuchFuelException(); }

            fuelAmount = newFuel;
        }
    }

    public String toString() {
        StringBuffer out = new StringBuffer();

        out.append("Car \"" + model + "\":\n");
        out.append("-- Fuel Amount: " + fuelAmount);
        out.append("\n-- Fuel Capacity: " + fuelCapacity);
        out.append("\n-- Fuel Consumption: " + fuelConsumption);
        out.append("\n-- Location: " + location);

        return out.toString();
    }

    public Car clone() throws CloneNotSupportedException {
        return (Car) super.clone();
    }
}
