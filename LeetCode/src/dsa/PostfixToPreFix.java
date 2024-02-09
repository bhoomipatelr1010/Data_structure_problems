package dsa;

import java.util.Stack;

public class PostfixToPreFix {

	public static void main(String[] args) {
		System.out.println(postToPre("abc*+"));

	}

	public static String postToPre(String exp) {

		Stack<String> st = new Stack<>();

		String s = new String("");

		for (int i = 0; i < exp.length(); i++) {
			char c = exp.charAt(i);
			if (c == '+' || c == '-' || c == '*' || c == '/') {
				String op1 = st.pop();
				String op2 = st.pop();

				st.push(c + op2 + op1);
			} else {
				st.push(c + "");
			}
		}

		while (!st.empty()) {
			s += st.pop();
		}
		return s;
	}
}
