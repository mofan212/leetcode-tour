package indi.mofan;

import java.util.Arrays;

/**
 * @author mofan
 * @date 2023/2/8 16:48
 * @link https://leetcode.cn/problems/squares-of-a-sorted-array/
 */
public class SquaresOfASortedArray_977 {
    public static void main(String[] args) {
        int[] nums = new int[]{-4, -1, 0, 3, 10};
        // [0,1,9,16,100]
        System.out.println(Arrays.toString(sortedSquares(nums)));
        nums = new int[]{-7, -3, 2, 3, 11};
        // [4,9,9,49,121]
        System.out.println(Arrays.toString(sortedSquares(nums)));
    }

    public static int[] sortedSquares(int[] nums) {
        int[] result = new int[nums.length];
        int maxIndex = nums.length - 1;
        for (int start = 0, end = nums.length - 1; start <= end; ) {
            int startProduct = nums[start] * nums[start];
            int endProduct = nums[end] * nums[end];
            if (startProduct > endProduct) {
                result[maxIndex--] = startProduct;
                start++;
            } else {
                result[maxIndex--] = endProduct;
                end--;
            }
        }
        return result;
    }
}
