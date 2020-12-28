package sixty_OneToEighty;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

/**
 * @author :wqh
 * @description :78.子集
 * 给定一组不含重复元素的整数数组 nums，返回该数组所有可能的子集（幂集）。
 * 说明：解集不能包含重复的子集
 * @create :2020-12-14 12:34:00
 */
public class Subsets {
    //排序 -> 确定首数字 -> 确定首数字个数
    public List<List<Integer>> subsets(int[] nums) {
        Arrays.sort(nums);
        List<List<Integer>> result = new ArrayList<>();
        result.add(new ArrayList<>());
        return backtrack(nums,0,result);
    }

    List<List<Integer>> backtrack(int[] nums, int index, List<List<Integer>> result){
        if (index >= nums.length){
            return result;
        }
        //首数字个数
        int n = 1;
        int index1 = index+1;
        for (int i = index+1; i < nums.length && nums[i] == nums[index]; i++) {
            n++;
            index1++;
        }
        for (int i = 0; i < n; i++) {
            int resultSize = result.size();
            for (int j = 0; j < resultSize; j++) {
                List<Integer> newList = new ArrayList<>(result.get(j));
                newList.add(nums[index]);
                result.add(newList);
            }
        }
        return backtrack(nums,index1,result);
    }

    public static void main(String[] args) {
        System.out.println(new Subsets().subsets(new int[]{1,2,3}));
    }
}
