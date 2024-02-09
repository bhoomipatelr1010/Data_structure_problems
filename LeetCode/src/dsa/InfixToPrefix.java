package dsa;

import java.util.Stack;

public class InfixToPrefix {

	public static void main(String[] args) {
		System.out.println(infixToPrefixExp("x+y*z/(w+u)"));

	}

	static int Prec(char ch) {
		switch (ch) {
		case '+':
		case '-':
			return 1;

		case '*':
		case '/':
			return 2;

		case '^':
			return 3;
		default:
			return -1;
		}
	}

	public static String infixToPrefixExp(String exp) {

		StringBuilder sb = new StringBuilder();
		Stack<Character> st = new Stack<>();

		for (int i = exp.length() - 1; i >= 0; i--) {
			char c = exp.charAt(i);
			if (Character.isLetterOrDigit(c)) {
				sb.append(c);
			} else if (c == ')') {
				st.push(c);
			} else if (c == '(') {
				while (!st.empty() && st.peek() != ')') {
					sb.append(st.pop());
				}
				st.pop();
			} else {

				while (!st.empty() && Prec(st.peek()) > Prec(c)) {

					sb.append(st.pop());

				}
				st.push(c);

			}

		}

		while (!st.empty()) {
			sb.append(st.pop());
		}
		return sb.reverse().toString();
	}
}
