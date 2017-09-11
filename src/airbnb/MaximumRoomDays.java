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
        int prev1 = nums[0];

        for (int i = 2; i <= nums.length; i++) {
            int curr = Math.max(prev1, prev2 + nums[i - 1]);

            prev2 = prev1;
            prev1 = curr;
        }

        return prev1;
    }
}
