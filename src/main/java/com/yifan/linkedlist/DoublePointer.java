package com.yifan.linkedlist;

public class DoublePointer {

    /**
     * 判断链表是否有环
     *
     * @param head the head
     * @return the boolean
     * @author wuyifan
     * @since 2021年12月28日 14:58
     */
    public boolean hasCycle(ListNode head) {
        ListNode fast, slow;
        fast = slow = head;

        while (fast != null && fast.next != null) {
            fast = fast.next.next;
            slow = slow.next;

            if (fast == slow) {
                return true;
            }
        }

        return false;
    }

    /**
     * 找到链表环的入口
     * @param head the head
     * @return the list node
     * @author wuyifan
     * @since 2021年12月28日 15:01
     */
    public ListNode detectCycle(ListNode head) {
        ListNode fast, slow;
        fast = slow = head;

        while (fast != null && fast.next != null) {
            fast = fast.next.next;
            slow = slow.next;

            if (fast == slow) {
                break;
            }
        }

        if (fast == null || fast.next == null) {
            return null;
        }

        slow = head;
        while (slow != fast) {
            fast = fast.next;
            slow = slow.next;
        }

        return slow;
    }

    public ListNode middleNode(ListNode head) {
        ListNode fast, slow;
        fast = slow = head;

        while (fast != null && fast.next != null) {
            fast = fast.next.next;
            slow = slow.next;
        }

        return slow;
    }
}
