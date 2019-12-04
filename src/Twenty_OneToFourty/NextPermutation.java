package Twenty_OneToFourty;

import java.util.Arrays;

/**
 * @author wub
 * LeetCode
 * 31.Next Permutation
 */
public class NextPermutation {
    //从数组倒数第二个开始，如果这个数后面的数有比他大的最小数，调换并升序排列后面的数
    public void nextPermutation(int[] nums) {
        int index = 0;
        for (int i = nums.length-2; i >=0 ; i--) {
            if (nums[i] < nums[i+1]){
                int j ;
                for (j = i+1; j < nums.length; j++) {
                    if (nums[j] <= nums[i])
                        break;
                }
                j--;
                int temp = nums[i];
                nums[i] = nums[j];
                nums[j] = temp;
                index = i+1;
                break;
            }
        }
        //反转index后面的数
        Arrays.sort(nums,index,nums.length);
    }

    public static void main(String[] args) {
        int[] a = new int[]{1,5,1};
        new NextPermutation().nextPermutation(a);
        System.out.println(a);
    }
}
