package src;

import src.util.ListNode;

import java.awt.image.Kernel;
import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;

public class No23 {
    Comparator<ListNode> comparator = new Comparator<ListNode>() {
        @Override
        public int compare(ListNode o1, ListNode o2) {
            return o1.val - o2.val;
        }
    };
    PriorityQueue<ListNode> priorityQueue = new PriorityQueue<>(comparator);
    public ListNode mergeKLists(ListNode[] lists) {
        for (ListNode x: lists) {
            priorityQueue.add(x);
        }

        ListNode hook = new ListNode();
        ListNode node = hook;

        ListNode n;
        while (!priorityQueue.isEmpty()) {
            n = priorityQueue.poll();
            node.next = n;
            if (n.next != null) {
                priorityQueue.add(n.next);
            }
            node = node.next;
        }

        return hook.next;
    }
}
