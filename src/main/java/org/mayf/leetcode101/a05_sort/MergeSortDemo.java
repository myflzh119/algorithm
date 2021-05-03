package org.mayf.leetcode101.a05_sort;

import java.util.Arrays;

/**
 * @Author mayf
 * @Date 2021/4/28 16:57
 * 归并排序
 */
public class MergeSortDemo {
    public static void main(String[] args) {
        int []nums = {9,8,7,6,5,4,3,2,1};
        mergeSort(nums,0, nums.length-1, new int[nums.length]);
        System.out.println(Arrays.toString(nums));
    }

    public static int[] mergeSort(int[]nums,int l,int r,int[]temp){
        // 设立边界
        if (l+1>r)return nums;
        // 拆分
        int mid = (l+r)/2;
        nums = mergeSort(nums,l,mid,temp);
        nums = mergeSort(nums,mid+1,r,temp);
        // 合并,使用临时数组表示左半边数组进行比较赋值
        int temp_l=l;   // 左序指针
        int temp_r=mid+1; // 右序指针
        int t=l;
        while(temp_l<=mid||temp_r<=r){
            if (temp_r>r||(temp_l<mid&&nums[temp_l]<nums[temp_r])){
                temp[t++] = nums[temp_l++];
            }else{
                temp[t++] = nums[temp_r++];
            }
        }
        for (int i = l; i <= r; i++) {
            nums[i] = temp[i];
        }
        return nums;
    }
}
