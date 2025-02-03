package Stack;
import unit4.collectionsLib.Stack;

public class BracketValidator {
    public static void main(String[] args) {

        String s = "{(a-b)+e}*2*[2-{5*6}]";
        System.out.println(isValid(s));

    }

    /**
     * Checks if a given string contains valid pairs of brackets
     * The function ensures that each opening bracket has a corresponding
     * closing bracket in the correct order
     * The function deletes stack elements
     *
     * @param s the input string containing brackets
     * @return true if the brackets are properly balanced, otherwise false
     */
    public static boolean isValid(String s) {
        Stack<Integer> st = new Stack<Integer>();

        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '(' || s.charAt(i) == '{' || s.charAt(i) == '<' || s.charAt(i) == '[')
                st.push((int) s.charAt(i));
            else if (s.charAt(i) == ')' || s.charAt(i) == '}' || s.charAt(i) == '>' || s.charAt(i) == ']') {
                if (s.charAt(i) == ')')
                    if (st.top() == s.charAt(i) - 1)
                        st.pop();
                if (st.top() == s.charAt(i) - 2)
                    st.pop();
            }
        }
        return st.isEmpty();
    }
}
