package org.mayf.base01;

import java.util.*;

/**
 * @Author mayf
 * @Date 2021/3/17 16:35
 * 1.1.10
 * 二分查找
 */
public class BinarySearch {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("请输入数字，输入-1结束:\n");
        List<Integer>list = new ArrayList<>();
        int i = -1;
        while((i = scanner.nextInt())!=-1){
            list.add(i);
        }
        Collections.sort(list);
        System.out.println(Arrays.toString(list.toArray()));
    }

    /**
     * 集合必须是有序的
     * @param key
     * @param intList
     * @return
     */
    public static int rank(int key, List<Integer> intList){
        int lowIndex = 0;
        int highIndex = intList.size()-1;
        int mid = -1;
        while (lowIndex<highIndex){
            mid = lowIndex+(highIndex-lowIndex)/2;
            if (key<intList.get(mid)){
                // 在范围左边，减少左边范围
                highIndex=mid-1;
            }else if (key>intList.get(mid)){
                lowIndex=mid+1;
            }else return mid;
        }
        return -1;
    }
}
