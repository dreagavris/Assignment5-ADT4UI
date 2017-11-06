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

    public int get(int index) {
        IntNode node = head;
        // move the number of times
        for (int i = 0; i < index; i++) {
            node = node.getNext();
        }
        return node.getNum();
    }

    /**
     *
     * @param num the number entered by the user to be removed from the list
     */
    public void remove(int num) {
        // create a node at the begining of the list
        IntNode node = head;
        // create a node to keep track of nods behind the comparison node
        IntNode before = head;
        // create a node to search the list and see if the value exists
        IntNode seek = head;
        // set the boolean which allows the node to initially move in front of the previous node to be false
        boolean setNodeInFront = false;
        // set the boolean which allows the program to determine if the desired number is in the list to be false
        boolean inList = false;
        // go through the entire list to determine if the number that is to be removed is in the list
        for (int i = 0; i < numItems; i++) {
            // if the value is within the array
            if (seek.getNum() == num) {
                // set the boolean that the desired number exists to be true
                inList = true;
            }
            // move to the next node to search for the value to be removed
            seek = seek.getNext();
        }
        // only run the rest of the method if the number to be removed is within the list
        if (inList) {
            // if the number that is to be removed is at the start of the list
            if (node.getNum() == num) {
                // move head up one (moving the list to remove the first node)
                head = head.getNext();
                node.setNext(null);
            } else if (!setNodeInFront) {
                // move the primary comparison node to the next node
                node = node.getNext();

                // set the boolean to be true so the node before the comparison node can be kept tracl of
                setNodeInFront = true;
            }
            // while the value stored in the node is not equal to the value that is to be removed
            while (node.getNum() != num) {
                // move to the next node
                node = node.getNext();
                // move the previous node to the next node
                before = before.getNext();
            }
            // if the node to be removed is at the end
            if (node.getNext() == null) {
                // sever the link with the last node
                node.setNext(null);
            } // if the node to be removed is in the middle of the list
            else {
                // set the previous node to be linked to the one after the one being removed
                before.setNext(node.getNext());
                // sever the link between the node being removed and the one after
                node.setNext(null);
            }
            // decrease the number of items in the list by 1
            numItems--;
        }
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TESTING
        A5Q1 list = new A5Q1();
        list.add(2);
        list.add(-5);
        list.add(12);
        list.add(11);
        list.add(1);
        list.remove(12);
        for (int i = 0; i < list.size(); i++) {
            System.out.println(list.get(i));
        }
    }
}
