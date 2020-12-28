package oneToTwenty;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author wub
 * LeetCode
 * 15.3Sum
 * 找出一个int数组中，所有的总和为0的三个整数
 */
public class ThreeSum {
    //思路：先把数组转化为升序排列，然后双指针法：
    //      k=0从nums1[0]开始右移，i=k+0,j=nums1.lenth-1;targer = 0-nums1[k]即想要得到的i+j的值
    //      如果nums1[i]>target或者nums1[j]<targer，返回现有值
    //      if i+j>target j--,else i++直到i==j
    public List<List<Integer>> threeSum(int[] nums) {
        Arrays.sort(nums);
        List<List<Integer>> result = new ArrayList<>();
        for (int k = 0; k < nums.length - 2; k++) {
            if (k > 0 && nums[k] == nums[k - 1])
                continue;
            int i = k + 1;
            int j = nums.length - 1;
            //如果最小值大于0，那么下面的肯定不存在了
            if (nums[k] > 0)
                break;
            int target = 0 - nums[k];
            while (i < j) {
                if (nums[j] < 0)
                    break;
                if (nums[i] + nums[j] > target)
                    j--;
                else if (nums[i] + nums[j] < target)
                    i++;
                else {
                    result.add(new ArrayList<Integer>(Arrays.asList(nums[k], nums[i], nums[j])));
                    //如果i（j）和i+1上的数相同那么要要继续i++，否则当i和i+1相同，j和j+1相同时会有两个重复值
                    while (i < j && nums[i] == nums[++i]) ;
                    while (i < j && nums[j] == nums[--j]) ;
                }
            }
        }
        return result;
    }

    public static void main(String[] args) {
        System.out.println(new ThreeSum().threeSum(new int[]{1, 1, -2}));
    }
}
