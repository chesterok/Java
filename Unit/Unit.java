public class Unit implements Cloneable {
    private int damage;
    private int hitPoints;
    private int hitPointsLimit;
    private String name;
    
    private void ensureIsAlive() throws UnitIsDeadException {
        if ( hitPoints == 0 ) {
            throw new UnitIsDeadException();
        }
    }

    public Unit(String name, int hp, int dmg) {
        this.damage = dmg;
        this.hitPoints = hp;
        this.hitPointsLimit = hp;
        this.name = name;
    }

    public int getDamage() {
        return damage;
    }

    public int getHitPoints() {
        return hitPoints;
    }

    public int getHitPointsLimit() {
        return hitPointsLimit;
    }

    public String getName() {
        return name;
    }

    public void addHitPoints(int hp) throws UnitIsDeadException  {
        ensureIsAlive();

        int newHp = hitPoints + hp;

        if ( newHp > hitPointsLimit ) {
            hitPoints = hitPointsLimit;
        } else {
            hitPoints = newHp;
        }
    }

    public void takeDamage(int dmg) throws UnitIsDeadException {
        ensureIsAlive();

        if ( dmg > hitPoints ) {
            hitPoints = 0;
        } else {
            hitPoints -= dmg;
        }
    }

    public void attack(Unit enemy) throws UnitIsDeadException {
        enemy.takeDamage(damage);
        enemy.counterAttack(this);
    }

    public void counterAttack(Unit enemy) throws UnitIsDeadException {
        enemy.takeDamage(damage/2);
    }

    public String toString() {
        StringBuffer out = new StringBuffer();

        out.append("Unit \"" + name + "\":");
        out.append("\n-- Damage: " + damage);
        out.append("\n-- Hit Points: " + hitPoints);
        out.append("\n-- Hit Points Limit: " + hitPointsLimit);
        
        return out.toString();
    }

    public Unit clone() throws CloneNotSupportedException {
        return (Unit) super.clone();
    }
}
