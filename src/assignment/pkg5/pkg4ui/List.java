/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package assignment.pkg5.pkg4ui;

/**
 *
 * @author Kiran
 */
public class List {

    // create an array
    private int[] array;
    // store the number of items
    private int numItems;

    public List() {
        // start off by setting the number of items to 0
        numItems = 0;
        // make the array 10 spots in length
        array = new int[10];
    }

    public void add(int index, int num) {
        // initialize an array that allows items to be kept track of so they can be shuffled in the list
        int[] shuffleDown = new int[numItems];

        // create a boolean to determine if there enough space in the array to add one more item
        boolean enoughSpace = true;
        // if the list is full
        if (numItems == array.length) {
            // there is not enough space
            enoughSpace = false;
        }

        // create a boolean to determine if the index they entered is immediatly after or after the last item
        boolean addLast = false;
        // if the index is equal or greater than the number of items
        if (index >= numItems) {
            // we are adding to the item to the end of the list
            addLast = true;
        }
        // create a boolean to determine if the user entered in a index which contains a previously entered value  which means items will be shuflled
        boolean addMiddle = false;
        // CHANGE COMMENT if there are two are more items and the idenx entered makes corresponds to a value wihtin the items
        if (numItems > 0 && numItems - index > 0) {
            // the number is to be added in the middle if the list
            addMiddle = true;
        }
        // if there is enough space to add an item
        if (enoughSpace) {

            // if the array is emtpy
            if (numItems == 0) {
                // put the value in the begining of the array, regardless of the index entered
                array[0] = num;
                // increase the number of items
                numItems++;
            }// the user wishes to place a value further or at the immediate end of the list
            else if (addLast) {
                // set the spot right after the end of the list to hold the number entered
                array[numItems] = num;
                // increase the number of items 
                numItems++;

            } // adding a value in the middle of the array where previously inputeed values are stored
            else if (addMiddle) {
                // inintialize an array that lets oart of the list be shuffled down
                int[] partShuffle = new int[numItems - index];
                // create a variable to keep track of the position from the index entered
                int keepTrackInFirstArray = index;
                // run the loop as many times as there are items to be shuffled
                for (int i = 0; i < partShuffle.length; i++) {
                    partShuffle[i] = array[keepTrackInFirstArray];
                    // move to the next space in the temporary array
                    keepTrackInFirstArray++;
                }
                // reset the variable so postions within the main array can be kept tracked of
                keepTrackInFirstArray = index;
                // run the loop as many times as there are items to be shuffled
                for (int i = 0; i < partShuffle.length; i++) {
                    // move every value in the array over one spot
                    array[keepTrackInFirstArray + 1] = partShuffle[i];
                    // move over one spot in the temporary array
                    keepTrackInFirstArray++;
                }
                // move all the values over one
                array[index] = num;
                // increase the number of items
                numItems++;
            }
        } // if the item is to be entered at the immediate end of the list and there is not enough space
        else if (addLast) {
            // make another array for space, double the size of the previous
            int[] temp = new int[array.length * 2];
            // copy values from original array into new array
            for (int i = 0; i < array.length; i++) {
                // fill the temporary array with all the values of the previous array
                temp[i] = array[i];
            }
            // set the tremporary array to be the new array
            array = temp;
            // insert the number at the end of the list
            array[numItems] = num;
            // increase the number of items
            numItems++;
        } // if the user wishes to add a number to the middle
        else if (addMiddle) {
            // inintialize an array that lets oart of the list be shuffled down
            int[] partShuffle = new int[numItems - index];
            // make another array for space, double the size of the previous
            int[] temp = new int[array.length * 2];
            // copy values from original array into new array
            for (int i = 0; i < array.length; i++) {
                // fill the temporary array with all the values of the previous array
                temp[i] = array[i];
            }
            // set the tremporary array to be the new array
            array = temp;
            // create a variable to keep track of the position in the temporary array
            int keepTrackInFirstArray = index;
            // run the loop as many times as there are items to be shuffled
            for (int i = 0; i < partShuffle.length; i++) {
                partShuffle[i] = array[keepTrackInFirstArray];
                // move to the next space in the temporary array
                keepTrackInFirstArray++;
            }
            // reset the variable to be able to keep track of the position from the index entered in the main array
            keepTrackInFirstArray = index;
            // run the loop as many times as there are items to be shuffled
            for (int i = 0; i < partShuffle.length; i++) {
                // move every value in the array over one spot
                array[keepTrackInFirstArray + 1] = partShuffle[i];
                // move over one spot in the temporary array
                keepTrackInFirstArray++;
            }
            // move all the values over one
            array[index] = num;
            // increase the number of items
            numItems++;
        }

    }

