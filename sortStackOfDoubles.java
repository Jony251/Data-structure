
import unit4.collectionsLib.Stack;

public class sortStackOfDoubles {
    public static void main(String[] args) {
        Stack<Double> st = new <Double>Stack();
        st.push(1.125);
        st.push(1.25);
        st.push(1.51);
        st.push(1.58);
        st.push(1.1);

        System.out.println(st);
        System.out.println(sortTheStack(st));
    }

    /**
     * A function that sorts the stack
     *
     * @param stack the stack of doubles
     * @return {@code Stack<Double>} sorted stack
     */
    public static Stack<Double> sortTheStack(Stack<Double> stack) {
        /*
         * Time Complexity
         * Total time
         * whatIsTheLargestDouble: O(n)
         * sortTheStack calls whatIsTheLargestDouble n times so the total complexity is: O(n^2)
         */

        Stack<Double> resStack = new <Double>Stack();
        while (!stack.isEmpty()) {
            resStack.push(whatIsTheLargestDouble(stack));
        }
        return resStack;
    }

    /**
     * Function that searches for the largest double in the stack
     * The original stack remains in the same order but without the largest double
     *
     * @param stack the stack of doubles
     * @return {@code double} largest double in stack
     */
    public static double whatIsTheLargestDouble(Stack<Double> stack) {
        /*
         * Time Complexity of whatIsTheLargestDouble
         * Total time O(n) --> Sum of the two loops is O(n)+O(n)=O(n)
         */
        Stack<Double> temp = new <Double>Stack();
        double max = Integer.MIN_VALUE, current;

        while (!stack.isEmpty()) {
            current = stack.pop();
            if (current > max) {
                max = current;
            }
            temp.push(current);
        }

        while (!temp.isEmpty())
            if(temp.top() != max)
                stack.push(temp.pop());
            else temp.pop();
        return max;
    }



}
