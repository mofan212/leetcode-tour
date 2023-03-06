package indi.mofan;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author mofan
 * @date 2023/3/6 22:21
 * @link https://leetcode.cn/problems/4sum/
 */
public class FourSum_18 {
    public List<List<Integer>> fourSum(int[] nums, int target) {
        List<List<Integer>> result = new ArrayList<>();
        Arrays.sort(nums);

        for (int i = 0; i < nums.length; i++) {
            // 去重
            if (i > 0 && nums[i] == nums[i - 1]) {
                continue;
            }
            // 剪枝：注意 nums[i] > 0 的条件，因为负数相加后会更小
            if (nums[i] >= target && nums[i] > 0) {
                break;
            }
            for (int j = i + 1; j < nums.length; j++) {
                // 去重
                if (j > i + 1 && nums[j] == nums[j - 1]) {
                    continue;
                }
                // 剪枝
                if (nums[i] + nums[j] >= target && nums[j] > 0) {
                    break;
                }
                int left = j + 1;
                int right = nums.length - 1;
                while (right > left) {
                    // 求和要在 while 内，否则会 outOfBounds，还要注意求和可能会溢出
                    long temp = nums[i] + nums[j] + nums[left] + nums[right];
                    if (temp > target) {
                        right--;
                    } else if (temp < target) {
                        left++;
                    } else {
                        result.add(Arrays.asList(nums[i], nums[j], nums[left], nums[right]));
                        while (right > left && nums[right] == nums[right - 1]) {
                            right--;
                        }
                        while (right > left && nums[left] == nums[left + 1]) {
                            left++;
                        }
                        right--;
                        left++;
                    }
                }
            }
        }
        return result;
    }
}
