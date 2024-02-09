package dsa;

import java.util.Stack;

public class PostfixToInfix {

	public static void main(String[] args) {
		System.out.println(postToInfix("ABC/DA-*+"));

	}

	public static String postToInfix(String postfix) {

		Stack<String> st = new Stack<>();

		String s = "";

		for (int i = 0; i < postfix.length(); i++) {
			char c = postfix.charAt(i);
			if (c == '+' || c == '-' || c == '*' || c == '/') {
				String op1 = st.pop();
				String op2 = st.pop();

				st.push('(' + op2 + c + op1 + ')');
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
