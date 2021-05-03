package org.mayf.leetcode101.a05_sort;

import java.util.Arrays;

/**
 * @Author mayf
 * @Date 2021/5/2 10:58
 */
public class InsertSortDemo {
    public static void main(String[] args) {
        int []nums = {9,8,7,6,5,4,3,2,1};
        nums = new int[]{1,2,15,2,33,6,19,28,4,2,12};
        insertSort(nums);
        System.out.println(Arrays.toString(nums));
    }


    /**
     * 将最小值插入到数组最前位置
     */
    static void insertSort(int[]nums){
        for (int i = 0; i < nums.length; i++) {
            for (int j = i; j>0&&nums[j]<nums[j-1];--j) {
                nums[j] = nums[j]^nums[j-1];
                nums[j-1] = nums[j]^nums[j-1];
                nums[j] = nums[j]^nums[j-1];
            }
        }
    }
}
