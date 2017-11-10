/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package assignment.pkg5.pkg4ui;

/**
 *
 * @author manok5757
 */
public class OrderedList {
    
    private IntNode head;
    private int numItems;

    public OrderedList() {
        head = null;
        numItems = 0;
    }

    public void add(int num) {
        // create a node at the beginning of list (will be primary comparison node)
        IntNode node = head;
        // create a node to keep track of the node behind the primary node
        IntNode before = head;
        // create a boolean to ensure that the method will stop searching for the suitibale posiotn of the inputted number until said position is found
        boolean endSearch = false;
        // create a counter that helps keep track where the nodes are in the list
        int counter = 0;
        // if the list is empty
        if (numItems == 0) {
            // add a node into the list containing the desired number
            IntNode addNode = new IntNode(num);
            // make the new node point to the start
            addNode.setNext(head);
            // reassign the head to the begining
            head = addNode;
        } // if the list only has one item in it
        else if (numItems == 1) {
            // if the number inputted is smaller than the number in the list
            if (node.getNum() > num) {
                // place the number before the one in the list
                IntNode temp = new IntNode(num);
                // set the node equalt to the second node in the list
                temp.setNext(node);
                // reassigning head to the begining
                head = temp;

            }// the number inputted is larger or equal than the number in the list
            else {
                // create a node to add the number
                IntNode temp = new IntNode(num);
                // set the first item in the list linked to the new node being added
                node.setNext(temp);
                // reassign head
                head = node;
            }
        } // there is more than one item in the list
        else if (numItems > 1) {
            //see if the first item in the list is larger or equal to the number entered
            if (node.getNum() >= num) {
                // create a node to insert the number into the list
                IntNode temp = new IntNode(num);
                // link the node to the beginning of the list
                temp.setNext(head);
                // reassigning head to the begining
                head = temp;
            }// the first item in the list is less than the number entered
            else if (node.getNum() < num) {
                // move to the next item in the list
                node = node.getNext();
                // search while the best possible position to place the inputted number has not been found
                while (!endSearch) {
                    // increase the counter variable by one to indicate what node is being observed
                    counter++;
                    // if the nodes have reached the end of the list
                    if (counter == numItems) {
                        // create a node to store the inputted number
                        IntNode temp = new IntNode(num);
                        // link the last item in the list to the inputted number
                        before.setNext(temp);
                        // stop searching for the positon to place the node
                        endSearch = true;
                    } // the end of the list has not been reached and if the number in the list is larger or equal to the inputted number
                    else if (node.getNum() >= num) {
                        // create a node to hold the desired value
                        IntNode temp = new IntNode(num);
                        // link the newly created node to the node after it in the list
                        temp.setNext(node);
                        // set the node before the intitiale comparison node (IntNode node) to be linked to the node containing the desired number
                        before.setNext(temp);
                        // prevent the method from continuing to seek where to place the number in the list
                        endSearch = true;
                    }// the number is not smaller or equal to the comparison node
                    else {
                        // move the primary comarison node over
                        node = node.getNext();
                        // move the node behind the primary comparison node over
                        before = before.getNext();
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
        OrderedList list = new OrderedList();
        list.add(-1);

        list.add(-11);
        list.add(3);
        list.add(-3);
        list.add(222);
        list.add(22222);
        list.remove(22322);
        System.out.println("size " + list.size());;
        for (int i = 0; i < list.size(); i++) {
            System.out.println(list.get(i));
        }
    }
}
