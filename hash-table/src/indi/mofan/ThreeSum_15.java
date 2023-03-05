package indi.mofan;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author mofan
 * @date 2023/3/5 13:18
 * @link https://leetcode.cn/problems/3sum/
 */
public class ThreeSum_15 {
    public List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        Arrays.sort(nums);
        for (int i = 0; i < nums.length; i++) {
            // 排序后的第一个数大于 0，则不存在结果
            if (nums[i] > 0) {
                break;
            }

            // 去重起点
            if (i > 0 && nums[i] == nums[i - 1]) {
                continue;
            }

            int left = i + 1;
            int right = nums.length - 1;

            while (right > left) {
                int temp = nums[i] + nums[left] + nums[right];
                // 根据结果收缩 right 和 left
                if (temp > 0) {
                    right--;
                    // 收缩 right 时也可以去重
                    if (right > left && nums[right] == nums[right + 1]) {
                        right--;
                    }
                } else if (temp < 0) {
                    left++;
                    // 收缩 left 时，也可以去重
                    if (right > left && nums[left] == nums[left - 1]) {
                        left++;
                    }
                } else {
                    result.add(Arrays.asList(nums[i], nums[left], nums[right]));
                    // 去重 right
                    while (right > left && nums[right] == nums[right - 1]) {
                        right--;
                    }
                    // 去重 left
                    while (right > left && nums[left] == nums[left + 1]) {
                        left++;
                    }
                    // 去重完成后，再收缩一次，找下一次结果
                    right--;
                    left++;
                }
            }
        }
        return result;
    }
}
