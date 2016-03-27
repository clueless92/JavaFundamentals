package Pr01DragonEra;

import java.util.ArrayList;
import java.util.List;

public class Dragon {

    private static final int AGE_DEATH = 6;
    private static final int AGE_LAY_EGGS_START = 3;
    private static final int AGE_LAY_EGGS_END = 4;

    private String name;
    private int age;
    public boolean isAlive = true;
    private List<Egg> eggs;
    private List<Dragon> offspring;

    public List<Egg> getEggs() {
        return eggs;
    }

    public Dragon (String name, int age) {
        this.name = name;
        this.age = age;
        this.eggs = new ArrayList<>();
    }

    public void increaseOffspring(Dragon dragon) {
        offspring.add(dragon);
    }

    public int getAge() {
        return age;
    }

    public String getName() {
        return name;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public void setAge(String name) {
        this.name = name;
    }

    public void lay(Egg egg) {
        this.eggs.add(egg);
    }

    public void lay() {
        boolean isMature = this.age >= AGE_LAY_EGGS_START && this.age <= AGE_LAY_EGGS_END;
        if (isMature) {
            Egg egg = new Egg(0, this);
            this.eggs.add(egg);
        }
    }

    public void age() {
        if (this.isAlive) {
            this.age++;
        }
        if (this.age == AGE_DEATH) {
            isAlive = false;
        }
    }
}
