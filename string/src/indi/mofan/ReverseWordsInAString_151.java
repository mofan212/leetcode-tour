package indi.mofan;

/**
 * @author mofan
 * @date 2023/3/10 23:10
 * @link https://leetcode.cn/problems/reverse-words-in-a-string/
 */
public class ReverseWordsInAString_151 {
    public static void main(String[] args) {
        ReverseWordsInAString_151 obj = new ReverseWordsInAString_151();
        System.out.println(obj.reverseWords("the sky is blue"));
        System.out.println(obj.reverseWords("  hello world  "));
        System.out.println(obj.reverseWords("a good   example"));
    }

    public String reverseWords(String s) {
        StringBuilder builder = removeSpace(s);
        reverseString(builder, 0, builder.length() - 1);
        reverseWord(builder);
        return builder.toString();
    }

    private StringBuilder removeSpace(String s) {
        int start = 0;
        int end = s.length() - 1;
        while (s.charAt(start) == ' ') start++;
        while (s.charAt(end) == ' ') end--;
        StringBuilder builder = new StringBuilder();
        while (start <= end) {
            char c = s.charAt(start);
            // 当前字符不是空格 或者 build 中的最后一个字符不是空格，这样保证只移除多余的空格
            if (c != ' ' || builder.charAt(builder.length() - 1) != ' ') {
                builder.append(c);
            }
            start++;
        }
        return builder;
    }

    private void reverseString(StringBuilder build, int start, int end) {
        while (start < end) {
            char temp = build.charAt(start);
            build.setCharAt(start, build.charAt(end));
            build.setCharAt(end, temp);
            start++;
            end--;
        }
    }

    private void reverseWord(StringBuilder builder) {
        int start = 0;
        int end = 1;
        int length = builder.length();
        while (start < length) {
            while (end < length && builder.charAt(end) != ' ') {
                end++;
            }
            reverseString(builder, start, end - 1);
            start = ++end;
            end++;
        }
    }
}
