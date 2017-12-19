package assignment.pkg5.pkg4ui;

/**
 *
 * @author andreeagavris
 */
public class OrderedList {

    private IntNode head;
    private int numItems;

    public OrderedList() {
        head = null;

        numItems = 0;
    }

    public void add(int num) {
        IntNode node = head;
        IntNode before = head;
        boolean endSearch = false;
        int counter = 0;
        if (numItems == 0) {
            IntNode addNode = new IntNode(num);
            addNode.setNext(head);
            head = addNode;
        } else if (numItems == 1) {
            if (node.getNum() > num) {
                IntNode temp = new IntNode(num);
                temp.setNext(node);
                head = temp;

            } else {

                IntNode temp = new IntNode(num);
                node.setNext(temp);
                head = node;
            }
        } else if (numItems > 1) {

            if (node.getNum() >= num) {
                IntNode temp = new IntNode(num);
                temp.setNext(head);
                head = temp;
            } else if (node.getNum() < num) {
                node = node.getNext();
                while (!endSearch) {
                    counter++;
                    if (counter == numItems) {
                        IntNode temp = new IntNode(num);
                        before.setNext(temp);

                        endSearch = true;
                    } else if (node.getNum() >= num) {
                        IntNode temp = new IntNode(num);
                        temp.setNext(node);
                        before.setNext(temp);

                        endSearch = true;
                    } else {
                        node = node.getNext();

                        before = before.getNext();
                    }
                }
            }
        }
        numItems++;
    }

    public int size() {
        return numItems;
    }

    public boolean isEmpty() {
        return numItems == 0;
    }

    public int get(int index) {
        IntNode node = head;
        for (int i = 0; i < index; i++) {
            node = node.getNext();
        }

        return node.getNum();
    }

    public void remove(int num) {
        if (numItems != 0) {
            IntNode node = head;
            IntNode before = head;
            IntNode seek = head;
            boolean setNodeInFront = false;
            boolean inList = false;
            for (int i = 0; i < numItems; i++) {
                if (seek.getNum() == num) {
                    inList = true;
                }
                seek = seek.getNext();
            }
            if (inList) {
                if (node.getNum() == num) {
                    head = head.getNext();
                    node.setNext(null);
                } else if (!setNodeInFront) {
                    node = node.getNext();
                    setNodeInFront = true;
                }
                while (node.getNum() != num) {
                    node = node.getNext();
                    before = before.getNext();
                }
                if (node.getNext() == null) {
                    node.setNext(null);
                } else {
                    before.setNext(node.getNext());
                    node.setNext(null);
                }
                numItems--;
            }
        }
    }

    public static void main(String[] args) {
        // TESTING
        OrderedList list = new OrderedList();
        list.add(-1);

        list.add(-11);
        list.add(3);
        list.add(-3);
        list.add(222);
        list.add(22222);
        list.remove(22322);
        System.out.println("size " + list.size());
        for (int i = 0; i < list.size(); i++) {
            System.out.println(list.get(i));
        }
    }
}
