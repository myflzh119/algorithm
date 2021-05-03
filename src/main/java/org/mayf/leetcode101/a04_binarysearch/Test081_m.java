package org.mayf.leetcode101.a04_binarysearch;

/**
 * @Author mayf
 * @Date 2021/4/26 13:54
 * 已知存在一个按非降序排列的整数数组 nums ，数组中的值不必互不相同。
 * 在传递给函数之前，nums 在预先未知的某个下标 k（0 <= k < nums.length）上进行了 旋转 ，
 * 使数组变为 [nums[k], nums[k+1], ..., nums[n-1], nums[0], nums[1], ..., nums[k-1]]（下标 从 0 开始 计数）。
 * 例如， [0,1,2,4,4,4,5,6,6,7] 在下标 5 处经旋转后可能变为 [4,5,6,6,7,0,1,2,4,4] 。
 * 6,7,0,1,2,4,4,4,5,6
 * 给你 旋转后 的数组 nums 和一个整数 target ，请你编写一个函数来判断给定的目标值是否存在于数组中。
 * 如果 nums 中存在这个目标值 target ，则返回 true ，否则返回 false
 */
public class Test081_m {
    public static void main(String[] args) {
//        int[] nums = {4,5,6,7,0,1,2};
        int[] nums = {4,5,6,7,0,1,2};
        int target = 5;
        System.out.println(search(nums, target));
    }

    /**
     * 1.移动两端坐标，设置循环边界条件l<==r
     * 2.比对中点值的大小
     * 2.1 返回true条件==>三个变量mid、l、r的值与目标值一致
     * 2.2 当左端点的值与mid值一致，移动左端点==>
     * 无法确定是左区间(左到中点全部为被旋转)还是右区间全部相同(中点未被旋转情况)
     */
    public static boolean search(int[] nums, int target) {
        int l = 0, r = nums.length - 1, mid;
        while (l <= r) {
            mid = (l + r) / 2;
            if (nums[mid] == target || target == nums[r] || target == nums[l]) return true;
            if (nums[l] == nums[mid]) ++l;
            else if (nums[mid] <= nums[r]) {    // 右区间增序
                // 超出范围，切换到另一区间
                if (target < nums[mid] || target > nums[r]) r = mid - 1;
                else l = mid + 1;
            } else {    // 左区间增序
                // 超出范围，切换到另一区间
                if (target > nums[mid] || target < nums[l]) l = mid + 1;
                else r = mid - 1;
            }
        }
        return false;
    }
}
