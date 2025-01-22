import unit4.collectionsLib.Stack;
public class reversingStack {
    public static void main(String[] args) {
        Stack<Integer> st = new <Integer>Stack();
        st.push(10);
        st.push(20);
        st.push(30);
        st.push(40);
        st.push(50);

        System.out.println(st);
        System.out.println(reverseStack(st));
        System.out.println(st);

    }

    /**
     * Creates a new stack containing the elements of the given stack in reversed order,
     * while preserving the original stack in its original state
     *
     * <p>This function duplicates the elements of the provided stack into a new stack (`result`),
     * while ensuring that the original stack remains unaltered. It uses an auxiliary stack
     * (`temp`) to temporarily store elements during the process.</p>
     *
     * @param stack the input stack to be copied
     * @return a new stack containing the same elements as the input stack but in the revers order
     */
    public  static Stack<Integer> reverseStack(Stack<Integer> stack){
        /*
        * O(n), where n is the number of elements in the stack
        * since each loop iterates over all elements once
         */
        Stack<Integer> result = new <Integer>Stack();
        Stack<Integer> temp = new <Integer>Stack();
        while (!stack.isEmpty()){
            result.push(stack.top());
            temp.push(stack.pop());
        }
        while (!temp.isEmpty()){
            stack.push(temp.pop());
        }

        return result;
    }
}