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

    private int[] array;
    private int numItems;

    public List() {

        numItems = 0;
        array = new int[10];
    }

    public void add(int index, int num) {
        // if there is enough room in the array to store the desired number
        if (array.length > numItems) {
            // insert the number at the desired positon
            array[index] = num;

        }// if there is not enough space
        else {
            // make another array for space
            int[] temp = new int[array.length * 2];
            // copy values from original array into new array
            for (int i = 0; i < array.length; i++) {
                temp[i] = array[i];
            }
            // set the tremporary array to be the new array
            array = temp;
            // add the item in at the desired position
            array[index] = num;


        } // increase the number of items
        numItems++;
    }

    public int size() {
        return numItems;
    }

    public boolean isEmpty() {
        return numItems == 0;
    }

    public int get(int index) {

        return array[index];
    }

    public void remove(int index) {
        // if removing from the start
        if (index == 0) {

            for (int i = 1; i < array.length; i++) {
                // move all the values back one spot
                array[i - 1] = array[i];
            }
        }
        numItems--;
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        List list = new List();
        list.add(1, 1);
        for (int i = 0; i < list.size(); i++) {
            System.out.println(list.get(i));
        }
        System.out.println(list.isEmpty());
    }
}
