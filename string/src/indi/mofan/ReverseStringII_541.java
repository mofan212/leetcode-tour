package indi.mofan;

/**
 * @author mofan
 * @date 2023/3/8 20:47
 * @link https://leetcode.cn/problems/reverse-string-ii/
 */
public class ReverseStringII_541 {
    public String reverseStr(String s, int k) {
        char[] chars = s.toCharArray();
        int size = chars.length - 1;
        for (int i = 0; i <= size; i += 2 * k) {
            int start = i;
            int end = Math.min(size, start + k - 1);
            while (start < end) {
                char temp = chars[start];
                chars[start] = chars[end];
                chars[end] = temp;

                start++;
                end--;
            }
        }
        return new String(chars);
    }
}
