package com.yifan.linkedlist;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class LinkedList {

    public static void main(String[] args) {

        Logger log = LoggerFactory.getLogger(LinkedList.class);
        //    java
        // java.lang.IllegalArgumentException: Self-suppression not permitted
        //ex.addSuppressed(ex);
        //
        Exception ex = new Exception("Test exception");
        Exception ex1 = new Exception("Test exception1");
        ex.addSuppressed(ex1);
        ex1.addSuppressed(ex);
        log.error("Exception", ex);
    }

    public ListNode mergeTwoList(ListNode l1, ListNode l2) {
        ListNode dummy = new ListNode(-1);
        ListNode p = dummy;

        ListNode p1 = l1, p2 = l2;

        while (p1 != null && p2 != null) {
            if (p1.val > p2.val) {
                p.next = p2;
                p2 = p2.next;
            } else {
                p.next = p1;
                p1 = p1.next;
            }

            p = p.next;
        }

        if (p1 != null) {
            p.next = p1;
        }

        if (p2 != null) {
            p.next = p2;
        }

        return dummy.next;
    }

}
