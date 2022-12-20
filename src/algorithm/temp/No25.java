package src.algorithm.temp;
import src.util.ListNode;

class No25 {
    public ListNode reverseKGroup(ListNode head, int k) {
        ListNode dummy = new ListNode(-1, head);
        ListNode res = dummy;

        ListNode prevGroup = dummy;
        while(true) {
            ListNode kth = getKth(prevGroup, k);
            if (kth == null) {
                break;
            }
            ListNode nextPrevGroup = prevGroup.next;

            //inverse node from prevGroup.next to kth;
            ListNode cur = prevGroup.next;
            ListNode prev = prevGroup;
            ListNode temp;
            for(int i = 0; i < k; i++) {
                temp = cur.next;
                cur.next = prev;
                prev = cur;
                cur = temp;
            }
            if (prevGroup == dummy) {
                res = prev;
            }
            prevGroup = nextPrevGroup;
        }
        
        return res;
        
    }

    public ListNode getKth(ListNode prevGroup, int k) {
        ListNode node = prevGroup;
        while(k!=0) {
            if (node == null) return null;
            node = node.next;
            k--;
        }
        return node;
    }
}