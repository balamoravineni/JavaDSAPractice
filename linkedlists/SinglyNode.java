package linkedlists;

public class SinglyNode {
    public int val;
    public SinglyNode next;
    SinglyNode() {}
    SinglyNode(int val) {
        this.val = val;
    }
    SinglyNode(int val, SinglyNode next) {
        this.val = val;
        this.next = next;
    }
}
