

import unit4.collectionsLib.Stack;

public class insertAnIntegerInSortedStack {
    public static void main(String[] args) {
        Stack<Integer> st = new <Integer>Stack();
        st.push(50);
        st.push(40);
        st.push(30);
        st.push(20);
        st.push(10);

        System.out.println(st);
        System.out.println(insertInSortedStackInteger(st,15));
        System.out.println(insertInSortedStackInteger(st,5));
        System.out.println(insertInSortedStackInteger(st,20));

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
