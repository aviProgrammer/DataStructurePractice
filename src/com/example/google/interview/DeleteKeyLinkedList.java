package com.example.google.interview;

public class DeleteKeyLinkedList {

    private class Node {
        private int val;
        private Node next;

        Node(int val, Node next) {
            this.val = val;
            this.next = next;
        }
    }

    public static void main(String[] args) {

        int[] inputArr = {6, 2, 5, 10, -3, 15};
        Node head;
        DeleteKeyLinkedList dl = new DeleteKeyLinkedList();
        head = dl.createLinkedList(inputArr);
        dl.print(head);
        dl.deleteKey(head,5);
        dl.print(head);
    }

    private void print(Node head) {
        if(head == null)
            return;
        Node currNode = head;
        while(currNode != null) {
            System.out.print(currNode.val + " -> ");
            currNode = currNode.next;
        }
        System.out.print(" NULL");
        System.out.println();
    }

    private Node createLinkedList(int[] arr) {
        Node currNode = null, head = null;
        if(arr==null)
            return null;

        for (int i: arr) {
            Node newN = new Node(i, null);
            if(head == null)
                head = newN;
            if(currNode == null) {
                currNode = newN;
            } else {
                currNode.next = newN;
                currNode = newN;
            }
        }
        return head;
    }

    private Node deleteKey(Node head, int k) {
        if(head == null)
            return head;
        Node currNode=head, prevNode=null;
        while (currNode != null) {
            // if the key is found then delete the current node
            if (currNode.val == k) {
               if(prevNode == null) {
                   head = currNode.next;
               } else {
                   prevNode.next = currNode.next;
               }
               currNode.next = null;
               currNode = null;
               break;
            }
            prevNode = currNode;
            currNode = currNode.next;
        }
        return head;
    }


}
