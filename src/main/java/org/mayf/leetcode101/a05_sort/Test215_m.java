package org.mayf.leetcode101.a05_sort;

/**
 * @Author mayf
 * @Date 2021/5/3 19:31
 * 在未排序的数组中找到第 k 个最大的元素。
 * 请注意，你需要找的是数组排序后的第 k 个最大的元素，而不是第 k 个不同的元素
 */
public class Test215_m {

    public static void main(String[] args) {
        int []nums = {3,2,1,5,6,4};
        nums = new int[]{-1,2,0};
        int k = 2;
        System.out.println(findKthLargest(nums, k));
    }

    /**
     * 使用快速排序
     * 由于快速排序每次都可以确定某个范围内的中点的值，只要mid下标值与length-k一致就可以确认该点值
     * 如果不一致，mid可以根据与length-k值的比值大小重新被设置为边界
     */
    public static int findKthLargest(int[] nums, int k) {
        int l = 0, r = nums.length - 1, target = nums.length - k;
        while (l <= r) {
            int mid = quickSort(nums, l, r);
            if (mid == target)return nums[mid];
            if (mid<target)l=mid+1;
            if (mid>target)r=mid-1;
        }
        return nums[0];
    }

    static int quickSort(int[] nums, int l, int r) {
        int i = l, j = r, k = nums[i];
        while (i < j) {
            while (i < j && nums[j] >= k) --j;
            nums[i] = nums[j];
            while (i < j && nums[i] < k) ++i;
            nums[j] = nums[i];
        }
        nums[i] = k;
        return i;
    }
}
