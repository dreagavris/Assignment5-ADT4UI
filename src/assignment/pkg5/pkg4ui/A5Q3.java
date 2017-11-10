/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package assignment.pkg5.pkg4ui;

import java.util.Stack;

/**
 *
 * @author Kiran
 */
public class A5Q3 {

    public boolean inLang(String word) {
        // create a char stack 
        Stack<Character> stack = new Stack<Character>();
        // create a char to reconginze dollar signs
        char dollarSign = '$';
        // if the middle of the word has a dollar sign and it is longer than one letter (so it cant just be a $)
        if (word.charAt(word.length() / 2) == dollarSign && word.length() > 1) {
            // store all the characters of the string in an array
            char[] lettersInStack = new char[word.length()];

            // run loop as many times as there are characters in the string
            for (int i = 0; i < word.length(); i++) {

                // store this in the char array
                lettersInStack[i] = word.charAt(i);
                // push each character into the stack
                stack.push(lettersInStack[i]);
            }

            // create a new string array to get the characters coming out of the stack
            char[] lettersOutStack = new char[lettersInStack.length];
            // run loop as many times as there are characters in the string
            for (int i = 0; i < word.length(); i++) {
                // store each of the characters coming out of the stack
                lettersOutStack[i] = stack.pop();
            }

            // compare both arrays
            for (int i = 0; i < lettersOutStack.length; i++) {
                // if two letters from each array dont match their corresponding letter
                if (lettersInStack[i] != lettersOutStack[i]) {
                    // return false as one of the characters in each of the arrays were not the same
                    return false;
                }
            }// return true as the word meets all the criteria to be a part of the language
            return true;

        }// return false as the word does not contain a dollar sign in the middle
        return false;

    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // Testing
        A5Q3 test = new A5Q3();
        // output the method running
        System.out.println(test.inLang("r"));

    }

}
