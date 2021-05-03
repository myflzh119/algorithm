package org.mayf.leetcode101.a04_binarysearch;

import java.util.Arrays;

/**
 * @Author mayf
 * @Date 2021/4/25 09:20
 * 给定一个按照升序排列的整数数组 nums，和一个目标值 target。找出给定目标值在数组中的开始位置和结束位置。
 * 如果数组中不存在目标值 target，返回[-1, -1]。
 * 进阶：你可以设计并实现时间复杂度为O(log n)的算法解决此问题吗？
 */
public class Test034_m {
    public static void main(String[] args) {
        System.out.println(Arrays.toString(searchRange(new int[]{5, 7, 7, 8, 8, 10}, 8)));
    }

    public static int[] searchRange(int[] nums, int target) {
        int [] index = new int[]{-1, -1};
        if (nums == null || nums.length == 0) return index;
        /**
         * 计算符合目标数字的左坐标
         */
        int l = 0,r=nums.length,mid;
        while(l<r){
            mid = (l+r)/2;
            if (nums[mid]>=target) r = mid;
            else l = mid+1;
        }
        if (l==nums.length||nums[l]!=target)return index;
        int index_l = l;
        /**
         * 计算符合目标的右坐标
         */
        l = 0;r=nums.length;
        while(l<r){
            mid = (l+r)/2;
            if (nums[mid]>target) r = mid;
            else l = mid+1;
        }
        int index_r = l;
        index[0] = index_l;
        index[1] = index_r-1;
        return index;
    }

}
