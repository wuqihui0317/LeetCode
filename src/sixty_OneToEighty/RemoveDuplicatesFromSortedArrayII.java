package sixty_OneToEighty;

/**
 * @author :wqh
 * @description :
 * 给定一个增序排列数组 nums ，你需要在 原地 删除重复出现的元素，使得每个元素最多出现两次，返回移除后数组的新长度。
 *
 * 不要使用额外的数组空间，你必须在 原地 修改输入数组 并在使用 O(1) 额外空间的条件下完成。
 * @create :2020-12-15 10:31:00
 */
public class RemoveDuplicatesFromSortedArrayII {
    public int removeDuplicates(int[] nums) {
        if (nums.length == 0){
            return 0;
        }
        int len = 1;
        int num = nums[0];
        int count = 1;
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] == num){
                if (count == 2){
                    continue;
                }else {
                    count++;
                    nums[len++] = num;
                }
            }else {
                count = 1;
                nums[len++] = nums[i];
                num = nums[i];
            }
        }
        return len;
    }
}
