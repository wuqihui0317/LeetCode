package twenty_OneToFourty;
/**
 * @author wub
 * LeetCode
 * 33.Search in Rotated Sorted Array
 */
public class SearchInRotatedSortedArray {
    //找到首尾的数，如果target>=nums[0]则从开头找，否则从结尾开始找
    public int search(int[] nums, int target){
        if (nums.length == 0)   return -1;
        if(nums[0] <= target){
            for (int i = 0; i < nums.length; i++) {
                if (i>0 && nums[i] < nums[i-1]) return -1;
                if (nums[i] == target)  return i;
            }
        }
        else {
            for (int i = nums.length-1; i >= 0 ; i--) {
                if (i<nums.length-1 && nums[i] > nums[i+1]) return -1;
                if (nums[i] == target)  return i;
            }
        }
        return -1;
    }
}
