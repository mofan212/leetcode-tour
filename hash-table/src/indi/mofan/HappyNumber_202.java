package indi.mofan;

import java.util.HashSet;
import java.util.Set;

/**
 * @author mofan
 * @date 2023/2/28 19:58
 * @link https://leetcode.cn/problems/happy-number/
 */
public class HappyNumber_202 {
    public boolean isHappy(int n) {
        Set<Integer> set = new HashSet<>();
        while (n != 1 && !set.contains(n)) {
            set.add(n);
            n = nextNum(n);
        }
        return n == 1;
    }

    public int nextNum(int n) {
        int num = 0;
        while (n != 0) {
            int temp = n % 10;
            num += temp * temp;
            n = n / 10;
        }
        return num;
    }
}
