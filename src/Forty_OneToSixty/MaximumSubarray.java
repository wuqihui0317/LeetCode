package Forty_OneToSixty;
/**
 * @author wub
 * LeetCode
 * 53.MaximumSubarray
 * 找出一个数组中相邻数之和的最大值，返回这个最大值
 */
public class MaximumSubarray {
    public int maxSubArray(int[] nums) {
        int result = nums[0];
        int sum = 0;
        for (int num:nums){
            if (sum > 0){
                sum += num;
            }else{
                sum = num;
            }
            result = sum>result?sum:result;
        }
        return result;
    }
}
