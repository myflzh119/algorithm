package org.mayf.leetcode101.a05_sort;

import java.util.Arrays;

/**
 * @Author mayf
 * @Date 2021/5/2 10:57
 */
public class SelectionSortDemo {

    public static void main(String[] args) {
        int []nums = {9,8,7,6,5,4,3,2,1};
//        nums = new int[]{1,2,15,2,33,6,19,28,4,2,12};
        selectionSort(nums);
        System.out.println(Arrays.toString(nums));
    }

    /**
     * 从i=0开始循环，将最小值放到i的位置
     */
    static void selectionSort(int[]nums){
        int min;
        for (int i = 0; i < nums.length; ++i) {
            min = i;
            for (int j = i; j < nums.length; ++j) {
                if (nums[j]<nums[min])min = j;
            }
            if (i!=min){
                nums[i] = nums[min]^nums[i];
                nums[min] = nums[min]^nums[i];
                nums[i] = nums[min]^nums[i];
            }
        }
    }
}
