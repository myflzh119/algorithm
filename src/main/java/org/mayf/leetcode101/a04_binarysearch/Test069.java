package org.mayf.leetcode101.a04_binarysearch;

/**
 * @Author mayf
 * @Date 2021/4/22 16:56
 * 实现int sqrt(int x)函数。
 * 计算并返回x的平方根，其中x 是非负整数。
 * 由于返回类型是整数，结果只保留整数的部分，小数部分将被舍去。
 */
public class Test069 {

    public static void main(String[] args) {
//        System.out.println((int)Math.sqrt(156));
        System.out.println(mySqrt(156));
    }

    static int sqrt(int x){
        int sqrt = x;
        while(sqrt!=0){

        }
        return 0;
    }
    /**
     * f(x+1) = x^2 + (2x+1)
     * @param x
     */
    static int mySqrt(int x) {
        if (x==0)return 0;
        int r = x,l=1,mid,temp;
        while(l<=r){
            mid = (l+r)/2;
            temp = x/mid;
            if (temp==mid)return temp;
            else if (temp>mid)l=mid+1;
            else r=mid-1;
        }
        return r;
    }

    static int mySqrt2(int x){
        long a = x;
        while (a * a > x) {
            a = (a + x / a) / 2;
        }
        return (int) a;
    }
}
