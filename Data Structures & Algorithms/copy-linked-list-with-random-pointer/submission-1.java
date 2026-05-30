/*
// Definition for a Node.
class Node {
    int val;
    Node next;
    Node random;

    public Node(int val) {
        this.val = val;
        this.next = null;
        this.random = null;
    }
}
*/

class Solution {
    public Node copyRandomList(Node head) {
     /*   if(head==null)
        return null;
        HashMap<Node,Node> hm=new HashMap<>();
            Node curr=head;
        while(curr!=null)
        {
            hm.put(curr,new Node(curr.val));
            curr=curr.next;
        }
        curr=head;
        while(curr!=null)
        {
            Node clonenode =hm.get(curr);
            clonenode.next=hm.get(curr.next);
            clonenode.random=hm.get(curr.random);
            curr=curr.next;
        }

        return hm.get(head);*/
        if (head == null) return null;
        
        // Step 1: Interweave the cloned nodes with original nodes
        Node curr = head;
        while (curr != null) {
            Node nextOriginal = curr.next;
            Node cloneNode = new Node(curr.val);
            
            curr.next = cloneNode;
            cloneNode.next = nextOriginal;
            
            curr = nextOriginal;
        }
        
        // Step 2: Assign random pointers for the cloned nodes
        curr = head;
        while (curr != null) {
            if (curr.random != null) {
                curr.next.random = curr.random.next;
            }
            curr = curr.next.next; // Move to the next original node
        }
        
        // Step 3: Separate the interwoven lists
        curr = head;
        Node pseudoHead = new Node(0); // Dummy node to help build the copy list
        Node copyCurr = pseudoHead;
        
        while (curr != null) {
            Node nextOriginal = curr.next.next;
            
            // Extract the clone
            copyCurr.next = curr.next;
            copyCurr = copyCurr.next;
            
            // Restore the original list
            curr.next = nextOriginal;
            
            curr = nextOriginal;
        }
        
        return pseudoHead.next;

    }
}
