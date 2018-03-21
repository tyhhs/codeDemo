package interview.airbnb;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * CombinationSumII
 * Author: bjtangyunhao
 * Creation date: 2017年09月11日 15:29
 * Modified by: bjtangyunhao
 * Last modified: 2017年09月11日 15:29
 */
public class CombinationSumII {
    public static void main(String[] args){
        int[] prices = new int[]{10, 1, 2, 7, 6, 1, 5};
        int target = 8;
        List<List<Integer>> res = combinationSum2(prices, target);
        for(List<Integer> list : res){
            for(int i : list){
                System.out.println(i);
            }
            System.out.println("##########");
        }
    }

    public static List<List<Integer>> combinationSum2(int[] candidates, int target) {
        List<List<Integer>> res = new ArrayList<>();
        if(candidates == null || candidates.length == 0){
            return res;
        }
        Arrays.sort(candidates);
        backtrack(res, new ArrayList(), candidates, target, 0);
        return res;
    }

    private static void backtrack(List<List<Integer>> res, List<Integer> comb, int[] candidates, int target, int start){
        if(target == 0){
            res.add(new ArrayList<>(comb));
        }else{
            for(int i = start; i < candidates.length; i++){
                if(candidates[i] > target){
                    break;
                }
                //skip duplicate, if current == previous, will produce duplicate
                if(i > start && candidates[i] == candidates[i-1]){
                    continue;
                }
                comb.add(candidates[i]);
                backtrack(res, comb, candidates, target - candidates[i], i + 1);
                comb.remove(comb.size() - 1);
            }
        }
    }
}
