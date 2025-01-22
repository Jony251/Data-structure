import java.util.Scanner;
import unit4.collectionsLib.Stack;

public class inputUntilUserWillInputMinus999 {

    public static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {

        System.out.println(getInputUntilMinus999());

    }
    /**
     * A function to accept user input repeatedly until the input equals -999
     *
     * @return {@code Stack<Integer>} sorted stack
     */
    public static Stack<Integer> getInputUntilMinus999() {
        /*
         * Time Complexity
         * Total time O(n) --> Sum of the two loops is O(n)+O(n)=O(n)
         */

        System.out.println("Please enter a number: ");
        int inputNum = sc.nextInt();
        final int INPUT_STOP = -999;
        Stack<Integer> inputStack = new <Integer>Stack();

        while (inputNum != INPUT_STOP) {
            insertInSortedStackInteger(inputStack, inputNum);
            System.out.println("Please enter a number: ");
            inputNum = sc.nextInt();
        }
        return inputStack;
    }

    /**
     * Function for inserting a number into a sorted stack of integers
     *
     * @param stack sorted stack of integers
     * @param num integer for insert in
     * @return {@code Stack<Integer>} sorted stack with the new number inserted
     */
    public static Stack<Integer> insertInSortedStackInteger(Stack<Integer> stack, int num) {
        /*
         * Time Complexity
         * Total time O(n) --> Sum of the two loops is O(n)+O(n)=O(n)
         */
        Stack<Integer> temp = new <Integer>Stack();

        while (!stack.isEmpty() && stack.top() < num) {
            temp.push(stack.pop());
        }

        stack.push(num);

        while (!temp.isEmpty()) {
            stack.push(temp.pop());
        }
        return stack;
    }
}
