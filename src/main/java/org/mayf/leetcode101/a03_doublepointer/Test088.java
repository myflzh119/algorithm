package org.mayf.leetcode101.a03_doublepointer;

import java.util.Arrays;

/**
 * @Author mayf
 * @Date 2021/4/13 02:39
 *
 * 给你两个有序整数数组nums1 和 nums2，请你将 nums2 合并到nums1中，使 nums1 成为一个有序数组。
 * 初始化nums1 和 nums2 的元素数量分别为m 和 n 。
 * 你可以假设nums1 的空间大小等于m + n，这样它就有足够的空间保存来自 nums2 的元素。
 */
public class Test088 {

    public static void main(String[] args) {
        int[]nums1 = {1,9,0,0,0};
        int[]nums2 = {2,5,6};
        int m = 2;
        int n = 3;
        merge(nums1,m,nums2,n);
        System.out.println(Arrays.toString(nums1));
    }

    // debug!!!有问题!!!
    public static void merge(int[] nums1, int m, int[] nums2, int n) {
        if (n != 0) {
            m--;n--;
            for (int i = nums1.length-1; i >-1; i--) {
                if(n<0){
                    break;
                }
                if(m<0){
                    nums1[i]=nums2[n--];
                }else{
                    if(nums1[m]>nums2[n]){
                        nums1[i]=nums1[m--];
                    }else{
                        nums1[i]=nums2[n--];
                    }
                }
            }
//            int max = nums1.length-1;
//            m--;n--;
//            while(true){
//                if(m<0&&n<0){
//                    break;
//                }
//                if(m<0){
//                    nums1[max]=nums2[n--];
//                }else if(n<0){
//                    break;
//                }else{
//                    if(nums1[m]>nums2[n]){
//                        nums1[max]=nums1[m--];
//                    }else{
//                        nums1[max]=nums2[n--];
//                    }
//                }
//                if(max--<=0){
//                    break;
//                }
//            }
        }
    }
}
