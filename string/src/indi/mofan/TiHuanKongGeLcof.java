package indi.mofan;

/**
 * @author mofan
 * @date 2023/3/9 21:06
 * @link https://leetcode.cn/problems/ti-huan-kong-ge-lcof/
 */
public class TiHuanKongGeLcof {
    public String replaceSpace(String s) {
        if (s == null || s.length() == 0) {
            return s;
        }
        StringBuilder builder = new StringBuilder();
        for (char c : s.toCharArray()) {
            if (c == ' ') {
                builder.append("  ");
            }
        }
        if (builder.length() == 0) {
            return s;
        }

        int left = s.length() - 1;
        s += builder.toString();
        int right  = s.length() - 1;

        char[] chars = s.toCharArray();
        while (left >= 0) {
            if (chars[left] == ' ') {
                chars[right--] = '0';
                chars[right--] = '2';
                chars[right] = '%';
            } else {
                chars[right] = chars[left];
            }
            left--;
            right--;
        }
        return new String(chars);
    }
}
