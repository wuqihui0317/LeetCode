package twenty_OneToFourty;
/**
 * @author wub
 * LeetCode
 * 35. Search Insert Position
 * 在有序的nums数组中找到target或其应该所在的位置
 */
public class SearchInsertPosition {
    public int searchInsert(int[] nums, int target) {
        if (nums[0] >= target)   return 0;
        int start = 0;
        int end = nums.length-1;
        if (nums[end] < target) return end + 1;
        while (end - start > 2){
            int mid = (start + end)/2;
            if (nums[mid] == target)    return mid;
            else if (nums[mid] > target)    end = mid -1;
            else start = mid + 1;
        }
        for (int i = start; i < end; i++) {
            if (nums[i] >= target)  return i;
        }
        return end+1;
    }
}
