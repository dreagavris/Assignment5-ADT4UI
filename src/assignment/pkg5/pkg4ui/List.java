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
        int[] shuffleDown = new int[numItems];
        boolean enoughSpace = true;
        if (numItems == array.length) {
            enoughSpace = false;
        }
        boolean addLast = false;
        if (index >= numItems) {
            addLast = true;
        }
        boolean addMiddle = false;
        if (numItems > 0 && numItems - index > 0) {
            addMiddle = true;
        }
        if (enoughSpace) {
            if (numItems == 0) {
                array[0] = num;
                numItems++;
            } else if (addLast) {
                array[numItems] = num;
                numItems++;

            } else if (addMiddle) {
                int[] partShuffle = new int[numItems - index];
                int keepTrackInFirstArray = index;
                for (int i = 0; i < partShuffle.length; i++) {
                    partShuffle[i] = array[keepTrackInFirstArray];
                    keepTrackInFirstArray++;
                }
                keepTrackInFirstArray = index;
                for (int i = 0; i < partShuffle.length; i++) {
                    array[keepTrackInFirstArray + 1] = partShuffle[i];
                    keepTrackInFirstArray++;
                }
                array[index] = num;
                numItems++;
            }
        } else if (addLast) {
            int[] temp = new int[array.length * 2];
            for (int i = 0; i < array.length; i++) {
                temp[i] = array[i];
            }
            array = temp;
            array[numItems] = num;
            numItems++;
        } else if (addMiddle) {
            int[] partShuffle = new int[numItems - index];
            int[] temp = new int[array.length * 2];
            System.arraycopy(array, 0, temp, 0, array.length);
            array = temp;
            int keepTrackInFirstArray = index;
            for (int i = 0; i < partShuffle.length; i++) {
                partShuffle[i] = array[keepTrackInFirstArray];
                keepTrackInFirstArray++;
            }
            keepTrackInFirstArray = index;
            for (int i = 0; i < partShuffle.length; i++) {
                array[keepTrackInFirstArray + 1] = partShuffle[i];
                keepTrackInFirstArray++;
            }

            array[index] = num;
            numItems++;
        }
    }

    public int size() {
        return numItems;
    }

    public boolean isEmpty() {
        return numItems == 0;
    }

    public int get(int index) {
        if (numItems > index) {
            return array[index];
        } else {
            return -999999;
        }

    }

    public void remove(int index) {
        int[] partShuffle = new int[numItems - (index - 1)];
        if (numItems > 1) {
            if (numItems > 0 && numItems - index > 0) {
                int copy = index + 1;
                for (int i = 0; i < partShuffle.length; i++) {
                    partShuffle[i] = array[copy];
                    copy++;
                }
                copy = index + 1;
                for (int i = 0; i < partShuffle.length; i++) {
                    array[copy - 1] = partShuffle[i];
                    copy++;
                }
                numItems--;
            } else if (index + 1 == numItems) {
                numItems--;
            }
        } else if (numItems == 1) {
            numItems--;
        } else if (numItems == 0) {
            System.out.println("There is nothing to remove!");
        }

    }

    public static void main(String[] args) {
        // TESTING
        List list = new List();
        list.add(0, 1);
        list.add(2, 3);
        list.add(1, 33);
        for (int i = 0; i < list.size(); i++) {
            System.out.println(list.get(i));
        }
        System.out.println("");
        list.remove(2);
        for (int i = 0; i < list.size(); i++) {
            System.out.println(list.get(i));
        }
        System.out.println("Size " + list.size());
        System.out.println(list.get(0));
    }
}
