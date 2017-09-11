package airbnb;

/**
 * Created by tyh on 2017/9/12.
 */
public class HouseRobberII {
    /*
    这回房子连成环了，言下之意是：抢第一个就不能抢最后一个，不抢第一个抢不抢最后一个随意
    两种情况：
    1.抢第一间(第二间必须不抢，第三间随意)，不抢最后一间(倒数第二间随意)
    2.不抢第一间(第二间随意)，最后一间抢不抢随意(倒数第二间也随意)
    这两种情况分别dp，找最大的就ok了
    */
    public int rob(int[] nums) {
        if (nums.length == 1) {
            return nums[0];
        }
        return Math.max(dp(nums, 0, nums.length - 2), dp(nums, 1, nums.length - 1));
    }

    private int dp(int[] nums, int low, int high) {
        int pre = 0;
        int prepre = 0;
        for (int i = low; i <= high; i++) {
            int temp = prepre;
            prepre = Math.max(pre, prepre);
            pre = temp + nums[i];
        }
        return Math.max(pre, prepre);
    }
}
