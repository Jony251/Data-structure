import unit4.collectionsLib.Stack;

public class ifStackIsInDescendingOrder {

    /**
     * Function that checking if all integers in the given stack are in descending order
     * The original stack remains unchanged after the check
     *
     * @param st the stack of integers to check
     * @return {@code true} if the stack is in descending order, {@code false} otherwise
     */
    public static boolean funcIsStackIsInDescendingOrder(Stack<Integer> st) {
        Stack<Integer> temp = new Stack<>();
        boolean res = true;
        int first;

        while (!st.isEmpty()) {
            first = st.pop();
            temp.push(first);

            if (!st.isEmpty() && first >= st.top()) {
                res = false;
            }
        }

        while (!temp.isEmpty()) {
            st.push(temp.pop());
        }
        return res;
    }

    public static void main(String[] args) {
        // Test 1
        Stack<Integer> test1 = new Stack<>();
        test1.push(10);
        test1.push(8);
        test1.push(6);
        test1.push(4);
        test1.push(2);
        System.out.println(funcIsStackIsInDescendingOrder(test1)); // true

        // Test 2
        Stack<Integer> test2 = new Stack<>();
        test2.push(8);
        test2.push(8);
        test2.push(7);
        test2.push(6);
        test2.push(5);
        System.out.println(funcIsStackIsInDescendingOrder(test2)); // false
    }
}
