package org.mayf.leetcode101.a02_hunger;

import java.util.Arrays;

/**
 * @Author mayf
 * @Date 2021/4/11 09:53
 *
 * 对每个孩子 i，都有一个胃口值g[i]，这是能让孩子们满足胃口的饼干的最小尺寸；
 * 并且每块饼干 j，都有一个尺寸 s[j]。如果 s[j]>= g[i]，
 * 我们可以将这个饼干 j 分配给孩子 i ，这个孩子会得到满足。
 * 你的目标是尽可能满足越多数量的孩子，并输出这个最大数值
 */
public class Test455 {
    public static void main(String[] args) {
        int[]g = {1,2,3};
        int[]s = {1,1,2,15};

        int max = findContentChildren(g,s);
        System.out.println(max);
    }

    public static int findContentChildren(int[] g, int[] s) {
        /**
         * 将两个数组进行从小到大排序
         * 从数组g最小的值向上找，一直找到s数组的边界||g的边界
         */
        Arrays.sort(g);
        Arrays.sort(s);

        int childIndex = 0 , cookIndex = 0;

        while(childIndex<g.length&&cookIndex<s.length){
            if(g[childIndex]<=s[cookIndex]){
                childIndex++;
            }
            cookIndex++;
        }

        return childIndex;
    }
}
