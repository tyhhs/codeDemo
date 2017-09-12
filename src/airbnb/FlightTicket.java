package airbnb;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by tyh on 2017/9/12.
 */
public class FlightTicket {

    /*    int minCostFlight(List<String> flights, String start, String end, int k){
        }*/
    public static void main(String[] args) {
        String[] input = {"A->B,100", "A->C,100", "C->D,200", "A->D,500", "B->C,300","B->E,50","E->D,40","B->A,40"};
        search(input, 2, 'A', 'D', 5);
    }

    static int min = Integer.MAX_VALUE;
    static String path = "";

    public static void search(String[] input, int k, char start, char end, int num) {
        Map<Character, List<Node>> map = new HashMap<>();
        for (String str : input) {
            char dep = str.charAt(0);
            char arr = str.charAt(3);
            String[] strs = str.split(",");
            int cost = Integer.parseInt(strs[1]);
            Node node = new Node(arr, cost);
            map.putIfAbsent(dep, new ArrayList<>());
            map.get(dep).add(node);
        }

        boolean[] visited = new boolean[num];
        StringBuilder sb = new StringBuilder();
        sb.append(start);

        helper(map, k, start, end, sb, -1, 0, visited);
        System.out.println("Minimum cost: " + min + " Path: " + path);
    }

    private static void helper(Map<Character, List<Node>> map, int k, char start, char end,
                        StringBuilder sb, int counter, int cost, boolean[] visited) {
        if (start == end && counter <= k) {
            if (cost < min) {
                min = cost;
                path = sb.toString();
            }
            return;
        }
        if (visited[start - 'A'] || cost >= min || counter > k) {
            return;
        }
        List<Node> list = map.get(start);
        visited[start - 'A'] = true;
        for (Node n : list) {
            sb.append(n.destination);
            helper(map, k, n.destination, end, sb, counter + 1, cost + n.cost, visited);
            sb.deleteCharAt(sb.length() - 1);
        }
        visited[start - 'A'] = false;
    }

    static class Node {
        char destination;
        int cost;
        public Node(char des, int cost) {
            destination = des;
            this.cost = cost;
        }
    }
}


