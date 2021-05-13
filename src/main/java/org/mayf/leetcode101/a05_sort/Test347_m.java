package org.mayf.leetcode101.a05_sort;

import java.util.*;

/**
 * @Author mayf
 * @Date 2021/5/4 11:55
 * 给你一个整数数组nums和一个整数k。
 * 请你返回其中出现频率前k高的元素。你可以按任意顺序返回答案
 */
public class Test347_m {

    public static void main(String[] args) {
        int[] nums = new int[]{1, 1, 1, 2, 2, 3};
        int k = 2;
//        nums = new int[]{1};
//        k = 1;
        int[] ints = topKFrequent(nums, k);
        System.out.println(Arrays.toString(ints));
    }

    public static int[] topKFrequent(int[] nums, int k) {
        HashMap<Integer,Integer>numsMap =  new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            numsMap.put(nums[i],numsMap.getOrDefault(nums[i],0)+1);
        }
        HashMap<Integer, Stack<Integer>> map = new HashMap();
        for (Integer integer : numsMap.keySet()) {
            Integer val = numsMap.get(integer);
            Stack stack = map.getOrDefault(val, new Stack());
            stack.push(integer);
            map.put(val,stack);
        }
        Set<Integer> keys = map.keySet();
        Integer[]counts = new Integer[keys.size()];
        keys.toArray(counts);
        // 对counts进行快速排序
        quickSort(counts,0, counts.length);
        int temp;
        int [] results = new int[k];
        int res_i = 0;
        for (int i = counts.length-1; i>-1&&k>0; i--) {
            temp = counts[i];
            Stack<Integer> stack = map.get(temp);
            Integer val;
            while (!stack.isEmpty()&&k>0){
                results[--k] = stack.pop();
            }
        }
        return results;
    }

    static Integer[] quickSort(Integer[]nums,int l,int r){
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
