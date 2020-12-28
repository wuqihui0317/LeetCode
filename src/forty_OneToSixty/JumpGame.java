package forty_OneToSixty;


/**
 * @author wub
 * LeetCode
 * 55.Jump Game
 * 给定一个非负数组，每个数代表在这个点能jump的长度
 * 判断是否能到达数组末
 */
public class JumpGame {
    //回溯
    /*
    public boolean canJump(int[] nums){
        if (nums.length < 2){
            return true;
        }
        if (nums[0] >= nums.length-1) return true;
        if (nums[0] == 0)   return false;
        int max = 1;
        for (int i = 2; i <= nums[0] && i < nums.length; i++) {
            if (i+nums[i] > nums[0])
                max = nums[max]<=nums[i]?i:max;
        }
        return canJump(Arrays.copyOfRange(nums,max,nums.length));
    }
*/
    //自底向上的动态规划
    //用一个boolean数组判断各个位置能不能调到nums的终点
    //从nums的最后一个开始动态规划
    /*
    public boolean canJump(int[] nums){
        boolean[] boo = new boolean[nums.length];
        boo[nums.length-1] = true;
        for (int i = nums.length-2; i >=0 ; i--) {
            if (i+nums[i] >= nums.length-1){
                boo[i] = true;continue;
            }
            for (int j = 1; j <= nums[i]; j++) {
                if (boo[j+i]) {
                    boo[i] = true;
                    break;
                }
            }
        }
        return boo[0];
    }
     */

    //贪心
    //在自底向上的动态规划算法中，用index记录当前点右边最左边canJump的点
    //从而只需要判断当前点能否到达index即可，不需要再遍历，更新index
    public boolean canJump(int[] nums){
        boolean[] boo = new boolean[nums.length];
        int index = nums.length - 1;
        boo[index] = true;
        for (int i = nums.length-2; i >= 0; i--) {
            if (nums[i] + i >= index) {
                boo[i] = true;
                index = i;
            }
        }
        return boo[0];
    }
    public static void main(String[] args) {
        int[] a = new int[]{1,2,3};
        System.out.println(new JumpGame().canJump(a));
    }
}
