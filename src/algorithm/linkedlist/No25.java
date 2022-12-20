package src.algorithm.linkedlist;

import src.util.ListNode;

public class No25 {
    public ListNode reverseKGroup(ListNode head, int k) {
        ListNode hook = new ListNode(-1, head);
        ListNode groupEnd = getKth(hook, k);
        ListNode groupStart = hook;

        while (groupEnd != null) {
            ListNode cur = groupStart.next;
            ListNode nxt;
            for (int i = 0; i < k - 1; i++) {
                nxt = cur.next;
                cur.next = nxt.next;
                nxt.next = groupStart.next;
                groupStart.next = nxt;
            }

            groupStart = cur;
            groupEnd = getKth(groupStart, k);
        }

        int count = getEnd(groupStart);
        ListNode cur = groupStart.next;
        ListNode nxt;
        for (int i = 0; i < count-1; i++) {
            nxt = cur.next;
            cur.next = nxt.next;
            nxt.next = groupStart.next;
            groupStart.next = nxt;
        }

        return hook.next;
    }

    public ListNode getKth(ListNode node, int k){
        while (k > 0) {
            if (node == null) {
                return null;
            }
            node = node.next;
            k--;
        }
        return node;
    }

    public int getEnd(ListNode node) {
        int count = 0;
        while (node.next != null) {
            count += 1;
            node = node.next;
        }
        return count;
    }
    public static void main(String[] args) {
        ListNode node1 = new ListNode(1, null);
        ListNode node2 = new ListNode(2, null);
        ListNode node3 = new ListNode(3, null);
        ListNode node4 = new ListNode(4, null);
        ListNode node5 = new ListNode(5, null);
        node1.next = node2;
        node2.next = node3;
        node3.next = node4;
        node4.next = node5;
        new No25().reverseKGroup(node1, 3);
    }
}
