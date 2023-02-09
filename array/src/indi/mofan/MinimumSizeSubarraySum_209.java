package indi.mofan;

/**
 * @author mofan
 * @date 2023/2/9 18:28
 * @link https://leetcode.cn/problems/minimum-size-subarray-sum/
 */
public class MinimumSizeSubarraySum_209 {
    public static void main(String[] args) {
        int[] nums = new int[]{2, 3, 1, 2, 4, 3};
        // 2
        System.out.println(minSubArrayLen_for(7, nums));

        nums = new int[]{1, 4, 4};
        // 1
        System.out.println(minSubArrayLen_for(4, nums));

        nums = new int[]{1, 1, 1, 1, 1, 1, 1, 1};
        // 0
        System.out.println(minSubArrayLen_for(11, nums));
    }

    public static int minSubArrayLen(int target, int[] nums) {
        int start = 0, windowStart = 0, sum = 0;
        int result = Integer.MAX_VALUE;
        while (start < nums.length) {
            if (sum >= target) {
                result = Math.min(result, windowStart - start);
                sum -= nums[start++];
            } else {
                if (windowStart >= nums.length) break;
                sum += nums[windowStart++];
            }
        }
        return result == Integer.MAX_VALUE ? 0 : result;
    }

    public static int minSubArrayLen_for(int target, int[] nums) {
        int left = 0, result = Integer.MAX_VALUE, sum = 0;
        for (int right = 0; right < nums.length; right++) {
            sum += nums[right];
            while (sum >= target) {
                result = Math.min(result, right - left + 1);
                sum -= nums[left++];
            }
        }
        return result == Integer.MAX_VALUE ? 0 : result;
    }
}
