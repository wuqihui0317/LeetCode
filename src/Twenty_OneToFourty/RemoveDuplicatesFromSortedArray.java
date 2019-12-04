package Twenty_OneToFourty;

/**
 * @author wub
 * LeetCode
 * 26.Remove Duplicates from Sorted Array
 * 删除有序数组中重复数据
 * 在原数组中修改，只需要前面k个元素是正确答案，并返回k即可
 */
public class RemoveDuplicatesFromSortedArray {
    //val记录当前遍历的值，只要等于这个值都i++
    //不等于时，nums[k++]=val,val=nums[i]
    public int removeDuplicates(int[] nums) {
        int len = nums.length;
        if (len == 0 || len == 1)
            return len;
        int k = 1;//k个不同数据
        for (int i = 1; i < len; i++) {
            int val = nums[i-1];
            while(i<len && nums[i] == val) i++;
            if (i < len)    nums[k++] = nums[i];
        }
        return k;
    }
}
