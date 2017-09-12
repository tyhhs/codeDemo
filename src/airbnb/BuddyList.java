package airbnb;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;


/**
 * BuddyList
 * Author: bjtangyunhao
 * Creation date: 2017年09月12日 15:16
 * Modified by: bjtangyunhao
 * Last modified: 2017年09月12日 15:16
 */
public class BuddyList {
    public static void main(String[] args){
        List<List<Character>> cities = new ArrayList<>();
        cities.add(Arrays.asList('a', 'b', 'e', 'f'));
        cities.add(Arrays.asList('a', 'c', 'd', 'g'));
        cities.add(Arrays.asList('g', 'w', 'r', 'a'));
        List<String> buddies = new ArrayList<>();
        buddies.add("tom");
        buddies.add("jerry");
        buddies.add("michele");
        List<Character> myCities = new ArrayList<>(Arrays.asList('a', 'b', 'c', 'd'));
        double min = 0.5;
        List<String> res = getBuddyList(cities, buddies, myCities, min);
        for(String s : res){
            System.out.println(s);
        }
    }
    public static List<String> getBuddyList(List<List<Character>> cities, List<String> buddies,
                                            List<Character> myCities, double min){
        List<String> res = new ArrayList<>();
        if(myCities == null || cities == null){
            return res;
        }
        int[] mySet = new int[26];
        for(char c : myCities){
            mySet[c - 'a'] = 1;
        }
        for(int i = 0; i < cities.size(); i++){
            List<Character> list = cities.get(i);
            double similarity = getSimilarity(list, myCities.size(), mySet);
            if(Double.compare(similarity, min) >= 0){
                res.add(buddies.get(i));
            }
        }
        return res;
    }

    private static double getSimilarity(List<Character> cities, int size, int[] set){
        if(cities == null || cities.size() == 0){
            return 0;
        }
        int count = 0;
        for(char c : cities){
            if(set[c - 'a'] == 1){
                count++;
            }
        }
        return (count + 0.0)/size;
    }
}
