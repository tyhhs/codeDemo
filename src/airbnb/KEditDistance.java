package airbnb;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by tyh on 2017/9/11.
 */
public class KEditDistance {
    /* Naive Solution:
    A naive solution would be, for each word in the list, calculate the edit distance with the target word.
    If it is equal or less than k, output to the result list.
    If we assume that the average length of the words is m, and the total number of words in the list is n,
    the total time complexity is O(n * m^2).
    */
    public static void main(String[] args) {
        //test edit distance
        System.out.println(editDistance("abc", "acde"));
        String[] words = new String[]{"abc", "abd", "abcd", "adc", "aefeih"};
        String target = "ac";
        int k = 2;
        List<String> res = getKEditDistance(words, target, k);
        for(String s : res){
            System.out.println(s);
        }
    }
    public static List<String> getKEditDistance(String[] words, String target, int k) {
        List<String> res = new ArrayList<>();
        for(String word : words){
            if(editDistance(word, target) <= k){
                res.add(word);
            }
        }
        return res;
    }

    private static int editDistance(String word1, String word2){
        int len1 = word1.length();
        int len2 = word2.length();
        if(len1 == 0 && len2 == 0){
            return 0;
        }
        int[][] dp = new int[len1+1][len2+1];
        for(int i = 0; i < len1 + 1; i++){
            dp[i][0] = i;
        }
        for(int i = 0; i < len2 + 1; i++){
            dp[0][i] = i;
        }
        for(int i = 1; i < len1 + 1; i++){
            for(int j = 1; j < len2 + 1; j++){
                if(word1.charAt(i-1) == word2.charAt(j-1)){
                    dp[i][j] = dp[i-1][j-1];
                }else{
                    dp[i][j] = dp[i-1][j-1] + 1;
                }
                dp[i][j] = Math.min(Math.min(dp[i][j-1] + 1, dp[i-1][j] + 1), dp[i][j]);
            }
        }
        return dp[len1][len2];
    }
}
