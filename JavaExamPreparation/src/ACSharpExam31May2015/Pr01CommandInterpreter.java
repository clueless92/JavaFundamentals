package ACSharpExam31May2015;

import java.text.Collator;
import java.util.*;

public class Pr01CommandInterpreter {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String[] input = sc.nextLine().split(" ");
        List<String> arr = Arrays.asList(input);
        String command = sc.nextLine();
        while (!command.equals("end")) {
            try {
                String[] commandArgs = command.split("\\s+");
                String action = commandArgs[0];
                if (action.equals("reverse")) {
                    arr = reverse(arr, commandArgs);
                } else if (action.equals("sort")) {
                    arr = sort(arr, commandArgs);
                } else if (action.equals("rollLeft")) {
                    arr = rollLeft(arr, commandArgs);
                } else { // rollRight
                    arr = rollRight(arr, commandArgs);
                }
            } catch (FuckThisProblemException e) {
                System.out.println("Invalid input parameters.");
            }
            command = sc.nextLine();
        }
        System.out.println(arr);
    }

    private static List<String> rollRight(List<String> arr, String[] commandArgs) throws FuckThisProblemException {
        int count = Integer.parseInt(commandArgs[1]);
        if (count < 0) {
            throw new FuckThisProblemException();
        }
        count %= arr.size();
        List<String> leftList = arr.subList(0, arr.size() - count);
        List<String> rightList = arr.subList(arr.size() - count, arr.size());
        ArrayList<String> outputList = new ArrayList<>();
        outputList.addAll(rightList);
        outputList.addAll(leftList);
        return outputList;
    }

    private static List<String> rollLeft(List<String> arr, String[] commandArgs) throws FuckThisProblemException {
        int count = Integer.parseInt(commandArgs[1]);
        if (count < 0) {
            throw new FuckThisProblemException();
        }
        count %= arr.size();
        List<String> leftList = arr.subList(0, count);
        List<String> rightList = arr.subList(count, arr.size());
        ArrayList<String> outputList = new ArrayList<>();
        outputList.addAll(rightList);
        outputList.addAll(leftList);
        return outputList;
    }

    private static List<String> sort(List<String> arr, String[] commandArgs) throws FuckThisProblemException {
        int start = Integer.parseInt(commandArgs[2]);
        int count = Integer.parseInt(commandArgs[4]);
        int end =  start + count;
        if (start < 0 || start >= arr.size() || count < 0 || count > arr.size() || end > arr.size()) {
            throw new FuckThisProblemException();
        }
//        Collator usCollator = Collator.getInstance(Locale.US);
//        usCollator.setStrength(Collator.FULL_DECOMPOSITION);
        Collections.sort(arr.subList(start, end), new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                int result = Integer.compare(o1.length(), o2.length());
                if (result == 0) {
                    int i = 0;
                    while(i < o1.length() && result == 0) {
                        char a = Character.toLowerCase(o1.charAt(i));
                        char b = Character.toLowerCase(o2.charAt(i));
                        result = Integer.compare(a, b);
                        if (result == 0) {
                            result = -Integer.compare(o1.charAt(i), o2.charAt(i));
                        }
                        i++;
                    }
                }
                return result;
            }
        });
        return arr;
    }

    private static List<String> reverse(List<String> arr, String[] commandArgs) throws FuckThisProblemException {
        int start = Integer.parseInt(commandArgs[2]);
        int count = Integer.parseInt(commandArgs[4]);
        int end =  start + count;
        if (start < 0 || start >= arr.size() || count < 0 || count > arr.size() || end > arr.size()) {
            throw new FuckThisProblemException();
        }
        Collections.reverse(arr.subList(start, end));
        return arr;
    }

    private static class FuckThisProblemException extends Exception {
    }
}
