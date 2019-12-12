package Forty_OneToSixty;

import java.util.Arrays;
import java.util.Date;

/**
 * @author wub
 * LeetCode
 * 60.Permutation Sequence
 * 按从小到大顺序排列1~n n个数字，返回第k个数字
 */
public class PermutationSequence {
    //n个数字一共有n！种排列组合
    //先确定前面的数字，确定第一位数字后（n种可能），第二个数字有n-1种可能。。。
    public String getPermutation(int n, int k) {
        int[] result = new int[n];
        int fact = 1;
        for (int i = 1; i < n; i++) {
            result[i] = i+1;
            fact *= i;
        }
        result[0] = 1;
        backtrack(result,0,n-1,fact,k);
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < n; i++) {
            sb.append(result[i]);
        }
        return sb.toString();
    }
    //回溯
    void backtrack(int[] nums,int start,int end,int fact,int k){
        if (start == end || k == 1)   return;
        //剪枝
        while(k < fact){
            fact = fact/(end-start);
            start++;
        }
        int index = start;//记录start位置上的值应该是后面第几个数
        while (k > fact){
            k -= fact;index++;
        }
        fact = fact/(end-start);
        //交换start和index上的数，并排序
        if (index != start){
            int temp = nums[index];
            //start上的数是最小的
            for (int i = index; i > start; i--) {
                nums[i] = nums[i-1];
            }
            nums[start] = temp;
        }
        backtrack(nums,start+1,end,fact,k);
    }

    public static void main(String[] args) {
        Date a = new Date();
        System.out.println(new PermutationSequence().getPermutation(3,5));
        Date b = new Date();
        System.out.println(b.getTime()-a.getTime());
    }
}
