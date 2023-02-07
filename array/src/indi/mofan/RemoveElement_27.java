package indi.mofan;

/**
 * @author mofan
 * @date 2023/2/7 22:11
 * @link https://leetcode.cn/problems/remove-element/
 */
public class RemoveElement_27 {
    public static void main(String[] args) {
        int[] nums = new int[]{3, 2, 2, 3};
        int val = 3;
        assert 2 == removeElement(nums, val);

        nums = new int[]{0, 1, 2, 2, 3, 0, 4, 2};
        val = 2;
        assert 5 == removeElement(nums, val);
    }

    public static int removeElement(int[] nums, int val) {
        int fast = 0, slow = 0;
        for (; fast < nums.length; fast++) {
            if (nums[fast] != val) {
                nums[slow] = nums[fast];
                slow++;
            }
        }
        return slow;
    }
}
