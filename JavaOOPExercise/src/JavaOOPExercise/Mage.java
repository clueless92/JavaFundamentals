package JavaOOPExercise;

import JavaOOPExercise.Exceptions.OutOfEnergyException;

public class Mage extends GameCharacter{

    private static final int    BASE_HEALTH             = 5000;
    private static final int    BASE_POWER              = 150;
    private static final int    BASE_ENERGY             = 2500;
    private static final int    BASE_ATTACK_COST        = 250;
    private static final double CRITICAL_HIT_TRESHHOLD  = 0.5;
    private static final double TELEPORT_TRESHHOLD      = 0.5;

    public Mage(int health, int power, int energy, int attackCost, String name) {
        super(health, power, energy, attackCost, name);
    }

    public Mage(String name) {
        this(BASE_HEALTH, BASE_POWER, BASE_ENERGY, BASE_ATTACK_COST, name);
    }

    @Override
    public void attack(GameCharacter other) throws OutOfEnergyException {
        if (other == this) {
            throw new IllegalStateException("Cannot attack oneself");
        }
        if (this.getEnergy() < this.getAttackCost()) {
            throw new OutOfEnergyException(String.format("%s is out of energy.\n", this.getName()));
        }
        boolean isCritical = Math.random() < CRITICAL_HIT_TRESHHOLD;
        int damage = this.getPower();
        if (isCritical) {
            damage <<= 1;
            System.out.print("Critical! ");
        }
        this.setEnergy(this.getEnergy() - this.getAttackCost());
        other.respond(damage);
    } // end of attack method

    @Override
    public void respond(int damage) {
        boolean hasTeleport = Math.random() > TELEPORT_TRESHHOLD;
        if (hasTeleport) {
            System.out.println("The mage teleported and evaded the attack!");
        } else {
            this.setHealth(this.getHealth() - damage);
            System.out.printf("%d damage dealt to the mage!\n", damage);
        }
    }
}
