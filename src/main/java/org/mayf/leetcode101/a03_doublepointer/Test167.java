package org.mayf.leetcode101.a03_doublepointer;

/**
 * @Author mayf
 * @Date 2021/4/13 02:15
 *
 * 给定一个已按照 升序排列 的整数数组numbers ，请你从数组中找出两个数满足相加之和等于目标数target 。
 *
 * 函数应该以长度为 2 的整数数组的形式返回这两个数的下标值。
 * numbers 的下标 从 1 开始计数 ，所以答案数组应当满足 1 <= answer[0] < answer[1] <= numbers.length 。
 *
 * 你可以假设每个输入只对应唯一的答案，而且你不可以重复使用相同的元素。
 */
public class Test167 {
    public static void main(String[] args) {

    }


    public static int[] twoSum(int[] numbers, int target) {

        int l = 0;
        int r = numbers.length - 1;
        int temp;
        while (true) {
            temp = numbers[l] + numbers[r];
            if (temp == target) {
                l++;
                r++;
                break;
            } else if (temp > target) {
                r--;
            } else {
                l++;
            }
        }

        return new int[]{l,r};
    }
}
