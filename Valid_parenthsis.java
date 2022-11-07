import java.util.Scanner;
import java.util.Stack;

public class Valid_parenthsis {
    public static void main(String[] args) {
        Scanner hm = new Scanner(System.in);
        String str = hm.next();
        solve(str.toCharArray());
        hm.close();
    }

    static boolean solve(char[] ch) {
        Stack<Character> st = new Stack<>();
        for (int i = 0; i < ch.length; i++) {
            if (ch[i] == '(' || ch[i] == '{' || ch[i] == '[') {
                st.push(ch[i]);
                continue;
            } else if (st.isEmpty()) {

                return false;
            }

            char top = st.pop();
            if (top == '(' && ch[i] != ')') {
                return false;
            } else if (top == '{' && ch[i] != '}') {

                return false;

            } else if (top == '[' && ch[i] != ']') {
                return false;
            }

        }
        return st.isEmpty();

    }
}
