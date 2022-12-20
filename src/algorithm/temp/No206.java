package src.algorithm.temp;
import src.util.ListNode;

public class No206 {
    public ListNode reverseKGroup(ListNode head, int k) {
        ListNode res = new ListNode();
        ListNode groupHead = head;
        while(true) {
            ListNode kth = getKth(groupHead, k);
            if (groupHead == head) {
                res.next = kth;
            }
            if (kth == null) {
                break;
            }
            ListNode nextGroupHead = kth.next;

            //inverse node from prevGroup.next to kth;
            ListNode cur = groupHead;
            ListNode prev = nextGroupHead;
            ListNode temp;
            for(int i = 0; i < k; i++) {
                temp = cur.next;
                cur.next = prev;
                
                prev = cur;
                cur = temp;
            }
            groupHead = nextGroupHead;
        }
        
        return res.next;
        
    }

    public ListNode getKth(ListNode groupHead, int k) {
        ListNode node = groupHead;
        while(k>1) {
            if (node == null) return null;
            node = node.next;
            k--;
        }
        return node;
    }
}
