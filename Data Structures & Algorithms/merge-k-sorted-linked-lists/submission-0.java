/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */

class Solution {
    public ListNode mergeKLists(ListNode[] lists) {
        if(lists==null || lists.length==0)
            return null;
        PriorityQueue<ListNode> pq = new PriorityQueue<>((a,b)->Integer.compare(a.val,b.val));
        for(ListNode list : lists)
        {
            if(list!=null)
            {
                pq.add(list);
            }
        }
        ListNode prev=new ListNode(0);
        ListNode tail=prev;
        while(!pq.isEmpty())
        {
                ListNode smallestNode = pq.poll();
                tail.next=smallestNode;
                tail=tail.next;
                if (smallestNode.next != null) {
                pq.add(smallestNode.next);
                            }
        }
        return prev.next;
    }
}
