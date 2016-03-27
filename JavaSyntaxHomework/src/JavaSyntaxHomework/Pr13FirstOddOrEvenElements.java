package JavaSyntaxHomework;

import java.util.ArrayList;
import java.util.Scanner;

public class Pr13FirstOddOrEvenElements {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        ArrayList<Integer> collection = new ArrayList<>();
        while (sc.hasNextInt()) {
            collection.add(sc.nextInt());
        }
        sc.nextLine();
        String[] commandParts = sc.nextLine().split(" ");
        ArrayList<Integer> result = getOddEvenNums(collection, commandParts);
        for (int i = 0; i < result.size(); i++) {
            System.out.printf("%d ", result.get(i));
        }
        System.out.println();
    }

    private static ArrayList<Integer> getOddEvenNums(ArrayList<Integer> collection, String[] commandParts) {
        int count = Integer.parseInt(commandParts[1]);
        String oddOrEven = commandParts[2];
        if (oddOrEven.equals("even"))
        {
            return getEvenNums(collection, count);
        }
        else
        {
            return getOddNums(collection, count);
        }
    }

    private static ArrayList<Integer> getOddNums(ArrayList<Integer> collection, int count) {
        ArrayList<Integer> oddList = new ArrayList<>();
        int index = 0;
        int limit = 0;
        while (index < collection.size() && limit < count)
        {
            if (collection.get(index) % 2 != 0)
            {
                oddList.add(collection.get(index));
                limit++;
            }
            index++;
        }
        return oddList;
    }

    private static ArrayList<Integer> getEvenNums(ArrayList<Integer> collection, int count) {
        ArrayList<Integer> evenList = new ArrayList<>();
        int index = 0;
        int limit = 0;
        while (index < collection.size() && limit < count)
        {
            if (collection.get(index) % 2 == 0)
            {
                evenList.add(collection.get(index));
                limit++;
            }
            index++;
        }
        return evenList;
    }
}
