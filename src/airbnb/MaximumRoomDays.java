package airbnb;

/**
 * Created by tyh on 2017/9/12.
 */
public class MaximumRoomDays {
    //like house robber
    public static void main(String[] args) {
        int[] nums = new int[]{4,10,3,1,5};

        int result = getMaxRentalDays(nums);

        System.out.println(result);
    }

    public static int getMaxRentalDays(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }

        int prev2 = 0;
        int prev1 = 0;
        for (int i : nums) {
            int temp = prev1;
            prev1 = prev2 + i;
            prev2 = Math.max(temp, prev2);
        }

        return Math.max(prev1, prev2);
    }
}
