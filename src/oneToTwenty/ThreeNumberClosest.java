package oneToTwenty;
import java.util.Arrays;

/**
 * @author wub
 * LeetCode
 * 15.3SumClosest
 * 找出一个int数组中，最接近target的三数之和
 */
public class ThreeNumberClosest {
    //思路：和3Sum相似，先对数组排序，再双指针法找到与target的绝对值最小的值result
    public int threeNumberClosest(int[] nums, int target) {
        Arrays.sort(nums);
        int result = nums[0] + nums[1] + nums[2];
        for (int k = 0; k < nums.length - 2; k++) {
            int i = k + 1;
            int j = nums.length - 1;
            //优化
            int min = nums[k] + nums[k + 1] + nums[k + 2];//区间最小值
            int max = nums[k] + nums[j] + nums[j - 1];//区间最大值
            //区间最大值比target小，没比要比较其他值了
            if (max < target) {
                if (target - max < Math.abs(result - target))
                    result = max;
                continue;
            }
            //区间最小值比target大，没必要比较其他值了
            if (min > target) {
                if (min - target < Math.abs(result - target))
                    result = min;
                continue;
            }
            while (i < j) {
                int sum = nums[i] + nums[j] + nums[k];
                if (Math.abs(result - target) > Math.abs(sum - target))
                    result = sum;
                if (sum == target) return sum;
                else if (sum > target) j--;
                else i++;
            }
        }
        return result;
    }

    public static void main(String[] args) {
        System.out.println(new ThreeNumberClosest().threeNumberClosest(new int[]{-1, 2, 1, -4}, 1));
    }
}
