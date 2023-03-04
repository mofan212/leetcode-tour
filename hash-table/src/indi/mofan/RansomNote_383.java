package indi.mofan;

import java.util.HashMap;
import java.util.Map;

/**
 * @author mofan
 * @date 2023/3/4 13:13
 */
public class RansomNote_383 {
    public static boolean canConstruct(String ransomNote, String magazine) {
        Map<Character, Integer> map = new HashMap<>();
        for (char c : magazine.toCharArray()) {
            Integer count = map.get(c);
            map.put(c, count != null ? count + 1 : 1);
        }
        for (char c : ransomNote.toCharArray()) {
            Integer count = map.get(c);
            if (count == null || count == 0) {
                return false;
            }
            map.put(c, count - 1);
        }
        return true;
    }

    public static boolean canConstructWithArray(String ransomNote, String magazine) {
        int[] array = new int[26];
        for (char c : magazine.toCharArray()) {
            array[c - 'a']++;
        }
        for (char c : ransomNote.toCharArray()) {
            int index = c - 'a';
            int count = array[index];
            if (count == 0) {
                return false;
            }
            array[index]--;
        }
        return true;
    }
}
