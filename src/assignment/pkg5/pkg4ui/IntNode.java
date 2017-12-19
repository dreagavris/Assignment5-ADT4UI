
package assignment.pkg5.pkg4ui;

public class IntNode {

    private int item;
    private IntNode next;

    public IntNode(int num) {
        item = num;
        next = null;

    }

    public int getNum() {
        return item;
    }
    public IntNode getNext() {
        return next;
    }
    public void setNext(IntNode node) {
        next = node;
    }
}
