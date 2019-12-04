package Twenty_OneToFourty;
/**
 * @author wub
 * LeetCode
 * 27.Remove Element
 * 删除数组中值为nums[val]的所有元素
 */
public class RemoveElement {
    //k记录结果集大小，同时确定当前所在的下标方便插入数组
    // 遍历数组，当值不等于nums[val]时就放在下标为k上
    public int removeElement(int[] nums, int val) {
        if (nums.length == 0)
            return 0;
        int k = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] != val)
                nums[k++] = nums[i];
        }
        return k;
    }
}
