package twenty_OneToFourty;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author wub
 * LeetCode
 * 39.Combination Sum
 * 找出不重复数组candidates中所有和为target的数，candidates中的数可重复使用
 */
public class CombinationSum {
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        Arrays.sort(candidates);
        List<List<Integer>> result = new ArrayList<>();
        for (int i = 0; i < candidates.length; i++) {
            if (candidates[i] == target){
                List<Integer> temp = new ArrayList<>();
                temp.add(target);
                result.add(temp);
                break;
            }
            if (candidates[i] > target) break;
            List<List<Integer>> rest = combinationSum(Arrays.copyOfRange(candidates,i,candidates.length),target-candidates[i]);
            for (List<Integer> list:rest) {
                list.add(candidates[i]);
                result.add(list);
            }
        }
        return result;
    }

    public static void main(String[] args) {
        int[] a = new int[]{2,3,6,7};
        System.out.println(new CombinationSum().combinationSum(a,7));
    }
}
