package OneToTwenty;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Iterator;

/**
 * @author wub
 * LeetCode
 * 1.两数之和
 */
public class TwoSum {
    //暴力算法
    public int[] fun(int[] nums, int target) {
        int i, j = 0;
        boolean flag = false;
        for (i = 0; i < nums.length - 1; i++) {
            for (j = i + 1; j < nums.length; j++) {
                if (nums[i] + nums[j] == target) {
                    flag = true;
                    break;
                }
            }
            if (flag) break;
        }
        int[] arr = {i, j};
        return arr;
    }

    //HashMap
    public int[] mapFun(int[] nums, int target) {
        HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();
        for (int i = 0; i < nums.length; i++) {
            if (map.containsKey(nums[i])) {
                if (nums[i] * 2 == target)
                    return new int[]{map.get(nums[i]), i};
            } else map.put(nums[i], i);
        }
        Iterator<Integer> it = map.keySet().iterator();
        while (it.hasNext()) {
            int m = it.next().intValue();
            int t = target - m;
            if (map.containsKey(t)) {
                int n = map.get(t);
                return new int[]{map.get(m), n};
            }
        }
        throw new IllegalArgumentException();
    }

    public static void main(String[] args) {
        TwoSum a = new TwoSum();
        int[] nums = {0, 2, 7, 11, 5};
        int target = 9;
        System.out.println(Arrays.toString(a.mapFun(nums, target)));
    }
}
