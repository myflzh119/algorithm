package org.mayf.leetcode101;

/**
 * @Author mayf
 * @Date 2021/4/20 10:36
 * <p>
 * 实现strStr()函数。
 * 给你两个字符串haystack 和 needle
 * 请你在 haystack 字符串中找出 needle 字符串出现的第一个位置（下标从 0 开始）。
 * 如果不存在，则返回 -1 。
 * <p>
 * ps:KMP算法
 * 引入next数组==>匹配字符串的子串前缀与后缀交易的最大值
 * 当遇到不匹配的值时，使用最大前缀代替后缀
 * 如何求：
 */
public class b028 {

    public static void main(String[] args) {

        String s = "abbabaaaabbbaabaabaabbbaaabaaaaaabbbabbaabbabaabbabaaaaababbabbaaaaabbbbaaabbaaabbbbabbbbaaabbaaaaababbaababbabaaabaabbbbbbbaabaabaabbbbababbbababbaaababbbabaabbaaabbbba";
        String t = "bbbbbbaa";
        System.out.println(strStr(s, t));
    }

    /**
     * 使用前缀表
     */
    public static int strStr(String haystack, String needle) {
        if (needle.isEmpty()||haystack.equals(needle)) return 0;
        char[] charH = haystack.toCharArray();
        char[] charN = needle.toCharArray();
        int[] next = new int[charN.length];
        /**
         * 构建next数组
         */
        for (int i = 1, j = 0; i < charN.length; i++) {
            while (j > 0 && charN[i] != charN[j]) j = next[j-1];
            if (charN[i] == charN[j]) j++;
            next[i] = j;
        }

        for (int i = 0, j = 0; i < charH.length; i++) {
            while (j>0&&charH[i]!=charN[j])j=next[j-1];
            if (charH[i]==charN[j])j++;
            if (j==charN.length)return i- charN.length+1;
        }
        return -1;
    }

    /**
     * 暴力匹配
     */
    public static int forceStr(String ss, String pp) {
        int n = ss.length(), m = pp.length();
        char[] s = ss.toCharArray(), p = pp.toCharArray();
        // 枚举原串的「发起点」
        for (int i = 0; i <= n - m; i++) {
            // 从原串的「发起点」和匹配串的「首位」开始，尝试匹配
            int a = i, b = 0;
            while (b < m && s[a] == p[b]) {
                a++;
                b++;
            }
            // 如果能够完全匹配，返回原串的「发起点」下标
            if (b == m) return i;
        }
        return -1;
    }
}
