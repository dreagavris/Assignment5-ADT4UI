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
        // create a node to keep track of the node behind the primary node
        IntNode before = head;
        boolean endSearch = false;
        int counter = 1;

        // if the list is empty
        if (numItems == 0) {
            // add a node into the list containing the desired number
            IntNode addNode = new IntNode(num);
            // make the new node point to the start
            addNode.setNext(head);
            // reassign the head to the begining
            head = addNode;
            System.out.println("ssssssss");
        } // if the list only has one item in it
        else if (numItems == 1) {
            // if the number inputted is smaller than the number in the list
            if (node.getNum() > num) {
                // place the number before the one in the list
                IntNode temp = new IntNode(num);
                temp.setNext(node);
                // reassigning head to the begining
                head = temp;
                System.out.println("asssa");

            }// the number inputted is larger or equal than the number in the list
            else {
                System.out.println("aa");
                // create a node to add the number
                IntNode temp = new IntNode(num);
                node.setNext(temp);
                // reassign head
                head = node;
            }
        } // there is more than one item in the list
        else {
            System.out.println("fuc");

            if (head.getNum() >= num) {
                IntNode temp = new IntNode(num);
                temp.setNext(head);
                head = temp;
            } else {

                node = node.getNext();
                System.out.println("shi");
                // move the primary comparison node over one
                while (!endSearch) {
                    System.out.println("hi");
                    counter++;
                    System.out.println("em");
                    if (node.getNum() >= num) {
// create a new node to insert the number to be added
                        IntNode temp = new IntNode(num);
                        // link the new node created to the primary comparison node
                        temp.setNext(node);
                        // link the before node to the new temporary node
                        before.setNext(temp);
                        endSearch = true;
                        
                    } // the number in the node is smaller or equal to the number to be entered
                    else if (node.getNum() < num) {
                        // move on to the next node in the list
                        node = node.getNext();
                        System.out.println("hee");
                        // move the before node to the next node
                        before = before.getNext();
                    } else if (counter == numItems) {
                        IntNode temp = new IntNode(num);
                        node.setNext(temp);
                        endSearch = true;

                    }
                }

            }
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
        // only run this method when the list is not empty
        if (numItems != 0) {
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
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TESTING
        A5Q1 list = new A5Q1();
        list.add(1);
        list.add(4);
        list.add(9);
            
        list.add(0);
        for (int i = 0; i < list.size(); i++) {
            System.out.println(list.get(i));
        }
    }
}
