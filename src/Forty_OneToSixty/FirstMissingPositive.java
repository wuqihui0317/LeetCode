package Forty_OneToSixty;

import java.util.HashSet;
import java.util.Set;

/**
 * @author wub
 * LeetCode
 * 41.First Missing Positive
 * 找出nums数组中不存在的最小正整数
 * 要求时间复杂度为O(n)
 * 思路：使用Set
 */
public class FirstMissingPositive {
    public int firstMissingPositive(int[] nums) {
        Set<Integer> set = new HashSet<>();
        int min = Integer.MAX_VALUE;
        for (int n:nums) {
            if (n>0) {
                set.add(n);
                if (n < min)
                    min = n;
            }
        }
        if (min != 1)   return 1;
        for (int i = 2; true; i++) {
            if (!set.contains(i)) return i;
        }
    }
}
