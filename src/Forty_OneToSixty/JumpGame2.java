package Forty_OneToSixty;

/**
 * @author wub
 * LeetCode
 * 45.Jump Game2
 * 给定一个非负数组，每个数代表在这个点能jump的长度
 * 假设所有数组都可以到达尾部，求最少的跳跃次数
 */
public class JumpGame2 {
    //思路：类似于计网的路由选择算法
    //自底向上的动态规划，用int数组记录各个点到达数组尾部的最小跳跃次数
    /*
    public int jump(int[] nums) {
        int[] jumpsNumber = new int[nums.length];
        Arrays.fill(jumpsNumber,0,nums.length-1,Integer.MAX_VALUE/2);
        for (int i = nums.length-2; i >= 0; i--) {
            if (i+nums[i] >= nums.length-1){
                jumpsNumber[i] = 1;continue;
            }
            int min = Integer.MAX_VALUE;//记录i后面跳跃次数的最小值
            for (int j = 1; j <= nums[i] && i+j < nums.length; j++) {
                min = min>jumpsNumber[i+j]?jumpsNumber[i+j]:min;
            }
            if (min == Integer.MAX_VALUE)
                jumpsNumber[i] = min;
            else
                jumpsNumber[i] = min + 1;
        }
        return jumpsNumber[0];
    }
     */

    /**
     * [2,       3,1,       1,2,2,1]
     * [2,3,       1,1,2,       2,1]
     * [2,3,1,1,2,       2,1        ]
     *
     * 将数组分成三段，最左边，已经到达的位置。中间，此次可以到达的位置。右边，本次不能到达的位置。
     * 对于数组[2,       3,1,       1,2,2,1]。第一步可以到达index=1或者index=2.但是如果调到index=1的话显然下次可以跳的更远。因此第一步跳到index=1的位置。
     * 变成[2,3,       1,1,2,       2,1]。第二次可以到达index=2，3，4。显然跳到index=4的话，下次可以跳的更远。
     * 此时变成[2,3,1,1,2,       2,1       ]。此时一次跳2步到达最右端。
     * 总结一下规律，我们在跳的时候会考虑到下一步。根据下一步能跳的最远的贪心策略，来进行每一步的选择。

     * @param nums
     * @return
     */
    public int jump(int[] nums) {
        int jumpsTime = 0;
        int index = 0;//现在所处的位置
        while(index < nums.length-1){
            //如果index点上能直接调到终点
            if (index+nums[index] >= nums.length-1){
                return jumpsTime+1;
            }
            //找出在index跳一次能到的区域里，下一跳能跳的最远的点
            //并把这个点更新为下一跳
            int max = -1;
            int maxIndex = index;
            for (int i = 1; i <= nums[index] && index+i < nums.length; i++) {
                if (max<nums[index+i]+index+i){
                    max = nums[index+i] + index+i;
                    maxIndex = i+index;
                }
            }
            index = maxIndex;
            jumpsTime++;
        }
        return jumpsTime;
    }
    public static void main(String[] args) {
        int[] a = new int[]{1,2,1,1,1};
        System.out.println(new JumpGame2().jump(a));
    }
}
