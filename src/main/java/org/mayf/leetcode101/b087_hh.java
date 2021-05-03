package org.mayf.leetcode101;

/**
 * @Author mayf
 * @Date 2021/4/16 14:22
 *
 * 使用下面描述的算法可以扰乱字符串 s 得到字符串 t ：
 * 如果字符串的长度为 1 ，算法停止
 * 如果字符串的长度 > 1 ，执行下述步骤：
 * 在一个随机下标处将字符串分割成两个非空的子字符串。即，如果已知字符串 s ，则可以将其分成两个子字符串 x 和 y ，且满足 s = x + y 。
 * 随机 决定是要「交换两个子字符串」还是要「保持这两个子字符串的顺序不变」。即，在执行这一步骤之后，s 可能是 s = x + y 或者 s = y + x 。
 * 在 x 和 y 这两个子字符串上继续从步骤 1 开始递归执行此算法。
 * 给你两个 长度相等 的字符串 s1 和s2，判断s2是否是s1的扰乱字符串。如果是，返回 true ；否则，返回 false 。
 *
 *
 */
public class b087_hh {

    public static void main(String[] args) {
        String s1 = "great";
        String s2 = "rgeat";
        System.out.println(isScramble(s1, s2));
    }

    public static boolean isScramble(String s1, String s2) {
        if (s1==null||s2==null)return false;
        if (s1.length()!=s2.length())return false;
        if (s1.length()==1)return s1==s2;
        if (s1.equals(s2))return true;



        return false;
    }

    private static boolean checkHarmony(int i1,int i2,int length){

        return false;
    }

}
