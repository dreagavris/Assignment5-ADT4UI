/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package assignment.pkg5.pkg4ui;

/**
 *
 * @author manok5757
 */
public class A5Q1 {

    private IntNode head;
    private int numItems;

    public A5Q1() {
        head = null;
        numItems = 0;
    }

    public void add(int num) {
        // start at beginning of list
        IntNode node = head;
        // see if it is first item
        if (node == null) {
            IntNode temp = new IntNode(num);
            head = temp;
        } else {
            // travel to the end 
            while (node.getNext() != null) {
                // travel to the next node
                node = node.getNext();
            }
            // node is the last node in the list
            // create the new node
            IntNode temp = new IntNode(num);
            // insert it into the list
            node.setNext(temp);
        }
        // increase the size counter 
        numItems++;
    }



    public int size() {
        return numItems;
    }

    public boolean isEmpty() {
        return numItems == 0;
    }

    public int get(int position) {
        IntNode node = head;
        // move the number of times
        for (int i = 0; i < position; i++) {
            node = node.getNext();
        }
        return node.getNum();
    }

    public void remove(int pos) {

        // if removing from the start
        if (pos == 0) {
            head = head.getNext();
        } else if (pos == numItems - 1) {
            // removing from end
            IntNode node = head;
            // moving to the second last item
            for (int i = 0; i < numItems - 1; i++) {
                node = node.getNext();
            }
            // sever the link
            node.setNext(null);
        } else {
            IntNode node = head;
            // move to the spot just before
            for (int i = 0; i < pos - 1; i++) {
                node = node.getNext();
            }
            // the node to remove
            IntNode toRemove = node.getNext();
            // its next node
            IntNode next = toRemove.getNext();
            // set all the llinks
            node.setNext(next);
            toRemove.setNext(null);
        }
        numItems--;
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        A5Q1 list = new A5Q1();
        list.add(2);
        list.add(-5);
        list.add(0, 13);
        list.remove(1);
        for (int i = 0; i < list.size(); i++) {
            System.out.println(list.get(i));
        }
    }
}
