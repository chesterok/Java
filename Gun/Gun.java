public class Gun implements Cloneable {
    private int amount;
    private int capacity;
    private int totalShots;
    private boolean isReady;
    private String model;

    public Gun(String model, int capacity) {
        this.model = model;
        this.capacity = capacity;
        this.amount = 0; 
        this.isReady = false;
        this.totalShots = 0;                                            
    }

    public Gun() {
        this("Beretta", 8);                                         
    }

    public int getAmount() {
        return amount;
    }

    public int getCapacity() {
        return capacity;
    }

    public boolean ready() {
        return isReady;
    }

    public String getModel() {
        return model;
    }

    public int getTotalShots() {
        return totalShots;
    }

    public void prepare() {
        isReady = !isReady;
    }

    public void reload() {
        amount = capacity;
    }

    public void shoot() throws NotReadyException, OutOfRoundsException {
        if ( !ready() ) {
            throw new NotReadyException();
        }
        if ( amount == 0 ) {
            throw new OutOfRoundsException();
        }
        System.out.println("Bang!\n");
        amount -= 1;
        totalShots += 1;
    }

    public String toString() {
        StringBuffer out = new StringBuffer();

        out.append("Gun \"" + model + "\" :");
        out.append("\n-- amount: " + amount);
        out.append("\n-- capacity: " + capacity);
        out.append("\n-- totalShots: " + totalShots);

        return out.toString();
    }

    public Gun clone() throws CloneNotSupportedException {
        return (Gun) super.clone();
    }
}
