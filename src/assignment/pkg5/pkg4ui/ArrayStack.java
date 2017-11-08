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
public class ArrayStack {

    // store all of the integers on the stack
    private int[] stack;
    // keep track of how many items
    private int numItems;

    public ArrayStack() {
        stack = new int[10];
        numItems = 0;
    }

    public void push(int item) {
        // if there is room in the stack
        if (numItems < stack.length) {
            // put the item on the stack
            stack[numItems] = item;
            numItems++;
        }else{
            // make more room
            int[] temp = new int[stack.length*2];
            // copy items over
            for(int i = 0; i < stack.length; i++){
                temp[i] = stack[i];
            }
            // stack becomes new array
            stack = temp;
            // add item
            stack[numItems] = item;
            numItems++;
        }
    }
    
    public int pop(){
        // get the top item on the stack
        int item = stack[numItems - 1];
        // one less item
        numItems--;
        // give back item
        return item;
        
    }
    
    public int size(){
        return numItems;
    }
    
    public int peek(){
        return stack[numItems - 1];
    }
    
    public boolean isEmpty(){
        return numItems == 0;
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        
        // create an empty stack
        ArrayStack stack = new ArrayStack();
        System.out.println("Empty: " + stack.isEmpty());
        stack.push(12);
        System.out.println("Empty: " + stack.isEmpty());
        System.out.println("Peek: " + stack.peek());
        System.out.println("Size: " + stack.size());
        int item = stack.pop();
        System.out.println("Popped item: " + item);
        System.out.println("Empty: " + stack.isEmpty());
        
        // test adding lots of items
        for(int i = 0; i < 100; i++){
            stack.push(i);
        }
        System.out.println("Size: " + stack.size());
        System.out.println("Peek: " + stack.peek());
        stack.pop();
        System.out.println("Peek: " + stack.peek());
    }

}

