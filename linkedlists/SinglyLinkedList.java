package linkedlists;

public class SinglyLinkedList {

    public SinglyNode head;
    public SinglyNode tail;
    public int size = 0;

    public SinglyLinkedList() {}

    public SinglyLinkedList(int init) {
        head = new SinglyNode();
        head.val = init;
        tail = head;
        size = 1;
    }

    public void insertAtHead(int val) {
        SinglyNode newNode = new SinglyNode();
        newNode.val = val;
        if(head==null) {
            head = newNode;
            tail = newNode;
        }
        else {
            newNode.next = head;
            head = newNode;
        }
        size++;
    }

    public void insertAtTail(int val) {
        SinglyNode newNode = new SinglyNode();
        newNode.val = val;
        if(tail==null) {
            head = newNode;
            tail = newNode;
        }
        else {
            tail.next = newNode;
            tail = newNode;
        }
        size++;
    }

    public void insert(int index, int value) {
        if(index<0 || index>size) {
            throw new IndexOutOfBoundsException("Cannot Insert at this index, since it is out of bounds");
        }
        if(index==0) {
            insertAtHead(value);
        }
        else if(index==size) {
            insertAtTail(value);
        }
        else {
            SinglyNode newNode = new SinglyNode(value);
            int i=0;
            SinglyNode pointer = head;
            while(pointer.next!=null) {
                if(i==index-1) {
                    newNode.next = pointer.next;
                    pointer.next = newNode;
                    break;
                }
                i++;
                pointer = pointer.next;
            }
            size++;
        }
    }

    public void removeNode(int index) {
        if(index<0 || index>=size) {
            throw new IndexOutOfBoundsException("Cannot remove node at this index, since it is out of bounds");
        }
        if(size==1) {
            head = null;
            tail = null;
            size = 0;
        }
        if(index==0) {
            head=head.next;
        }
        SinglyNode pointer = head;
        int i=0;
        while(pointer!=null) {
            if(i==index-1) {
                pointer.next = pointer.next.next;
                break;
            }
            pointer = pointer.next;
            i++;
        }
        size--;
    }

    public int find(int val) {
        int i = 0;
        SinglyNode pointer = head;
        for(;pointer!=null;pointer=pointer.next, i++) {
            if(pointer.val==val) {
                return i;
            }
        }
        return -1;
    }

    public void printList() {
        SinglyNode pointer = head;
        for(;pointer!=null;pointer=pointer.next) {
            System.out.print(pointer.val + " " );
        }
        System.out.println();
    }
}