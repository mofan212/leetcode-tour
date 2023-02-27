package indi.mofan;

import java.util.HashSet;
import java.util.Set;

/**
 * @author mofan
 * @date 2023/2/27 23:25
 * @link https://leetcode.cn/problems/intersection-of-two-arrays/
 */
public class IntersectionOfTwoArrays_349 {

    public static int[] intersection(int[] nums1, int[] nums2) {
        /* 题目限制：
         * 0 <= nums1[i], nums2[i] <= 1000
         * 1 <= nums1.length, nums2.length <= 1000
         * 因此直接上数组，不用 hashSet
         */
        if (nums1 == null || nums2 == null || nums1.length == 0 || nums2.length == 0) {
            return new int[0];
        }
        Set<Integer> set = new HashSet<>();
        int[] hash1 = new int[1000];
        for (int i : nums1) {
            hash1[i] = 1;
        }

        for (int i : nums2) {
            if (hash1[i] == 1) {
                set.add(i);
            }
        }

        return set.stream().mapToInt(Integer::intValue).toArray();
    }
}
