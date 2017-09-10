package airbnb;

import java.util.*;

/**
 * AlienDicBFS
 * Author: bjtangyunhao
 * Creation date: 2017年09月10日 14:29
 * Modified by: bjtangyunhao
 * Last modified: 2017年09月10日 14:29
 */
public class AlienDicBFS {
    public static void main(String[] args) {
        String[] words = new String[]{
                "wrt",
                "wrf",
                "er",
                "ett",
                "rftt"};
        String sorted = alienOrder(words);
        System.out.println(sorted);
    }
    public static String alienOrder(String[] words) {
        Map<Character, Set<Character>> graph = new HashMap<>();
        Map<Character, Integer> indegree = new HashMap<>();
        StringBuilder sb = new StringBuilder();
        //build graph
        for(int i = 0; i < words.length; i++){
            for (int j = 0; j < words[i].length(); j++) {
                char c = words[i].charAt(j);
                if (!graph.containsKey(c)) {
                    graph.put(c, new HashSet<>()); // 为了排序结果出现所有字母，对于每个字母，都要初始化，
                    indegree.put(c, 0);
                }
            }
            if(i > 0){
                checkOrder(words[i-1], words[i], graph, indegree);
            }
        }
        Queue<Character> queue = new LinkedList<>();
        //get char with 0 indegree
        for(char c : indegree.keySet()){
            if(indegree.get(c) == 0){
                queue.offer(c);
            }
        }
        while(!queue.isEmpty()){
            char from = queue.poll();
            sb.append(from);
            for(char end : graph.get(from)){
                if(indegree.get(end) == 1){
                    indegree.put(end, 0);
                    queue.offer(end);
                }
            }
        }
        if(sb.length() == indegree.size()){
            return sb.toString();
        }
        else{
            return "";
        }
    }

    private static void checkOrder(String word1, String word2, Map<Character, Set<Character>> graph, Map<Character, Integer> indegree){
        int i = 0;
        while(i < word1.length() && i < word2.length()){
            char c1 = word1.charAt(i);
            char c2 = word2.charAt(i);
            if(c1 != c2){
                //get a edge from c1 to c2
                Set<Character> set = graph.get(c1);
                if(!set.contains(c2)){//avoid duplicate edge
                    indegree.put(c2, indegree.get(c2)+1);
                }
                graph.get(c1).add(c2);
                return;
            }
            i++;
        }
    }
}
