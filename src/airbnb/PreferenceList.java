package airbnb;

import java.util.*;

/**
 * PreferenceList
 * Author: bjtangyunhao
 * Creation date: 2017年09月11日 17:23
 * Modified by: bjtangyunhao
 * Last modified: 2017年09月11日 17:23
 */
public class PreferenceList {

    public static void main(String[] args){
        List<List<Integer>> list = new ArrayList<>();
        list.add(Arrays.asList(3, 5, 7 , 9)); //1
        list.add(Arrays.asList(2, 3, 8)); //2
        list.add(Arrays.asList(5, 8)); //3
        List<Integer> res = preferenceList(list);
        for(int i : res){
            System.out.println(i);
        }
    }

    public static List<Integer> preferenceList(List<List<Integer>> preference) {
        List<Integer> res = new ArrayList<>();
        if(preference == null || preference.size() == 0){
            return res;
        }
        //图， key: node value: set of connected node
        Map<Integer, Set<Integer>> map = new HashMap<>();
        //入度， key: node value: in-degree
        Map<Integer, Integer> in = new HashMap<>();
        //初始化图
        for(List<Integer> list : preference){
            for(int i = 1; i < list.size(); i++){
                int node = list.get(i);
                int preNode = list.get(i-1);
                //保证每个点都在入度map中
                if(!in.containsKey(node)){
                    in.put(node, 0);
                }
                if(!in.containsKey(preNode)){
                    in.put(preNode, 0);
                }
                Set<Integer> set = map.get(preNode);
                if(set == null){
                    set = new HashSet<>();
                    map.put(preNode, set);
                }
                if(!set.contains(node)){
                    set.add(node);
                    in.put(node, in.get(node) + 1);
                }
            }
        }
        Queue<Integer> queue = new LinkedList<>();
        for(int i : in.keySet()){
            if(in.get(i) == 0){
                queue.offer(i);
            }
        }
        while(!queue.isEmpty()){
            int node = queue.poll();
            res.add(node);
            Set<Integer> nextNodes = map.get(node);
            //减少所有连接点的入度，并将入度为0的点加入到queue
            if(nextNodes == null || nextNodes.size() == 0){
                continue;
            }
            for(int i : nextNodes){
                int indegree = in.get(i);
                indegree--;
                if(indegree == 0){
                    queue.offer(i);
                }
                in.put(i, indegree);
            }
        }
        return res;
    }
}
