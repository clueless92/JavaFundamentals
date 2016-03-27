package JavaOOPExercise;

import JavaOOPExercise.Exceptions.OutOfEnergyException;

public class Main {
    public static void main(String[] args) {
        GameCharacter goshoTheWarr = new Warrior("Gosho");
        GameCharacter peshoTheMage = new Mage("Pesho");
        int rounds = 0;
        int manaOver = 0;
        boolean mageIsFirst = false;
        while (true) {
            System.out.printf("Round: %d\n", ++rounds);
            try {
                if (mageIsFirst) {
                    peshoTheMage.attack(goshoTheWarr);
                    goshoTheWarr.attack(peshoTheMage);
                } else {
                    goshoTheWarr.attack(peshoTheMage);
                    peshoTheMage.attack(goshoTheWarr);
                }
                mageIsFirst = !mageIsFirst;
            } catch (OutOfEnergyException e) {

                // this will print who ran out of energy first
                System.out.print(e.getMessage());

                // the fight is over, exit the loop
                //manaOver++;
                //if (manaOver > 1) {
                    System.out.println("Battle over.");
                    break;
                //}
            }
            System.out.println();
        }
        System.out.println();
        if (goshoTheWarr.getHealth() > peshoTheMage.getHealth()) {
            System.out.printf("The winner of the round is the warrior: %s with %d health left", goshoTheWarr.getName(), goshoTheWarr.getHealth());
        } else if (goshoTheWarr.getHealth() < peshoTheMage.getHealth()) {
            System.out.printf("The winner of the round is the mage: %s with %d health left", peshoTheMage.getName(), peshoTheMage.getHealth());
        } else {
            System.out.println("Draw");
        }
    }
}
