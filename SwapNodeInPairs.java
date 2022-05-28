public class SwapNodeInPairs {
    public ListNode swapPairs(ListNode head) {
        if (head == null || head.next == null) return head;
        ListNode newHead = null;
        ListNode node = head;
        ListNode nextNode;
        ListNode prevNode = null;
        while (node != null && node.next != null) {
            
            nextNode = node.next;
            node.next = nextNode.next;
            nextNode.next = node;
            if (node==head) {
                newHead = nextNode;
            }
            node = nextNode.next.next;
            if (prevNode != null) {
                prevNode.next = nextNode;
            }
            prevNode = nextNode.next;
        }
        return newHead;
    }

    public static void main(String[] args) {
        int[] nums = {1, 2, 3, 4, 5, 6};
        System.out.println(new SwapNodeInPairs().swapPairs(ListNode.parse(nums)));
    }
}
