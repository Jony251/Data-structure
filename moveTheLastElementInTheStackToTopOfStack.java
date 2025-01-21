import unit4.collectionsLib.Stack;

public class moveTheLastElementInTheStackToTopOfStack {
    public static void main(String[] args) {
        Stack<Integer> st = new <Integer>Stack();
        st.push(10);
        st.push(20);
        st.push(30);
        st.push(40);
        st.push(50);

        System.out.println(st);
        System.out.println(moveTheLastElementInStackToTopOfStack(st));

    }
    /**
     * Function that moves last element in stack to the top of the stack
     * The original stack remains unchanged after the check
     *
     * @param st the stack of integers
     * @return {@code Stack<Integer>} changed stack
     */
    public static Stack<Integer> moveTheLastElementInStackToTopOfStack (Stack < Integer > st) {
        Stack<Integer> res = new <Integer>Stack();
        Stack<Integer> temp = new <Integer>Stack();
        int lastEl;
        while (!st.isEmpty()) {
            temp.push(st.pop());
        }
        lastEl=temp.pop();

        while (!temp.isEmpty())
            res.push(temp.pop());
        res.push(lastEl);
        return res;
    }

}
