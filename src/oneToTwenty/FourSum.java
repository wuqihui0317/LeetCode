package oneToTwenty;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author wub
 * LeetCode
 * 18.4Sum
 * 找出一个int数组中，最接近target的4数之和
 */
public class FourSum {
    //先排序，按顺序先选定一个数，再按3个数的规则找剩下的三个数
    public List<List<Integer>> fourSum(int[] nums, int target) {
        List<List<Integer>> result = new ArrayList<>();
        Arrays.sort(nums);
        int len = nums.length;
        for (int i = 0; i < len - 3; i++) {
            int min = nums[i] + nums[i + 1] + nums[i + 2] + nums[i + 3];//如果最小值大于target，return result
            //如果最大值小于target，由于nums[i]的值在后面会变大，因此continue
            int max = nums[i] + nums[len - 1] + nums[len - 2] + nums[len - 3];
            if (min > target)
                return result;
            if (max < target)
                continue;
            if (max == min && min == target) {
                result.add(new ArrayList<>(Arrays.asList(nums[i], nums[i + 1], nums[i + 2], nums[i + 3])));
                return result;
            }
            for (int j = i + 1; j < len - 2; j++) {
                int T = target - nums[i] - nums[j];
                //这里的min和max代表剩下两个数的最大最小值
                min = nums[j + 1] + nums[j + 2];
                max = nums[len - 1] + nums[len - 2];
                //如果最小值大于T，其他数肯定大于T，break
                if (min > T) break;
                //如果最大值小于T，由于nums[j]在后面还会变大，因此continue
                if (max < T) continue;
                //在这使用双指针法
                int start = j + 1;
                int end = len - 1;
                while (start < end) {
                    if (nums[start] + nums[end] == T) {
                        result.add(new ArrayList<>(Arrays.asList(nums[i], nums[j], nums[start], nums[end])));
                        //如果start的下一个数和start相同，则要跳过；因为如果end的下一个也相同则会重复加入result
                        while (start < end && nums[start] == nums[++start]) ;
                        //end同理
                        while (start < end && nums[end] == nums[--end]) ;
                    } else if (nums[start] + nums[end] < T)
                        //这里也同理，如果下一个数相同，则结果也是相同的，跳过即可
                        while (start < end && nums[start] == nums[++start]) ;
                    else if (nums[start] + nums[end] > T)
                        //同上
                        while (start < end && nums[end] == nums[--end]) ;
                }
                //如果下一个j的数相同，那结果也是相同的，跳过
                while (j < len - 1 && nums[j + 1] == nums[j]) j++;
            }
            //i同j一样
            while (i < len - 1 && nums[i + 1] == nums[i]) i++;
        }
        return result;
    }

    public static void main(String[] args) {
        int[] nums = new int[]{-3, -2, -1, 0, 0, 1, 2, 3};
        System.out.println(new FourSum().fourSum(nums, 0));
    }
}
