import unit4.collectionsLib.Stack;

public class checksIfTheStringInStacksAreEqual {
    public static void main(String[] args) {
        Stack<String> st = new <String>Stack();
        st.push("qwerty");
        st.push("Jaja");
        st.push("Ucira");
        st.push("Joja");
        st.push("klads");

        Stack<String> stTrue = new <String>Stack();
        stTrue.push("qwerty");
        stTrue.push("Jaja");
        stTrue.push("Ucira");
        stTrue.push("Joja");
        stTrue.push("klads");

        Stack<String> stFalse = new <String>Stack();
        stFalse.push("qwerty");
        stFalse.push("Jaja");
        stFalse.push("Ucira");
        stFalse.push("Jo1ja");
        stFalse.push("klads");

        System.out.println(ifTheStringInStacksAreEqual(st, stTrue)+" -> expected True");
        System.out.println(ifTheStringInStacksAreEqual(st, stFalse)+ " -> expected False");

    }

    /**
     * Function that checks if the strings in two stacks are equal
     * The original stack remains unchanged after the check
     *
     * @param st1 first stack of strings
     * @param st2 second stack of strings
     * @return {@code true} if the stack are equal, {@code false} otherwise
     */
    public static boolean ifTheStringInStacksAreEqual(Stack<String> st1, Stack<String> st2) {
        Stack<String> temp1 = new <String>Stack();
        Stack<String> temp2 = new <String>Stack();
        boolean res = true;
        while (!st1.isEmpty() && !st2.isEmpty()) {
            if (!st1.top().equals(st2.top()))
                res = false;
            temp1.push(st1.pop());
            temp2.push(st2.pop());
        }
        while (!temp1.isEmpty() && !temp2.isEmpty()) {
            st1.push(temp1.pop());
            st2.push(temp2.pop());
        }
        return res;
    }

}
