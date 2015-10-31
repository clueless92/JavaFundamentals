package JavaCollectionsBasicsHomework;

import java.util.*;

public class Pr11MostFrequentWord {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        HashMap<String, Integer> wordMap = new HashMap<>();
        List<String> maxKeys = new ArrayList<>();
        String[] words = sc.nextLine().split("\\W+");
        int maxValue = 0;
        for (int i = 0; i < words.length; i++) {
            String word = words[i].toLowerCase();
            if (!wordMap.containsKey(word)){
                wordMap.put(word, 1);
            } else {
                int count = wordMap.get(word) + 1;
                wordMap.put(word, count);
            }
            if(wordMap.get(word) > maxValue) {
                maxValue = wordMap.get(word);
            }
        }
        for (Map.Entry<String, Integer> pair : wordMap.entrySet()) {
            if (pair.getValue() == maxValue) {
                maxKeys.add(pair.getKey());
            }
        }
        Collections.sort(maxKeys);
        for (String key : maxKeys) {
            System.out.printf("%s -> %d times\n", key, maxValue);
        }
    }
}
