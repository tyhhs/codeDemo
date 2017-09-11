package airbnb;

import java.util.ArrayList;
import java.util.List;

/**
 * KEditDistance2
 * Author: bjtangyunhao
 * Creation date: 2017年09月11日 11:12
 * Modified by: bjtangyunhao
 * Last modified: 2017年09月11日 11:12
 */
public class KEditDistance2 {
    /*
    *  A better solution with a trie:
    *  The problem with the previous solution is if the given list of the words is like ab, abc, abcd,
     *  each time we need to repeatedly calculate the edit distance with the target word.
     *  If we can combine the prefix of all words together, we can save lots of time.
    */
    public static void main(String[] args) {
        String[] words = new String[]{"abc", "abd", "abcd", "adc", "aefeih"};
        String target = "ac";
        int k = 2;
        List<String> res = getKEditDistance(words, target, k);
        for (String s : res) {
            System.out.println(s);
        }
    }

    public static List<String> getKEditDistance(String[] words, String target, int k) {
        List<String> result = new ArrayList<>();

        if (words == null || words.length == 0 ||
                target == null || target.length() == 0 || k < 0) {
            return result;
        }

        Trie trie = new Trie();
        for (String word : words) {
            trie.add(word);
        }

        TrieNode root = trie.root;

        int[] prev = new int[target.length() + 1];
        for (int i = 0; i < prev.length; i++) {
            prev[i] = i;
        }

        getKEditDistanceHelper("", target, k, root, prev, result);

        return result;
    }

    private static void getKEditDistanceHelper(String curr, String target, int k, TrieNode root,
                                               int[] prevDist, List<String> result) {
        if (root.isLeaf) {
            if (prevDist[target.length()] <= k) {
                result.add(curr);
            } else {
                return;
            }
        }

        for (int i = 0; i < 26; i++) {
            if (root.children[i] == null) {
                continue;
            }

            int[] currDist = new int[target.length() + 1];
            currDist[0] = curr.length() + 1;
            for (int j = 1; j < prevDist.length; j++) {
                if (target.charAt(j - 1) == (char) (i + 'a')) {
                    currDist[j] = prevDist[j - 1];
                } else {
                    currDist[j] = Math.min(Math.min(prevDist[j - 1], prevDist[j]),
                            currDist[j - 1]) + 1;
                }
            }

            getKEditDistanceHelper(curr + (char) (i + 'a'), target, k,
                    root.children[i], currDist, result);
        }
    }

    static class TrieNode {
        TrieNode[] children;
        boolean isLeaf;

        public TrieNode() {
            children = new TrieNode[26];

        }
    }

    static class Trie {
        TrieNode root;

        public Trie() {
            root = new TrieNode();
        }

        // Add a word into trie
        public void add(String s) {
            if (s == null || s.length() == 0) {
                return;
            }

            TrieNode p = root;
            for (int i = 0; i < s.length(); i++) {
                char c = s.charAt(i);
                if (p.children[c - 'a'] == null) {
                    p.children[c - 'a'] = new TrieNode();
                }

                if (i == s.length() - 1) {
                    p.children[c - 'a'].isLeaf = true;
                }

                p = p.children[c - 'a'];
            }
        }
    }
}
