package JavaOOPExercise;

import JavaOOPExercise.Exceptions.OutOfEnergyException;

public class Warrior extends GameCharacter {

    private static final int    BASE_HEALTH             = 5000;
    private static final int    BASE_POWER              = 200;
    private static final int    BASE_ENERGY             = 1500;
    private static final int    BASE_ATTACK_COST        = 150;
    private static final double POWER_SURGE_TRESHHOLD   = 0.4;
    private static final double BLOCK_TRESHHOLD         = 0.6;

    public Warrior(int health, int power, int energy, int attackCost, String name) {
        super(health, power, energy, attackCost, name);
    }

    public Warrior(String name) {
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
        boolean isPowerSurge = Math.random() < POWER_SURGE_TRESHHOLD;
        int damage = this.getPower();
        if (isPowerSurge) {
            System.out.printf("%s was lucky. Free attack. ", this.getName());
        }
        else {
            this.setEnergy(this.getEnergy() - this.getAttackCost());
        }
        other.respond(this.getPower());
    }

    @Override
    public void respond(int damage) {
        boolean isBlock = Math.random() < BLOCK_TRESHHOLD;
        if (isBlock) {
            System.out.print("The warrior blocked the attack! ");
            damage >>= 1;
        }
        this.setHealth(this.getHealth() - damage);
        System.out.printf("%d damage dealt to the warrior!\n", damage);
    }
}
