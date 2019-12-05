package Forty_OneToSixty;

import java.util.*;

/**
 * @author wub
 * LeetCode
 * 47.Permutations2
 * 给一个可以有相同数字的int数组，输出所有的排列组合
 */
public class Permutations2 {
    /**
     * 直接用HashSet，耗时太大
     * @param nums
     * @return
     */
    /*
    public List<List<Integer>> permuteUnique(int[] nums) {
        Set<List<Integer>> set = backtrack(nums);
        List<List<Integer>> result = new ArrayList<>();
        for (List<Integer> list:set) {
            result.add(list);
        }
        return result;
    }
    public Set<List<Integer>> backtrack(int[] nums){
        Set<List<Integer>> set = new HashSet<>();
        if (nums.length <= 1){
            if (nums.length == 0)   return set;
            List<Integer> list = new ArrayList<>();
            list.add(nums[0]);
            set.add(list);
            return set;
        }
        for (int i = 0; i < nums.length; i++) {
            int temp = nums[i];nums[i] = nums[0];nums[0] = temp;//交换i和0位置上的数
            Set<List<Integer>> tempSet = backtrack(Arrays.copyOfRange(nums,1,nums.length));
            for (List<Integer> list: tempSet) {
                list.add(nums[0]);
                set.add(list);
            }
            nums[0] = nums[i];nums[i] = temp;//交换回来i和0位置上的数
        }
        return set;
    }
     */

    /**
     * 通过给nums排序，在递归时跳过之前已经递归过的数
     * @param nums
     * @return
     */
    public List<List<Integer>> permuteUnique(int[] nums) {
        Arrays.sort(nums);
        List<List<Integer>> result = new ArrayList<>();
        if (nums.length <= 1){
            if (nums.length == 0)   return result;
            List<Integer> list = new ArrayList<>();
            list.add(nums[0]);
            result.add(list);
            return result;
        }
        for (int i = 0; i < nums.length; i++) {
            while(i<nums.length-1 && nums[i] == nums[1+i]) i++;
            int temp = nums[i];nums[i] = nums[0];nums[0] = temp;//交换i和0位置上的数
            List<List<Integer>> tempList = permuteUnique(Arrays.copyOfRange(nums,1,nums.length));
            for (List<Integer> list: tempList) {
                list.add(nums[0]);
                result.add(list);
            }
            nums[0] = nums[i];nums[i] = temp;//交换回来i和0位置上的数
        }
        return result;
    }
    public static void main(String[] args) {
        int[] a = new int[]{1,1,2,2};
        System.out.println(new Permutations2().permuteUnique(a));
    }
}
