package interview.airbnb;

/**
 * Created by tyh on 2017/9/12.
 */
public class HouseRobber {

    /**
     * 动态规划
     * dp = Math.max(dp[i - 1], dp[i - 2] + num);.
     * Java O(n) solution, space O(1)
     * @param num
     * @return
     */
    public int rob(int[] num) {
        int prevNo = 0;
        int prevYes = 0;
        for (int n : num) {
            int temp = prevNo;
            prevNo = Math.max(prevNo, prevYes);
            prevYes = n + temp;
        }
        return Math.max(prevNo, prevYes);
    }
}
