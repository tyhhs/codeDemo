package interview.airbnb;

import java.util.*;

/**
 * RoundNumber
 * Author: bjtangyunhao
 * Creation date: 2017年09月10日 16:21
 * Modified by: bjtangyunhao
 * Last modified: 2017年09月10日 16:21
 */
public class RoundNumber {
    public static void main(String[] args) {
        double[] prices1 = new double[]{30.3, 2.4, 3.5};
        double[] prices2 = new double[]{30.9, 2.4, 3.9};
        int[] res1 = roundNumbers(prices1);
        int[] res2 = roundNumbers(prices2);
        for(int i : res1){
            System.out.println(i);
        }
        System.out.println("+++++++++++++++++++++++++++++++");
        for(int i : res2){
            System.out.println(i);
        }
    }
    public static int[] roundNumbers(double[] prices){
        int[] res = new int[prices.length];
        double sum = 0;
        int floorSum = 0;
        Map<Integer, Double> diffMap = new HashMap<>();
        for(int i = 0; i < prices.length; i++){
            int floor = (int) Math.floor(prices[i]);
            sum += prices[i];
            floorSum += floor;
            double diff = prices[i] - floor;
            diffMap.put(i, diff);
            res[i] = floor;
        }
        int sumRound = (int)Math.round(sum);
        int remaining = sumRound - floorSum;
        if(remaining == 0){
            return res;
        }
        Map<Integer,Double> sortedMap = sortMap(diffMap);
        for(Integer i : sortedMap.keySet()){
            if(remaining != 0){
                res[i]++;
                remaining--;
            }
        }
        return res;
    }

    private static Map<Integer,Double> sortMap(Map<Integer, Double> diffMap){
        List<Map.Entry<Integer,Double>> list = new ArrayList<>(diffMap.entrySet());
        //排序，差值（原double和float（double）的差）大的排前面，ceil之后绝对差小
        Collections.sort(list, new Comparator<Map.Entry<Integer,Double>>(){
            public int compare(Map.Entry<Integer,Double> entry1, Map.Entry<Integer,Double> entry2){
                return entry2.getValue().compareTo(entry1.getValue());
            }
        });
        Map<Integer,Double> res = new LinkedHashMap<>();
        for(Map.Entry<Integer,Double> entry : list){
            res.put(entry.getKey(), entry.getValue());
        }
        return res;
    }
}
