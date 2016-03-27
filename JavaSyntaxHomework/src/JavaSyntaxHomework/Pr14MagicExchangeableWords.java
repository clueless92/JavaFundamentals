package JavaSyntaxHomework;

import java.util.HashMap;
import java.util.Scanner;

public class Pr14MagicExchangeableWords {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        HashMap<Character, Character> charMap = new HashMap<>();
        String[] input = sc.nextLine().split(" ");
        String word1 = input[0];
        String word2 = input[1];
        boolean isMagic = true;
        for (int i = 0; i < word1.length(); i++) {
            if (!charMap.containsKey(word1.charAt(i))) {
                charMap.put(word1.charAt(i), word2.charAt(i));
            }
            else if (charMap.get(word1.charAt(i)) != word2.charAt(i)) {
                isMagic = false;
                break;
            }
        }
        System.out.println(isMagic);
    }
}
