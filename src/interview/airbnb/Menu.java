package interview.airbnb;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;


/**
 * Menu
 * Author: bjtangyunhao
 * Creation date: 2017年09月11日 14:19
 * Modified by: bjtangyunhao
 * Last modified: 2017年09月11日 14:19
 */
public class Menu {

    public static void main(String[] args){
        double[] prices = new double[]{2.15,2.75,3.35,3.55,4.20,5.80};
        double target = 15.05;
        List<List<Double>> res = combinationSum(prices, target);
        for(List<Double> list : res){
            for(double d : list){
                System.out.println(d);
            }
            System.out.println("##########");
        }
    }

    public static List<List<Double>> combinationSum(double[] prices, double target) {
        List<List<Double>> res = new ArrayList<>();
        if(prices == null || prices.length == 0 || target <= 0){
            return res;
        }
        Arrays.sort(prices);
        int[] pricesInt = new int[prices.length];
        int targetInt = (int)(target*100);
        for(int i = 0; i < prices.length; i++){
            pricesInt[i] = (int)(prices[i] * 100);
        }
        findCombinations(res, new ArrayList<>(), pricesInt, 0, targetInt);
        return res;
    }

    private static void findCombinations(List<List<Double>> res, List<Integer> combination, int[] prices, int n, int target){
        if (target == 0){
            res.add(parseDoubleList(combination));
        }else{
            for(int i = n; i < prices.length; i++){
                if(prices[i] > target){//trick: no need to search subsequent numbers, cause it's sorted
                    break;
                }
                combination.add(prices[i]);
                findCombinations(res, combination, prices, i, target-prices[i]);// not i + 1 because we can reuse same elements
                combination.remove(combination.size() - 1);
            }
        }
    }

    private static List<Double> parseDoubleList(List<Integer> list){
        List<Double> res = new ArrayList<>();
        if(list == null || list.size() == 0){
            return res;
        }
        for(int i : list){
            res.add((i+0.0)/100);
        }
        return res;
    }
}
