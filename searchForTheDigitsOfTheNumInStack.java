import unit4.collectionsLib.Stack;

public class searchForTheDigitsOfTheNumInStack {
    public static void main(String[] args) {
        Stack<Integer> st = new <Integer>Stack();
        st.push(1);
        st.push(2);
        st.push(3);
        st.push(4);
        st.push(5);

       System.out.println(st);
       System.out.println(searchForTheIntegersOfTheNumInStack(st, 124)); // false
       System.out.println(searchForTheIntegersOfTheNumInStack(st, 12));  // true
       System.out.println(searchForTheIntegersOfTheNumInStack(st, 23));  // true
       System.out.println(searchForTheIntegersOfTheNumInStack(st, 32));  // true
       System.out.println(searchForTheIntegersOfTheNumInStack(st, 321));  // true
       System.out.println(searchForTheIntegersOfTheNumInStack(st, 43));  // true
       System.out.println(st);
    }


    /**
     * The function searching if the digits of the number appear consecutively in stack with any order
     * The original stack remains unchanged after the check
     *
     * @param stack the stack of integers to check
     * @param num accepts a positive integer that we're searching for
     * @return {@code true} if the digits of the number appear consecutively in the stack, {@code false} otherwise
     *
     */
    public static boolean searchForTheIntegersOfTheNumInStack(Stack<Integer> stack, int num) {
        /*
         * Time Complexity
         * Total time
         * searchForTheIntegersOfTheNumInStack : O(n)
         * createStackFromNumber : O(n)
         * reverseStack : O(n)
         * copyStack : O(n)
         * lenOfStack : O(n)
         * checkSequence: O(m*n)
         */

        Stack<Integer> searchStack = createStackFromNumber(num);
        Stack<Integer> reversedSearchStack = reverseStack(searchStack);

        boolean forwardMatch = checkSequence(stack, searchStack);
        boolean reverseMatch = checkSequence(stack, reversedSearchStack);

        return forwardMatch || reverseMatch;
    }

    /**
     * The function creating a stack of digits from given number
     *
     * @param num positive number
     * @return {@code Stack<Integer>} stack of integers
     */
    private static Stack<Integer> createStackFromNumber(int num) {
        Stack<Integer> numStack = new <Integer>Stack();
        while (num > 0) {
            numStack.push(num % 10);
            num /= 10;
        }
        return numStack;
    }

    /**
     * The function reverses an integer stack<br/>
     * The original stack remains unchanged
     *
     * @param stack the stack of integers
     * @return {@code Stack<Integer>} new reversed stack
     */
    private static Stack<Integer> reverseStack(Stack<Integer> stack) {
        Stack<Integer> reversedStack = new <Integer>Stack();
        Stack<Integer> tempStack = new <Integer>Stack();
        while (!stack.isEmpty()) {
            reversedStack.push(stack.top());
            tempStack.push(stack.pop());
        }
        while (!tempStack.isEmpty()) {
            stack.push(tempStack.pop());
        }
        return reversedStack;
    }

    /**
     * The function is creating a copy of integer stack<br/>
     * The original stack remains unchanged
     *
     * @param stack the stack of integers
     * @return {@code true} new stack that is a copy of original
     */
    private static Stack<Integer> copyStack(Stack<Integer> stack) {
        Stack<Integer> copyStack = new <Integer>Stack();
        Stack<Integer> tempStack = new <Integer>Stack();

        while (!stack.isEmpty()) {
            tempStack.push(stack.pop());
        }
        while (!tempStack.isEmpty()) {
            stack.push(tempStack.top());
            copyStack.push(tempStack.pop());
        }
        return copyStack;
    }

    /**
     * The function counting the length of given stack<br/>
     * The original stack remains unchanged
     *
     * @param stack the stack of integers
     * @return {@code int} integer that representing a length of the stack
     */
    private static int lenOfStack(Stack<Integer> stack) {
        Stack<Integer> copySt = copyStack(stack);
        int count = 0;
        while (!copySt.isEmpty()) {
            copySt.pop();
            count++;
        }
        return count;
    }

    /**
     * The function is checking if in the first stack (originStack) located in second stack(sequence) consecutively in any order<br/>
     * The original stacks remains unchanged after the check
     *
     * @param originStack stack of integers (were we want search)
     * @param sequence stack of integers (what we are searching for)
     * @return {@code true} if in the first stack (originStack) located second stack(sequence) consecutively in any order, {@code false} otherwise
     */
    private static boolean checkSequence(Stack<Integer> originStack, Stack<Integer> sequence) {
        Stack<Integer> sequenceCopy = copyStack(sequence);
        Stack<Integer> stack = copyStack(originStack);
        int len = lenOfStack(sequence);
        Stack<Integer> tempStack = new <Integer>Stack();
        boolean isMatch = true;

        while (!stack.isEmpty() && !sequenceCopy.isEmpty()) {
            tempStack.push(stack.top());

            if (stack.top() == sequenceCopy.top()) {
                stack.pop();
                sequenceCopy.pop();
                for(int i=0;i<len && !stack.isEmpty() && !sequenceCopy.isEmpty();i++){
                    if (!sequenceCopy.isEmpty() && stack.top() != sequenceCopy.top()) {
                        isMatch = false;
                        break;
                    }
                    tempStack.push(stack.pop());
                    if(sequenceCopy.isEmpty())
                        break;
                    sequenceCopy.pop();
                }
            }
            if(!stack.isEmpty())
                stack.pop();
        }

        while (!tempStack.isEmpty()) {
            stack.push(tempStack.pop());
        }

        return isMatch && sequenceCopy.isEmpty();
    }

}
