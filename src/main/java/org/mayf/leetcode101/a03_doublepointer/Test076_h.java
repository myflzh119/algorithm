package org.mayf.leetcode101.a03_doublepointer;

import java.util.HashMap;

/**
 * @Author mayf
 * @Date 2021/4/19 07:14
 * 
 * 给你一个字符串 s 、一个字符串 t 。返回 s 中涵盖 t 所有字符的最小子串。如果 s 中不存在涵盖 t 所有字符的子串，则返回空字符串 "" 。
 * 注意：如果 s 中存在这样的子串，我们保证它是唯一的答案。
 * 
 * 双指针，滑动窗口
 */
public class Test076_h {
    public static void main(String[] args) {
        String s = "abbdecdd";
        String t = "bcd";
//        System.out.println(s.substring(9, 13));
        System.out.println(minWindow(s, t));
    }

    public static String minWindow(String s, String t) {
        HashMap<Character, Integer> needChars = new HashMap();
        /**
         * 存储所有需要查找的字符及字符的个数
         */
        for (int i = 0; i < t.length(); i++) {
            needChars.put(t.charAt(i), needChars.getOrDefault(t.charAt(i), 0) + 1);
        }

        int count = 0, minLeft = 0, minSize = s.length() + 1, tempLeft = 0;
        for (int right = 0; right < s.length(); right++) {
            /**
             * 若存在字符且剩余字符数大于0，对找到字符数+1
             * 当count等于t的长度时，代表已经找到完整的包含t字符的窗口
             */
            if (needChars.containsKey(s.charAt(right))) {
                needChars.put(s.charAt(right), needChars.get(s.charAt(right)) - 1);
                if (needChars.get(s.charAt(right)) >= 0) {
                    ++count;
                }
                /**
                 * 尝试进行滑动,缩小范围进行获取尝试
                 */
                while (count == t.length()) {
                    if (right - tempLeft + 1 < minSize) {
                        /**
                         * 新的字符长度小于前一次的最小长度
                         */
                        minLeft = tempLeft;
                        minSize = right - tempLeft + 1;
                    }
                    /**
                     * 逐次移动左游标
                     * 当移动到"存在字符哈希表"中字符数为1时，跳出循环，继续移动右游标
                     */
                    if (needChars.containsKey(s.charAt(tempLeft))) {
                        needChars.put(s.charAt(tempLeft), needChars.get(s.charAt(tempLeft)) + 1);
                        if (needChars.get(s.charAt(tempLeft)) > 0) {
                            --count;
                        }
                    }
                    ++tempLeft;
                }
            }
        }
        /**
         * s字符串内不存在所有t的字符的子串
         */
        if (minSize>s.length())minSize=0;
        return minSize > 0 ? s.substring(minLeft, minLeft+minSize) : "";
    }
}
