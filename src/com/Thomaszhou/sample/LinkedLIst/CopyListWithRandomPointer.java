package com.Thomaszhou.sample.LinkedLIst;
/*
A linked list is given such that each node contains an additional random pointer which could point to any node in the list or null.

Return a deep copy of the list.

The Linked List is represented in the input/output as a list of n nodes. Each node is represented as a pair of [val, random_index] where:

val: an integer representing Node.val
random_index: the index of the node (range from 0 to n-1) where random pointer points to, or null if it does not point to any node.
 */


import java.util.HashMap;

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
class Node {
    int val;
    Node next;
    Node random;

    public Node(int val, Node next, Node random) {
        this.val = val;
        this.next = null;
        this.random = null;
    }
}

public class CopyListWithRandomPointer {
    /*
    solution1 treat as graph. use hashmap to record. recursive time n space n
     */
// HashMap which holds old nodes as keys and new nodes as its values.
    HashMap<Node, Node> visitedHash = new HashMap<Node, Node>();

    public Node copyRandomList1(Node head) {

        if (head == null) {
            return null;
        }

        // If we have already processed the current node, then we simply return the cloned version of
        // it.
        if (this.visitedHash.containsKey(head)) {
            return this.visitedHash.get(head);
        }

        // Create a new node with the value same as old node. (i.e. copy the node)
        Node node = new Node(head.val, null, null);

        // Save this value in the hash map. This is needed since there might be
        // loops during traversal due to randomness of random pointers and this would help us avoid
        // them.
        this.visitedHash.put(head, node);

        // Recursively copy the remaining linked list starting once from the next pointer and then from
        // the random pointer.
        // Thus we have two independent recursive calls.
        // Finally we update the next and random pointers for the new node created.
        node.next = this.copyRandomList1(head.next);
        node.random = this.copyRandomList1(head.random);

        return node;
    }

    /*

     */
    // Visited dictionary to hold old node reference as "key" and new node reference as the "value"
    HashMap<Node, Node> visited = new HashMap<Node, Node>();
    public Node getClonedNode(Node node) {
        // If the node exists then
        if (node != null) {
            // Check if the node is in the visited dictionary
            if (this.visited.containsKey(node)) {
                // If its in the visited dictionary then return the new node reference from the dictionary
                return this.visited.get(node);
            } else {
                // Otherwise create a new node, add to the dictionary and return it
                this.visited.put(node, new Node(node.val, null, null));
                return this.visited.get(node);
            }
        }
        return null;
    }

    public Node copyRandomList2(Node head) {

        if (head == null) {
            return null;
        }

        Node oldNode = head;

        // Creating the new head node.
        Node newNode = new Node(oldNode.val, null, null);
        this.visited.put(oldNode, newNode);

        // Iterate on the linked list until all nodes are cloned.
        while (oldNode != null) {
            // Get the clones of the nodes referenced by random and next pointers.
            newNode.random = this.getClonedNode(oldNode.random);
            newNode.next = this.getClonedNode(oldNode.next);

            // Move one step ahead in the linked list.
            oldNode = oldNode.next;
            newNode = newNode.next;
        }
        return this.visited.get(head);
    }

    /*
    put clone node in place next to original 3 pass. time n space 1.
     */
    public Node copyRandomList3(Node head) {
        if(head == null) return null;
        Node cur = head;
        Node origHead = head;
        //weaving in new node with old node.
        while(cur != null){
            Node newNode = new Node(cur.val, null, null);
            newNode.next = cur.next;
            cur.next = newNode;
            cur = cur.next.next;
        }

        // get the random pointers right
        cur = origHead;
        while(cur != null){
            Node newNode = cur.next;
            if(cur.random != null) {
                newNode.random = cur.random.next;
            }
            cur = cur.next.next;
        }

        // unweaving the linkedlist
        cur = origHead;
        Node clonedHead = cur.next;
        Node cloneCur;
        while(cur !=null){
            cloneCur = cur.next;
            cur.next = cur.next.next;
            if(cloneCur.next != null) {
                cloneCur.next = cloneCur.next.next;
            }
            cur = cur.next;
        }

        return clonedHead;
    }
}
