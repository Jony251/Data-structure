import unit4.collectionsLib.Stack;

public class removesLastStackElementAndReturnIt { public static void main(String[] args) {
    Stack<Integer> st = new <Integer>Stack();
    st.push(1);
    st.push(2);
    st.push(3);
    st.push(4);
    st.push(5);

    System.out.println(st);
    System.out.println(lastAndRemove(st));
    System.out.println(st);

}


    /**
     * Function that removes last element from the stack of integers
     * and returning it
     *
     * @param stack stack of integers
     * @return {@code int} sorted stack with the new number inserted
     */
public static int lastAndRemove(Stack<Integer> stack){
    Stack<Integer> tempSt = new <Integer>Stack();
    int res;
    while (!stack.isEmpty())
        tempSt.push(stack.pop());
    res=tempSt.pop();
    while (!tempSt.isEmpty())
        stack.push(tempSt.pop());
    return res;
}
}
