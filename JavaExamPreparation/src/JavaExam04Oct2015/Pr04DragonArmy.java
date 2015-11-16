package JavaExam04Oct2015;

import java.util.*;

public class Pr04DragonArmy {
    private static final int DEFAULT_DAMAGE = 45;
    private static final int DEFAULT_HEALTH = 250;
    private static final int DEFAULT_ARMOR = 10;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        LinkedHashMap<String, TreeMap<String, DragonStats>> dragonMap = new LinkedHashMap<>();
        int numberOfDragons = Integer.parseInt(sc.nextLine());
        for (int i = 0; i < numberOfDragons; i++) {
            String[] input = sc.nextLine().split(" ");
            String type = input[0];
            String name = input[1];
            int damage;
            if (input[2].equals("null")) {
                damage = DEFAULT_DAMAGE;
            } else {
                damage = Integer.parseInt(input[2]);
            }
            int health;
            if (input[3].equals("null")) {
                health = DEFAULT_HEALTH;
            } else {
                health = Integer.parseInt(input[3]);
            }
            int armor;
            if (input[4].equals("null")) {
                armor = DEFAULT_ARMOR;
            } else {
                armor = Integer.parseInt(input[4]);
            }
            if (!dragonMap.containsKey(type)) {
                dragonMap.put(type, new TreeMap<>());
            }
            dragonMap.get(type).put(name, new DragonStats(damage, health, armor));
        }
        for(String type : dragonMap.keySet()) {
            TreeMap<String, DragonStats> innerMap = dragonMap.get(type);
            double totalDamage = 0;
            double totalHealth = 0;
            double totalArmor = 0;
            StringBuilder sb = new StringBuilder();
            for (String name : innerMap.keySet()) {
                totalDamage += innerMap.get(name).damage;
                totalHealth += innerMap.get(name).health;
                totalArmor += innerMap.get(name).armor;
                sb.append(String.format("-%s -> %s\r\n", name, innerMap.get(name).toString()));
            }
            int size = innerMap.size();
            double damageAvg = totalDamage / size;
            double healthAvg = totalHealth / size;
            double armorAvg = totalArmor / size;
            System.out.println(String.format("%s::(%.2f/%.2f/%.2f)", type, damageAvg, healthAvg, armorAvg));
            System.out.print(sb);
        }
    }

    private static class DragonStats {
        int damage;
        int health;
        int armor;

        private DragonStats(int damage, int health, int armor) {
            this.damage = damage;
            this.health = health;
            this.armor = armor;
        }

        @Override
        public String toString() {
            String info = String.format("damage: %d, health: %d, armor: %d", damage, health, armor);
            return info;
        }
    }
}
