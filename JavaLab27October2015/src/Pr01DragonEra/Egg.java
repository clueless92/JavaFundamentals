package Pr01DragonEra;

import java.util.regex.Matcher;

public class Egg {

    private static final int AGE_HATCH = 2;

    private int age;
    private Dragon parrent;
    public Egg (int age, Dragon parrent) {
        this.age = age;
        this.parrent = parrent;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public Dragon getParrent() {
        return parrent;
    }

    public void setParrent(Dragon parrent) {
        this.parrent = parrent;
    }

    public void age() {
        this.age++;
    }

    public void hatch() {
        if (this.age == AGE_HATCH) {
            Dragon baby = new Dragon(this.parrent.getName() + "/" + "Dragon_" + Main.dragonsCount, 0);
            this.parrent.increaseOffspring(baby);
            Main.dragonsCount++;
        }
    }
}
