package org.mayf.leetcode101.a05_sort;

import java.util.Arrays;

/**
 * @Author mayf
 * @Date 2021/5/2 10:35
 * 冒泡排序
 */
public class BubbleSortDemo {

    public static void main(String[] args) {
        int []nums = {9,8,7,6,5,4,3,2,1};
        nums = new int[]{1,2,15,2,33,6,19,28,4,2,12};
        bubbleSort(nums);
        System.out.println(Arrays.toString(nums));
    }

    /**
     * 每次从下标0位置开始
     * 循环至length-i处，将最大值放置到length-i处
     * 如果某次循环时没有发生任何数值交换，证明在i——>length-i这个区间内所有数字都是有序的
     * @param nums
     */
    static void bubbleSort(int[]nums){
        boolean hasSwitch = false;
        for (int i = 0; i < nums.length; i++) {
            hasSwitch = false;
            for (int j = 1; j <nums.length-i; j++) {
                if (nums[j]<nums[j-1]){
                    nums[j] = nums[j]^nums[j-1];
                    nums[j-1] = nums[j]^nums[j-1];
                    nums[j] = nums[j]^nums[j-1];
                    hasSwitch = true;
                }
            }
            if (!hasSwitch)break;
        }
    }
}
