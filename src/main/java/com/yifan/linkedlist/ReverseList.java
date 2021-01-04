package com.yifan.linkedlist;

/**
 * <a>https://leetcode-cn.com/problems/fan-zhuan-lian-biao-lcof/</a>
 * The type Reverse list.
 */
public class ReverseList {

    /**
     * 迭代反转链表
     *
     * @param head the head
     * @return the list node
     */
    public ListNode reverseList(ListNode head) {
        ListNode pre = null;
        ListNode cur = head;
        ListNode next = null;

        while (cur != null) {
            next = head.next;
            cur.next = pre;
            pre = cur;
            cur = next;
        }

        return pre;
    }

    /**
     * 递归反转链表
     *
     * @param head the head
     * @return the list node
     */
    public ListNode reverse(ListNode head) {
        if (head.next == null) {
            return head;
        }

        ListNode last = reverse(head.next);
        head.next.next = head;
        head.next = null;
        return last;
    }

    /**
     * The Successor.
     */
    ListNode successor = null;

    /**
     * 反转链表的前n个节点
     *
     * @param head the head
     * @param n    the n
     * @return the list node
     */
    public ListNode reverseN(ListNode head, int n) {
        if (n == 1) {
            // 记录第 n + 1 个节点
            successor = head.next;
            return head;
        }
        // 以 head.next 为起点，需要反转前 n - 1 个节点
        ListNode last = reverseN(head.next, n - 1);
        head.next.next = head;
        // 让反转之后的 head 节点和后面的节点连起来
        head.next = successor;

        return last;
    }

    /**
     * 反转链表的一部分
     *
     * @param head the head
     * @param m    the m
     * @param n    the n
     * @return the list node
     */
    public ListNode reverseBetween(ListNode head, int m, int n) {
        if (m == 1) {
            return reverseN(head, n);
        }

        head.next = reverseBetween(head.next, m - 1, n - 1);
        return head;
    }

    public ListNode reverse(ListNode a, ListNode b) {
        ListNode pre = null;
        ListNode cur = a;
        ListNode next;
        while (cur != b) {
            next = cur.next;
            cur.next = pre;
            pre = cur;
            cur = next;
        }

        return pre;
    }

    public ListNode reverseKGroup(ListNode head, int k) {
        if (head == null) {
            return null;
        }

        ListNode a;
        ListNode b;
        a = b = head;

        for (int i = 0; i < k; i++) {
            if (b == null) {
                return head;
            }

            b = b.next;
        }

        ListNode newHead = reverse(a, b);
        a.next = reverseKGroup(b, k);

        return newHead;
    }
}
