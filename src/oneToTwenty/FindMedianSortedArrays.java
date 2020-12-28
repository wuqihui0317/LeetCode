package oneToTwenty;
/**
 * @author wub
 * LeetCode
 * 4.寻找两个有序数组的中位数
 */
public class FindMedianSortedArrays {
    //实质：l1+l2奇数，找第 (l1+l2+1)/2个数
    //      l1+l2偶数，找第 (l1+l2)/2 和(l1+l2+1)/2 个数的平均值
    //思路：index是向下取整的中位数，比较两个数组的第index/2个数
    //较小的那个数组的前index/2数都不是要找的数
    //index = index - index/2
    //接下去比较这个数组剩下的数和另一个数组，直到index=1
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int l1 = nums1.length;
        int l2 = nums2.length;
        int index = (l1 + l2) / 2;
        double num1 = 0, num2 = 0;//第(l1 + l2)/2个和第(l1 + l2)/2+1个数
        boolean even;
        if ((l1 + l2) % 2 == 1)
            even = false;
        else even = true;
        int i = 0;//nums1数组起始下标
        int j = 0;//nums2数组起始下标
        //有一个数组为空的情况下
        if (l1 == 0) {
            if (even) {
                num1 = nums2[index];
                num2 = nums2[index - 1];
                return (num1 + num2) / 2;
            } else return nums2[index];
        }
        if (l2 == 0) {
            if (even) {
                num1 = nums1[index];
                num2 = nums1[index - 1];
                return (num1 + num2) / 2;
            } else return nums1[index];
        }
        while (index != 1) {
            if (l1 == 0) {
                num1 = nums2[j + index - 1];
                num2 = nums2[j + index];
                break;
            }
            if (l2 == 0) {
                num1 = nums1[i + index - 1];
                num2 = nums1[i + index];
                break;
            }
            //比较第index/2个数，如果没有index/2个数，则比较该数组的最大数
            if (l1 >= index / 2 && l2 >= index / 2) {
                //两个数组都有index/2个数的情况
                if (nums1[i + index / 2 - 1] < nums2[j + index / 2 - 1]) {
                    i += index / 2;
                    l1 -= index / 2;
                } else {
                    j += index / 2;
                    l2 -= index / 2;
                }
                index -= index / 2;
                continue;
            } else if (l1 < index / 2) {
                //nums1剩下的数组长度小于index/2的情况
                if (nums1[i + l1 - 1] < nums2[j + index / 2 - 1]) {
                    index -= l1;
                    i += l1;
                    l1 = 0;
                } else {
                    j += index / 2;
                    l2 -= index / 2;
                    index -= index / 2;
                }
                continue;
            } else {
                //nums2剩下的数组长度小于index/2的情况
                if (nums1[i + index / 2 - 1] < nums2[j + l2 - 1]) {
                    i += index / 2;
                    l1 -= index / 2;
                    index -= index / 2;
                } else {
                    index -= l2;
                    j += l2;
                    l2 = 0;
                }
                continue;
            }

        }
        if (l1 == 0) {
            num1 = nums2[j + index - 1];
            num2 = nums2[j + index];
        }
        if (l2 == 0) {
            num1 = nums1[i + index - 1];
            num2 = nums1[i + index];
        }
        if (l1 != 0 && l2 != 0) {
            if (nums1[i] < nums2[j]) {
                num1 = nums1[i];
                if (l1 > 1) {
                    if (nums1[i + 1] < nums2[j])
                        num2 = nums1[i + 1];
                    else num2 = nums2[j];
                } else num2 = nums2[j];
            } else {
                num1 = nums2[j];
                if (l2 > 1) {
                    if (nums1[i] < nums2[j + 1])
                        num2 = nums1[i];
                    else num2 = nums2[j + 1];
                } else num2 = nums1[i];
            }
        }
        if (even)
            return (num1 + num2) / 2;
        else return num2;
    }

    public static void main(String[] args) {
        int[] nums1 = new int[]{3};
        int[] nums2 = new int[]{1, 2, 4, 5, 6, 7, 8};
        int[] nums3 = new int[]{};
        System.out.println(nums3.length);
        System.out.println(new FindMedianSortedArrays().findMedianSortedArrays(nums1, nums2));
    }
}
