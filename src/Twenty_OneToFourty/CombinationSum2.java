package Twenty_OneToFourty;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author wub
 * LeetCode
 * 40. Combination Sum II
 * 与39不同的是，这里的数组元素是可重复的，但结果集中不能重复，数组中元素不可重复使用
 */
public class CombinationSum2 {
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        Arrays.sort(candidates);
        if (candidates.length == 0 || target < candidates[0]) return new ArrayList<>();
        return backtrack(candidates,target);
    }
    //回溯
    public List<List<Integer>> backtrack(int[] candidates, int target) {
        List<List<Integer>> result = new ArrayList<>();
        for (int i = 0; i < candidates.length; i++) {
            if (candidates[i] == target){
                List<Integer> list = new ArrayList<>();
                list.add(target);
                result.add(list);
                return result;
            }
            else if (candidates[i] > target)
                return result;
            else {
                List<List<Integer>> list = backtrack(Arrays.copyOfRange(candidates,i+1,candidates.length),target-candidates[i]);
                for (List<Integer> temp:list) {
                    temp.add(candidates[i]);
                    result.add(temp);
                }
            }
            while (i+1 < candidates.length && candidates[i+1] == candidates[i])    i++;
        }
        return result;
    }
    public static void main(String[] args) {
        int[] a = new int[]{4,4,2,1,4,2,2,1,3};
        System.out.println(new CombinationSum2().combinationSum2(a,6));
    }
}
