package airbnb;

import java.util.*;

/**
 * Created by tyh on 2017/9/10.
 */
public class Wizard {
    public static void main(String[] args) {
        List<List<Integer>> list = new ArrayList<>();
        list.add(Arrays.asList(1, 4, 9));//0
        list.add(Arrays.asList(2));//1
        list.add(Arrays.asList(3));//2
        list.add(Arrays.asList(2));//3
        list.add(Arrays.asList(5));//4
        list.add(Arrays.asList(6));//5
        list.add(Arrays.asList(7));//6
        list.add(Arrays.asList(8));//7
        list.add(Arrays.asList(9));//8
        System.out.println(getMinCost(list));
    }
    public static class Node{
        int val;
        int dist;
        public Node(int val, int dist){
            this.val = val;
            this.dist = dist;
        }
    }
    public static int getMinCost(List<List<Integer>> list) {
        Set<Integer> visited = new HashSet<>();
        //记录第一个顶点到其他点的最小距离，heap排序
        //用这个priority queue来实现dijkstra算法中找到距离最近的顶点
        PriorityQueue<Node> queue = new PriorityQueue<>(new Comparator<Node>() {
            public int compare(Node n1, Node n2) {
                return n1.dist - n2.dist;
            }
        });
        //加入第一个顶点
        for(int i : list.get(0)){
            queue.offer(new Node(i, i * i));
        }
        visited.add(0);
        while(!queue.isEmpty()){
            Node node = queue.poll();
            if(node.val == 9){
                return node.dist;
            }
            visited.add(node.val);
            //计算该顶点到其他点的距离，加入到priority queue
            for(int i : list.get(node.val)){
                if(!visited.contains(i)){
                    queue.add(new Node(i, node.dist + (i - node.val) * (i - node.val)));
                }
            }
        }
        return Integer.MAX_VALUE;
    }
}
