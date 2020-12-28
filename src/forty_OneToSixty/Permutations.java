package forty_OneToSixty;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author wub
 * LeetCode
 * 46.Permutations
 * 给一个不同数字的int数组，输出所有的排列组合
 */
public class Permutations {
    //backtrack
    //每次对数组不同数字递归剩下的n-1个数字
    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        if (nums.length <= 1){
            if (nums.length == 0)   return result;
            List<Integer> list = new ArrayList<>();
            list.add(nums[0]);
            result.add(list);
            return result;
        }
        for (int i = 0; i < nums.length; i++) {
            int temp = nums[i];nums[i] = nums[0];nums[0] = temp;//交换i和0位置上的数
            List<List<Integer>> tempList = permute(Arrays.copyOfRange(nums,1,nums.length));
            for (List<Integer> list: tempList) {
                list.add(nums[0]);
                result.add(list);
            }
            nums[0] = nums[i];nums[i] = temp;//交换回来i和0位置上的数
        }
        return result;
    }

    public static void main(String[] args) {
        int[] a = new int[]{1,2,3};
        System.out.println(new Permutations().permute(a));
    }
}
