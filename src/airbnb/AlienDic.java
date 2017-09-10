package airbnb;

import java.util.*;

/**
 * Created by tyh on 2017/9/10.
 */
public class AlienDic {
    int[] indegree;
    List<Set<Character>> parents;
    // record the appearred characters
    Set<Integer> set = new HashSet();
    List<String> list;
    boolean valid = true;

    public String alienOrder(String[] words) {
        init(words);
        getGraph(list, 0);
        if(!valid) return "";
        // find the character with indegree = 0
        Queue<Character> q = new LinkedList();
        for(int i = 0; i < indegree.length; i++) {
            if(indegree[i] == 0 && set.contains(i)) {
                q.offer((char) (i + 'a'));
            }
        }

        String result = "";
        while(!q.isEmpty()) {
            char c = q.poll();
            result += c;
            // if indegree -> 0, add to the q
            for(Character child : parents.get(c - 'a')) {
                if(--indegree[child - 'a'] == 0) {
                    q.offer(child);
                }
            }
        }

        return result;
    }

    private void init(String[] words) {
        indegree = new int[26];
        parents = new ArrayList();
        for(int i = 0; i < 26; i++) parents.add(new HashSet());

        list = new ArrayList();
        for(String word : words) {
            list.add(word);
            for(int i = 0; i < word.length(); i++) set.add(word.charAt(i) - 'a');
        }
    }

    private void getGraph(List<String> list, int level) {
        // base case
        if(list.size() == 0) return;

        for(int i = 0; i < list.size(); i++) {
            if(level >= list.get(i).length()) {
                continue;
            }
            char c = list.get(i).charAt(level);
            // record the string with the same character at current level
            List<String> same = new ArrayList();
            same.add(list.get(i));
            for(int j = i+1; j < list.size(); j++) {
                String cur = list.get(j);
                if(cur.length() <= level) {
                    // same start, different len, [abc, ab] is invalid
                    valid = false;
                    continue;
                }
                // character in the same level has order
                else if(cur.charAt(level) != c) {
                    if(parents.get(c-'a').add(cur.charAt(level))) {
                        indegree[cur.charAt(level) - 'a']++;
                        if(parents.get(cur.charAt(level)-'a').contains(c)) valid = false;
                    }
                }
                else same.add(cur);
            }
            if(same.size() > 1) getGraph(same, level + 1);
        }
    }

}
