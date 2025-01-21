import unit4.collectionsLib.Stack;

public class moveTheFirstStackElementToEnd {
    public static void main(String[] args) {
        Stack<Integer> st = new <Integer>Stack();
        st.push(10);
        st.push(20);
        st.push(30);
        st.push(40);
        st.push(50);

        System.out.println(st);
        System.out.println(moveTheFirstToEnd(st));

    }
        /**
         * Function that moves first element in stack to the end of the stack
         * The original stack remains unchanged after the check
         *
         * @param st the stack of integers
         * @return {@code Stack<Integer>} changed stack
         */
        public static Stack<Integer> moveTheFirstToEnd (Stack < Integer > st) {
            Stack<Integer> res = new <Integer>Stack();
            Stack<Integer> temp = new <Integer>Stack();
            if (!st.isEmpty())
                res.push(st.pop());

            while (!st.isEmpty()) {
                temp.push(st.pop());
            }
            while (!temp.isEmpty())
                res.push(temp.pop());
            return res;
        }

    }
