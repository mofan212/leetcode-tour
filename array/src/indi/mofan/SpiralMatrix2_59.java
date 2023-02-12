package indi.mofan;

import java.util.Arrays;

/**
 * @author mofan
 * @date 2023/2/12 21:53
 * @link https://leetcode.cn/problems/spiral-matrix-ii/
 */
public class SpiralMatrix2_59 {
    public static void main(String[] args) {
        // [[1,2,3],[8,9,4],[7,6,5]]
        System.out.println(Arrays.deepToString(generateMatrix(3)));
        // [[1]]
        System.out.println(Arrays.deepToString(generateMatrix(1)));
    }

    public static int[][] generateMatrix(int n) {
        // 起始横坐标
        int startX = 0;
        // 起始纵坐标
        int startY = 0;
        // 终止位置偏移量
        int offset = 1;
        // 单纯的计数
        int value = 1;

        int[][] nums = new int[n][n];
        int half = n / 2;
        // n 为偶数时，螺旋圈数恰好为 n / 2
        for (int k = 0; k < half; k++) {
            int i = startX, j = startY;
            // 横向向左
            for (; j < n - offset; j++) {
                nums[startX][j] = value++;
            }
            // 纵向向下
            for (; i < n - offset; i++) {
                nums[i][j] = value++;
            }
            // 横向向右
            for (; j > startY; j--) {
                nums[i][j] = value++;
            }
            // 纵向向上
            for (; i > startX; i--) {
                nums[i][j] = value++;
            }

            startX++;
            startY++;
            offset++;
        }

        // n 为奇数时，最填充最中间位置
        if (n % 2 == 1) {
            nums[half][half] = n * n;
        }
        return nums;
    }
}
