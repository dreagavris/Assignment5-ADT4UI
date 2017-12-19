
package assignment.pkg5.pkg4ui;
import java.util.Stack;

/**
 *
 * @author andreeagavris
 */
public class A5Q3 {

    public boolean inLang(String word) {
        Stack<Character> stack = new Stack<Character>();
        if (word.length() != 0) {
            char dollarSign = '$';
            if (word.charAt(word.length() / 2) == dollarSign) {
                char[] lettersInStack = new char[word.length()];
                for (int i = 0; i < word.length(); i++) {
                    lettersInStack[i] = word.charAt(i);
                    stack.push(lettersInStack[i]);
                }
                char[] lettersOutStack = new char[lettersInStack.length];
                for (int i = 0; i < word.length(); i++) {
                    lettersOutStack[i] = stack.pop();
                }
                for (int i = 0; i < lettersOutStack.length; i++) {
                    if (lettersInStack[i] != lettersOutStack[i]) {
                        return false;
                    }
                }
                return true;
            }
        }
        return false;

    }

    public static void main(String[] args) {
        // Testing
        A5Q3 test = new A5Q3();
        // output the method running
        System.out.println(test.inLang("ac$ca"));

    }

}
