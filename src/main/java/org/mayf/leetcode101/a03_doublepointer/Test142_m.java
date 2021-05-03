package org.mayf.leetcode101.a03_doublepointer;

import java.util.ArrayList;
import java.util.List;

/**
 * @Author mayf
 * @Date 2021/4/16 01:00
 *
 * 快慢指针
 *
 * 给定一个链表，如果有环路，找出环路的开始点
 * 输入是一个链表，输出是链表的一个节点。如果没有环路，返回一个空指针
 *
 * m+An+k
 * m+Bn+k
 * (A-B)n==>证明为n的倍数
 */
public class Test142_m {

    public static void main(String[] args) {
        List<ListNode> list = new ArrayList();
        for (int i = 0; i < 10; i++) {
            ListNode node = new ListNode(i);
            if (i>0){
                list.get(i-1).next = node;
            }
            list.add(node);
        }
        list.get(9).next=list.get(9);
        System.out.println(detectCycle(list.get(0)).val);
    }

    public static ListNode detectCyclePublic(ListNode head){
        if (head == null) {
            return null;
        }
        ListNode slow = head, fast = head;
        while (fast != null) {
            slow = slow.next;
            if (fast.next != null) {
                fast = fast.next.next;
            } else {
                return null;
            }
            if (fast == slow) {
                ListNode ptr = head;
                while (ptr != slow) {
                    ptr = ptr.next;
                    slow = slow.next;
                }
                return ptr;
            }
        }
        return null;
    }

    public static ListNode detectCycle(ListNode head) {
        ListNode slow = head ,quick = head;
        do{
            if(quick==null||quick.next==null)return null;
            quick=quick.next.next;
            slow=slow.next;
        }while (slow.val!=quick.val);
        quick=head;
        while (quick.val!=slow.val){
            quick=quick.next;
            slow=slow.next;
        }
        return quick;
    }

    static class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
            next = null;
        }
    }
}