    public int size() {
        // retrun the number of items in the list
        return numItems;
    }

    public boolean isEmpty() {
        // return wether the number of the list contains 0 items or not
        return numItems == 0;
    }

    public int get(int index) {
        // return the value at the inputted index
        return array[index];
    }

    public void remove(int index) {
        // create an array to allow the array to be shuffled if need be
        int[] partShuffle = new int[numItems - (index - 1)];
        // if the there is more than one item in the list
        if (numItems > 1) {

            // if removing from the middle of the array (or begining if it has more than 1 item)
            if (numItems > 0 && numItems - index > 0) {
                // create a reference postion to help copy items from main array to temporary
                int copy = index + 1;
                // run the loop as many times as there are items to be shuffled
                for (int i = 0; i < partShuffle.length; i++) {
                    // copy over the values which need to be shuffled
                    partShuffle[i] = array[copy];
                    // increase the reference posiition
                    copy++;
                }
                // reset the reference position
                copy = index + 1;

                // run the loop as many times as there are items to be shuffled
                for (int i = 0; i < partShuffle.length; i++) {
                    // copy back the values which were shuffled
                    array[copy - 1] = partShuffle[i];
                    // increase the reference position
                    copy++;
                }
                // decrease the number of items in the list
                numItems--;

            }// removing from end of list
            else if (index + 1 == numItems) {
                // remove the value by setting it to 0
                array[index] = 0;
                // decrease the number of items in the list
                numItems--;
            }
        } // there is one item in the list to remove
        else if (numItems == 1) {
            // set the value of the posiotn within the array to be 0
            array[0] = 0;
            // decrease the number of items in the list
            numItems--;
        }// the list is empty
        else if (numItems == 0) {
            // tell user th elist is empty and nothing can be removed
            System.out.println("There is nothing to remove!");
        }

    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        List list = new List();
//        list.add(0, 1);
//        list.add(1, 33);
//        list.add(0, 3);
//        for (int i = 0; i < list.size(); i++) {
//            System.out.println(list.get(i));
//        }
//        System.out.println("");
//        list.add(1, 44);
//        for (int i = 0; i < list.size(); i++) {
//            System.out.println(list.get(i));
//        }
//        System.out.println("");
//        list.add(0, 333);
//        list.add(5, 90);
//        list.add(5, 90);
//        list.add(5, 90);
//        list.add(5, 90);
//        list.add(6, 90);
//        for (int i = 0; i < list.size(); i++) {
//            System.out.println(list.get(i));
//        }
//        System.out.println("");
//        list.add(1, 89);
//
//        //list.add(2222, 44);
//        //list.add(11111,9);
//        for (int i = 0; i < list.size(); i++) {
//            System.out.println(list.get(i));
//        }
//        list.remove(0);
        list.add(0, 1);
        list.add(2, 3);
        list.add(1, 33);
        for (int i = 0; i < list.size(); i++) {
            System.out.println(list.get(i));
        }
        System.out.println("");
        list.remove(0);
        for (int i = 0; i < list.size(); i++) {
            System.out.println(list.get(i));
        }
        System.out.println("Size " + list.size());

    }
}
