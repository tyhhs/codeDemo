package airbnb;

import java.util.*;

/**
 * Created by tyh on 2017/9/9.
 */
public class PalindromePairs {
    public static void main(String[] args) {
        String[] words = new String[]{"abcd","dcba","lls","s","sssll", ""};
        palindromePairs(words);
    }
    public static List<List<Integer>> palindromePairs(String[] words) {
        List<List<Integer>> res = new ArrayList<>();
        if(words.length == 0){
            return res;
        }
        //put words in a hashmap, key: word, value: position
        Map<String, Integer> map = new HashMap<>();
        for(int i = 0; i < words.length; i++){
            map.put(words[i], i);
        }

        for(int i = 0; i < words.length; i++){
            String word = words[i];
            //word is palindrome, can form pair with any empty string
            if(word.length() != 0 && isPalindrome(word)){
                if(map.containsKey("")){
                    int index = map.get("");
                    res.add(new ArrayList(Arrays.asList(i, index)));
                    res.add(new ArrayList(Arrays.asList(index, i)));
                }
            }
            //if word's reverse exist, can form a pair
            String wordReverse = reverseStr(word);
            if(map.containsKey(wordReverse)){
                int index = map.get(wordReverse);
                if(index != i){
                    res.add(new ArrayList(Arrays.asList(i, index)));
                }
            }
            //case 3
            for(int j = 1; j <= word.length(); j++){
                String left = word.substring(0, j);
                String right = word.substring(j);
                if(isPalindrome(left)){
                    String rightReverse = reverseStr(right);
                    if(map.containsKey(rightReverse)){
                        int index = map.get(rightReverse);
                        res.add(new ArrayList(Arrays.asList(index, i)));
                    }
                }
                if(isPalindrome(right)){
                    String leftReverse = reverseStr(left);
                    if(map.containsKey(leftReverse)){
                        int index = map.get(leftReverse);
                        res.add(new ArrayList(Arrays.asList(i, index)));
                    }
                }
            }
        }
        return res;
    }

    private static boolean isPalindrome(String s){
        int low = 0;
        int high = s.length() - 1;
        while(low < high){
            if(s.charAt(low) != s.charAt(high)){
                return false;
            }
            low++;
            high--;
        }
        return true;
    }

    private static String reverseStr(String s){
        StringBuilder sb = new StringBuilder(s);
        sb = sb.reverse();
        return sb.toString();
    }
}
