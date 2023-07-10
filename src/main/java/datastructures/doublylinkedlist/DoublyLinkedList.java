package datastructures.doublylinkedlist;

public class DoublyLinkedList {
    private Node head;
    private Node tail;
    private int length;


    public DoublyLinkedList(int value) {
        Node newNode = new Node(value);
        head = newNode;
        tail = newNode;
        length = 1;
    }

    public void getHead() {
        System.out.println("Head:: " + head.value);
    }

    public void getTail() {
        System.out.println("Tail:: " + tail.value);
    }

    public void getLength() {
        System.out.println("Length:: " + length);
    }

    public void printList() {
        if(head!=null) {
            Node current = head;
            while(current!=null) {
                System.out.print(current.value + ", ");
                current = current.next;
            }
        }
        System.out.println("");
    }

    public void append(int value) {
        Node nodeToAppend = new Node(value);

        if(length == 0) {
            head = nodeToAppend;
            tail = nodeToAppend;
        } else {
            tail.next = nodeToAppend;
            nodeToAppend.prev = tail;
            tail = nodeToAppend;

        }
        length+=1;
    }

    public Node removeLast() {
        if(length == 0) {
            return null;
        }
        Node temp = tail;
        if(length == 1) {
            head = null;
            tail = null;
        } else {
            tail = tail.prev;
            tail.next = null;
            temp.prev = null;
        }
        length--;
        return temp;
    }

    public void prepend(int value) {
        Node newNodeToPrepend = new Node(value);
        if(length == 0) {
            head = newNodeToPrepend;
            tail = newNodeToPrepend;
        } else {
            newNodeToPrepend.next = head;
            head.prev = newNodeToPrepend;
            head = newNodeToPrepend;
        }
        length++;
    }

    public Node removeFirst() {
        if(length == 0) {
            return null;
        }
        Node temp = head;
        if(length == 1) {
            head = null;
            tail = null;
        } else {
            head = head.next;
            head.prev = null;
            temp.next = null;
        }
        length--;
        return temp;
    }

    public Node getFromHead(int index) {
        if(index <0 || index >= length) {
            return null;
        }
        Node temp = head;
        for(int i = 0; i < index; i++) {
            temp = temp.next;
        }
        return temp;
    }

    public Node get(int index) {
        if(index <0 || index >= length) {
            return null;
        }
        if(length/2 > index) {
            Node temp = head;
            for(int i = 0; i < index; i++) {
                temp = temp.next;
            }
            return temp;
        } else {
            Node temp = tail;
            for(int i=length-1; i > index; i--) {
                temp = temp.prev;
            }
            return temp;
        }
    }

    public boolean set(int index, int value) {
        Node temp = get(index);
        if(temp != null) {
            temp.value = value;
            return true;
        }
        return false;
    }

    public boolean insert(int index, int value) {
        if(index < 0 || index > length) {
            return false;
        }
        if(index == length) {
            append(value);
        }
        if(index == 0) {
            prepend(value);
        }
        Node newNodeToInsert = new Node(value);
        Node before = get(index-1);
        Node after = before.next;
        newNodeToInsert.prev = before;
        newNodeToInsert.next = after;
        before.next = newNodeToInsert;
        after.prev = newNodeToInsert;
        length++;
        return true;
    }

    public Node remove(int index) {
        if(index < 0 || index >= length) {
            return null;
        }
        if(index == 0) {
            removeFirst();
        }
        if(index == length-1) {
            removeLast();
        }
        Node temp = get(index);
        temp.next.prev = temp.prev;
        temp.prev.next = temp.next;
        temp.next = null;
        temp.prev = null;
        length--;
        return temp;
    }

    public void swapFirstLast() {
        if(length>2) {
           int temp = head.value;
           head.value = tail.value;
           tail.value = temp;
        }
    }

    public void reverse() {
        Node currentNode = head;
        Node temporaryNode = null;

        while (currentNode != null) {
            temporaryNode = currentNode.prev;
            currentNode.prev = currentNode.next;
            currentNode.next = temporaryNode;
            currentNode = currentNode.prev;
        }
        temporaryNode = head;
        head = tail;
        tail = temporaryNode;
    }

    public boolean isPalindrome() {
        if(length <=1){
            return true;
        }
        Node forwardNode = head;
        Node backwardNode = tail;

        for(int i=0; i<length/2; i++) {
            if(forwardNode.value != backwardNode.value) {
                return false;
            }
            forwardNode= forwardNode.next;
            backwardNode = backwardNode.prev;
        }
        return true;
    }

    public void swapPairs() {
        Node dummy = new Node(0);
        dummy.next = head;

        Node prev = dummy;

        while(head!=null && head.next!=null){
            Node firstNode = head;
            Node secondNode = head.next;

            prev.next = secondNode;
            firstNode.next = secondNode.next;

            secondNode.prev = prev;
            firstNode.prev = secondNode;

            if(firstNode.next!=null) {
                firstNode.next.prev = firstNode;
            }
            head = firstNode.next;
            prev = firstNode;
        }
        head = dummy.next;
        if(head!=null) {
            head.prev=null;
        }
    }



}

class Node {
    int value;
    Node next;

    Node prev;

    Node(int value) {
        this.value = value;
    }

}