package indi.mofan;

import java.util.HashMap;
import java.util.Map;

/**
 * @author mofan
 * @date 2023/3/1 21:52
 * @link https://leetcode.cn/problems/two-sum/
 */
public class TwoSum_1 {
    public int[] twoSum(int[] nums, int target) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            int temp = target - nums[i];
            Integer integer = map.get(temp);
            if (integer == null) {
                map.put(nums[i], i);
            } else {
                return new int[]{i, integer};
            }
        }
        return new int[0];
    }
}
