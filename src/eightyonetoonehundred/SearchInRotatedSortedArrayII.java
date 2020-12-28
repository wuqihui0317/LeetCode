package eightyonetoonehundred;

/**
 * @author :wqh
 * @description :
 * 假设按照升序排序的数组在预先未知的某个点上进行了旋转。
 *
 * ( 例如，数组 [0,0,1,2,2,5,6] 可能变为 [2,5,6,0,0,1,2] )。
 *
 * 编写一个函数来判断给定的目标值是否存在于数组中。若存在返回 true，否则返回 false。
 * @create :2020-12-15 17:49:00
 */
public class SearchInRotatedSortedArrayII {
    //二分法，每次一半都是有序的，不在有序的一半里就在另一半找
    public boolean search(int[] nums, int target) {
        if (nums.length == 0){
            return false;
        }
        int mid = nums.length / 2;
        return backtrack(nums,target,0,nums.length);
    }
    boolean backtrack(int[] nums, int target, int start, int end){
        if (end - start == 1){
            return nums[start] == target;
        }else if (end - start == 2){
            return nums[start] == target ||
                    nums[start+1] == target;
        }else if (end - start == 3){
            return nums[start] == target ||
                    nums[start+1] == target ||
                    nums[start+2] == target;
        }
        int mid = (start + end) / 2;
        //start-mid 有序
        if (nums[mid-1] > nums[start]){
            if (target <= nums[mid-1] && target >= nums[start]){
                end = mid;
                mid = (start + end) / 2;
                while (start + 1 != end){
                    if (nums[mid] == target){
                        return true;
                    }else if (nums[mid] > target){
                        end = mid;
                    }else {
                        start = mid;
                    }
                    mid = (start + end) / 2;
                }
                return nums[start] == target;
            }else {
                return backtrack(nums,target,mid,end);
            }
        }else if (nums[mid-1] < nums[start]){
            if (target <= nums[end-1] && target >= nums[mid]){
                start = mid;
                mid = (start + end) / 2;
                while (start + 1 != end){
                    if (nums[mid] == target){
                        return true;
                    }else if (nums[mid] > target){
                        end = mid;
                    }else {
                        start = mid;
                    }
                    mid = (start + end) / 2;
                }
                return nums[start] == target;
            }else {
                return backtrack(nums,target,start,mid);
            }
        }else {
            return backtrack(nums,target,start,mid) || backtrack(nums,target,mid,end);
        }
    }

    public static void main(String[] args) {
        int[] nums = new int[]{4,5,6,7,0,1,2};
        System.out.println(new SearchInRotatedSortedArrayII().search(nums,6));
    }
}
