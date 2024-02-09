package dsa;

import java.util.Stack;

public class PrefixToPostfix {

	public static void main(String[] args) {
		System.out.println(preToPost("/A+BC"));

	}

	public static String preToPost(String exp) {

		Stack<String> st = new Stack<>();

		String s = new String("");

		for (int i = exp.length() - 1; i >= 0; i--) {
			char c = exp.charAt(i);
			if (c == '+' || c == '-' || c == '*' || c == '/') {
				String op1 = st.pop();
				String op2 = st.pop();

				st.push(op1 + op2 + c);
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
