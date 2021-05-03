package org.mayf.leetcode101.a05_sort;

import java.util.Arrays;

/**
 * @Author mayf
 * @Date 2021/4/28 15:48
 * 快速排序
 */
public class QuickSortDemo {
    public static void main(String[] args) {
        int[] nums = new int[]{1,2,15,2,33,6,19,28,4,2,12};
        System.out.println(Arrays.toString(quickSort(nums, 0, nums.length)));
    }

    /**
     * 1. 在数组中选一个基准数（通常为数组第一个）；
     * 2. 将数组中小于基准数的数据移到基准数左边，大于基准数的移到右边；
     * 3. 对于基准数左、右两边的数组，不断重复以上两个过程，直到每个子集只有一个元素，即为全部有序
     * O(nlogn)
     */
    static int[] quickSort(int[]nums,int l,int r){
        if (l+1>r)return nums;
        int first = l,last = r - 1,key = nums[first];
        while (first<last){
            // 以first为基准，移动last坐标，比较与key的值，如果找到第一个last下标值小于key，将last值移动到first坐标处
            while (first<last&&nums[last]>=key)--last;
            nums[first] = nums[last];
            // 以last为基准，移动first坐标，比较与key的值，如果找到第一个first下标值小于key，将first值移动到last坐标处
            while (first<last&&nums[first]<key)++first;
            nums[last] = nums[first];--last;
        }
        // 将key设置在最终的first下标位置
        nums[first] = key;
        // 以key目前所在的坐标为轴，分出两个区间继续快速排序流程
        nums= quickSort(nums,l,first);
        nums = quickSort(nums,first+1,r);

        return nums;
    }
}
