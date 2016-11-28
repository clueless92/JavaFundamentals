package Hw01StacksAndQueues;

import java.util.ArrayDeque;
import java.util.Scanner;

public class Pr06TruckTour {
    public static void main(String[] args) {
        ArrayDeque<Pump> queue = readPumps();
        int gasInTank = 0;
        int index = 0;
        boolean found = false;
        while (true) {
            Pump currentPump = queue.removeFirst();
            Pump firstPump = currentPump;
            queue.addLast(currentPump);
            gasInTank += currentPump.gasRefill;
            int indexAddUp = 1;
            while (gasInTank >= currentPump.distanceToNext) {
                gasInTank -= currentPump.distanceToNext;
                currentPump = queue.removeFirst();
                queue.addLast(currentPump);
                gasInTank += currentPump.gasRefill;
                indexAddUp++;
                if (currentPump == firstPump) {
                    found = true;
                    break;
                }
            }
            if (found) {
                break;
            }
            index += indexAddUp;
            gasInTank = 0;
        }
        System.out.println(index);
    }

    private static ArrayDeque<Pump> readPumps() {
        Scanner sc = new Scanner(System.in);
        int n = Integer.valueOf(sc.nextLine());
        ArrayDeque<Pump> queue = new ArrayDeque<>();
        for (int i = 0; i < n; i++) {
            String[] tokens = sc.nextLine().split("\\s+");
            Pump newPump = new Pump();
            newPump.gasRefill = Integer.valueOf(tokens[0]);
            newPump.distanceToNext = Integer.valueOf(tokens[1]);
            queue.addLast(newPump);
        }
        return queue;
    }

    private static class Pump {
        int gasRefill;
        int distanceToNext;

//    public Pump(int gas, int distance) {
//        gasRefill = gas;
//        distanceToNext = distance;
//    }
    }
}

