package airbnb;

import java.util.ArrayList;
import java.util.List;

/**
 * Permutations
 * Author: bjtangyunhao
 * Creation date: 2017年09月12日 16:02
 * Modified by: bjtangyunhao
 * Last modified: 2017年09月12日 16:02
 */
public class Permutations {

    public static void main(String[] args) {
        int[] nums = new int[]{1, 2, 3};
        List<List<Integer>> res = permute(nums);
        for(List<Integer> list : res){
            for(int i : list){
                System.out.print(i + " ");
            }
            System.out.println();
        }
    }

    public static List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        if(nums.length == 0){
            return res;
        }
        bt(res, new ArrayList<>(), nums);
        return res;
    }

    private static void bt(List<List<Integer>> res, List<Integer> list, int[] nums){
        if(list.size() == nums.length){
            res.add(new ArrayList<>(list));
        }
        for(int i = 0; i < nums.length; i++){
            if(list.contains(nums[i])){
                continue;
            }
            list.add(nums[i]);
            bt(res, list, nums);
            list.remove(list.size()-1);
        }
    }
}
