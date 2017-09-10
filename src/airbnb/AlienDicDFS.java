package airbnb;

import java.util.*;

/**
 * Created by tyh on 2017/9/10.
 */
public class AlienDicDFS {
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
        Map<Character, List<Character>> graph = new HashMap<>();
        for (int i = 0; i < words.length; i++) {
            for (int j = 0; j < words[i].length(); j++) {
                char c = words[i].charAt(j);
                if (!graph.containsKey(c)) {
                    graph.put(c, new ArrayList<Character>()); // 为了排序结果出现所有字母，对于每个字母，都要初始化，
                }
            }

            // 根据连续的两个单词，得到一个相对的字符顺序
            if (i > 0) {
                check(words[i - 1], words[i], graph);
            }
        }

        Stack<Character> stack = new Stack<Character>();
        boolean[] visited = new boolean[26]; // 标记DFS路径上的点
        boolean[] isLoop = new boolean[26]; // 用来发现环
        for (char c : graph.keySet()) {

            // 有环，无效输入，返回空字符串
            if (!dfs(graph, c, visited, isLoop, stack))
                return "";
        }
        StringBuilder sb = new StringBuilder();

        // 得到最终正确的字母顺序
        while (!stack.isEmpty())
            sb.append(stack.pop());
        return sb.toString();
    }

    private static boolean dfs(Map<Character, List<Character>> graph, char c, boolean[] visited, boolean[] isLoop, Stack<Character> stack) {
        int i = c - 'a';
        if (visited[i]) return true; // 已经搜过了，可以直接跳过
        if (isLoop[i]) return false; // 发现环

        isLoop[i] = true;
        for (char next : graph.get(c)) {
            if (!dfs(graph, next, visited, isLoop, stack))
                return false;
        }
        visited[i] = true;
        stack.push(c);
        return true;
    }

    public static void check(String word1, String word2, Map<Character, List<Character>> map) {
        int i = 0;

        // 找到两者第一个不相等的字符
        while (i < word1.length() && i < word2.length() && word1.charAt(i) == word2.charAt(i))
            i++;
        if (i < word1.length() && i < word2.length())
            map.get(word1.charAt(i)).add(word2.charAt(i));
    }
}
