package indi.mofan;

/**
 * @author mofan
 * @date 2023/3/13 23:05
 * @link https://leetcode.cn/problems/zuo-xuan-zhuan-zi-fu-chuan-lcof/
 */
public class Offer_58 {
    public String reverseLeftWords(String s, int n) {
        if (n == 0 || s.length() == 1) {
            return s;
        }
        char[] chars = s.toCharArray();
        // 先翻转前 n 个
        reverseString(chars, 0, n - 1);
        // 再翻转 n 个后面的
        int size = chars.length - 1;
        reverseString(chars, n, size);
        // 再将所有的翻转
        reverseString(chars, 0, size);
        return new String(chars);
    }

    private void reverseString(char[] chars, int start, int end) {
        int left = start;
        int right = end;
        while (left < right) {
            char temp = chars[left];
            chars[left] = chars[right];
            chars[right] = temp;
            left++;
            right--;
        }
    }
}
