package org.mayf.leetcode101.a02_hunger;

/**
 * @Author mayf
 * @Date 2021/4/11 10:10
 *
 * 老师想给孩子们分发糖果，有 N个孩子站成了一条直线，老师会根据每个孩子的表现，预先给他们评分。
 *
 * 你需要按照以下要求，帮助老师给这些孩子分发糖果：
 *
 * 每个孩子至少分配到 1 个糖果。
 * 评分更高的孩子必须比他两侧的邻位孩子获得更多的糖果。
 * 那么这样下来，老师至少需要准备多少颗糖果呢？
 */
public class Test135 {

    public static void main(String[] args) {
        int[] ratings = {1, 0, 2};
        System.out.println(candy(ratings));
    }

    public static int candy(int[] ratings) {
        /**
         * 两次遍历，从左到右，从右到左，比较判断+1
         */
        if (ratings.length < 2) {
            return 1;
        }
        int max = 0;
        int[] candys = new int[ratings.length];
        candys[0] = 1;
        for (int i = 1; i < ratings.length; i++) {
            if (ratings[i] > ratings[i - 1]) {
                candys[i] = candys[i - 1] + 1;
            } else {
                candys[i] = 1;
            }
        }
        for (int i = ratings.length - 2; i > -1; i--) {
            if (ratings[i] > ratings[i + 1]) {
                if (candys[i] <= candys[i + 1]) {
                    candys[i] = candys[i + 1] + 1;
                }
            }
        }
        for (int i = 0; i < candys.length; i++) {
            max += candys[i];
        }
        return max;
    }
}
