package Twenty_OneToFourty;
/**
 * @author wub
 * LeetCode
 * 34. Find First and Last Position of Element in Sorted Array
 *
 */
public class FindFirstAndLastPositionOfElementInSortedArray {
    public int[] searchRange(int[] nums, int target) {
        int[] result = new int[]{-1,-1};
        if (nums.length == 0 || target < nums[0] || target > nums[nums.length-1])   return result;
        int start = 0;
        int end = nums.length-1;
        int t = -1;
        while (start <= end){
            int mid = (start + end) / 2;
            if (nums[mid] == target){
                t = mid;break;
            }
            else if (nums[mid] < target)
                start = mid + 1 ;
            else end = mid - 1 ;
        }
        if (t == -1) return result;
        else{
            start = end = t;
            while (nums[--start] == target);
            while (nums[++end] == target);
            result[0] = start + 1;
            result[1] = end - 1;
        }
        return result;
    }
}
