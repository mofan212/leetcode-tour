package indi.mofan;

/**
 * @author mofan
 * @date 2023/2/6 20:35
 * @link https://leetcode.cn/problems/binary-search/
 */
public class BinarySearch_704 {
    public static void main(String[] args) {
        // nums = [-1,0,3,5,9,12], target = 9
        int[] nums = {-1, 0, 3, 5, 9, 12};
        assert search(nums, 9) == 4;
        // nums = [-1,0,3,5,9,12], target = 2, 不存在时返回 -1
        assert search(nums, 2) == -1;
    }

    public static int search(int[] nums, int target) {
        int startIndex = -1;
        int endIndex = nums.length;

        // nums 升序
        while (startIndex + 1 != endIndex) {
            int mid = (startIndex + endIndex) >> 1;
            if (nums[mid] < target) {
                startIndex = mid;
            } else if (nums[mid] > target){
                endIndex = mid;
            } else {
                return mid;
            }
        }
        return -1;
    }
}
