package indi.mofan;

import java.util.HashMap;
import java.util.Map;

/**
 * @author mofan
 * @date 2023/3/2 20:17
 * @link https://leetcode.cn/problems/4sum-ii/
 */
public class FourSumII_454 {
    public int fourSumCount(int[] nums1, int[] nums2, int[] nums3, int[] nums4) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int i1 : nums1) {
            for (int i2 : nums2) {
                int temp = i1 + i2;
                if (map.containsKey(temp)) {
                    map.put(temp, map.get(temp) + 1);
                } else {
                    map.put(temp, 1);
                }
            }
        }

        int count = 0;
        for (int i3 : nums3) {
            for (int i4 : nums4) {
                int temp = i3 + i4;
                Integer tempSum = map.get(-temp);
                if (tempSum != null) {
                    count += tempSum;
                }
            }
        }
        return count;
    }
}
