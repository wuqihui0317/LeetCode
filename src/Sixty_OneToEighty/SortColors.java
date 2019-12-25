package Sixty_OneToEighty;

/**
 * @author wub
 * LeetCode
 * 75.Sort Colors
 * 0,1,2 三色排序
 * 荷兰国旗问题
 */
public class SortColors {
    public void sortColors(int[] nums) {
        int p0 = 0;
        int p2 = nums.length-1;
        int p = 0;
        while (p <= p2){
            if (nums[p] == 0){
                if (p != p0){
                    int temp = nums[p];
                    nums[p] = nums[p0];
                    nums[p0] = temp;
                }
                p++;p0++;
            }else if (nums[p] == 1){
                p++;
            }else if (nums[p] == 2){
                int temp = nums[p];
                nums[p] = nums[p2];
                nums[p2] = temp;
                p2--;
            }
        }
    }
}
