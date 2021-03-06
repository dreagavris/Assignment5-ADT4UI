package assignment.pkg5.pkg4ui;

public class List {

    private String[] stack;
    private int numItems;

    public List() {
        stack = new String[10];
        numItems = 0;
    }

    public void push(String item) {
        // if there is room in the stack
        if (numItems < stack.length) {
            // put the item on the stack
            stack[numItems] = item;
            numItems++;
        }else{
            // make more room
            String[] temp = new String[stack.length*2];
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
    
    public String pop(){
        // get the top item on the stack
        String item = stack[numItems - 1];
        // one less item
        numItems--;
        // give back item
        return item;
        
    }
    
    public int size(){
        return numItems;
    }
    
    public String peek(){
        return stack[numItems - 1];
    }
    
    public boolean isEmpty(){
        return numItems == 0;
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // the stack works because done in class and was working therefore only test the inLang
        // make sure the inLang works
        String test = "as$sa";
        boolean result = inLang(test);
        System.out.println(result);
    }

    public static boolean inLang(String word) {
        // make sure the word contains the $ sign
        if (!word.contains("$")) {
            // if not return false
            System.out.println("The word doesn't have $ sign.");
            return false;
        }
        
        // create two stacks
        List stack1 = new List();
        List stack2 = new List();
        
        // split the word from the point that it sees the sign $
        String[] parts = word.split("\\$");
        
        
        String part1 = parts[0];
        String part2 = parts[1];
        
        // make part1 be taken apart from the beginning letter
        for (int i = 0; i < part1.length(); i++){
            stack1.push(String.valueOf(part1.charAt(i)));
        }
        
        // make part2 be looked from the end to compare part1 and part2
        for (int i = part2.length() - 1; i >= 0; i--) {
            stack2.push(String.valueOf(part2.charAt(i)));
        }
        
        // make sure the size of part1 and part2 are the same otherwise they're not palindrome
        if (stack1.size() != stack2.size()) {
            System.out.println(word + " is not in the correct language");
            return false;
        }
        
        // make sure to check each letter until stack is empty
        while (!stack1.isEmpty()) {

            String popFromStack1 = stack1.pop();
            String popFromStack2 = stack2.pop();
           
            // if they are not the same letters than it is not palindrome
            if (!popFromStack1.equals(popFromStack2)) {
                System.out.println(word + " not in correct the language");
                return false;
            }
        }
        // otherwise it is palindrome and the code is in language
        System.out.println(word + "not in the correct the language");
        return true;
    }
}