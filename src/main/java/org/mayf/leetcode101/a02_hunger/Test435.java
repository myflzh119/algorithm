package org.mayf.leetcode101.a02_hunger;

import java.util.Arrays;
import java.util.Comparator;

/**
 * @Author mayf
 * @Date 2021/4/11 11:04
 *
 *
 * 给定一个区间的集合，找到需要移除区间的最小数量，使剩余区间互不重叠
 */
public class Test435 {
    public static void main(String[] args) {
        int[][] intervals = {{1, 2}, {2, 3},{3,4},{1,3}};
        System.out.println(eraseOverlapIntervals(intervals));
    }

    public static int eraseOverlapIntervals(int[][] intervals) {
        /**
         * 先按照区间结尾>区间起始的权重对二维数组进行排序
         * 一次循环
         *  当current[0]<prev[1]时候，移除current
         *  否则将prev设置为current
         */
        Arrays.sort(intervals, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                if (o1[1]>o2[1]) {
                    return 1;
                }else if(o1[1]==o2[1]){
                    if(o1[0]>o2[0]){
                        return 1;
                    }else{
                        return -1;
                    }
                }
                return -1;
            }
        });

        int removeNum = 0;

        int prevEnd = intervals[0][1];

        for (int i = 1; i < intervals.length; i++) {
            if(intervals[i][0]<prevEnd){
                removeNum++;
            }else{
                prevEnd = intervals[i][1];
            }
        }

        return removeNum;
    }
}
