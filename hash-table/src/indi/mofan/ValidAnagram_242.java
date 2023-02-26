package indi.mofan;

/**
 * @author mofan
 * @date 2023/2/26 21:16
 */
public class ValidAnagram_242 {
    public static void main(String[] args) {
        // 若 s 和 t 中每个字符出现的次数都相同，则称 s 和 t 互为字母异位词
        // s = "anagram", t = "nagaram" --> true
        assert isAnagram("anagram", "nagaram");
        // s = "rat", t = "car" --> false
        assert !isAnagram("rat", "car");
    }

    static boolean isAnagram(String s, String t) {
        // s 和 t 中只包含小写字母
        int[] hash = new int[26];
        for (int i = 0; i < s.length(); i++) {
            hash[s.charAt(i) - 'a']++;
        }
        for (int i = 0; i < t.length(); i++) {
            hash[t.charAt(i) - 'a']--;
        }
        for (int i : hash) {
            if (i != 0) return false;
        }
        return true;
    }
}
