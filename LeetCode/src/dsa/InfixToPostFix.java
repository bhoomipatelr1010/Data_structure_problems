package dsa;

import java.util.Stack;

public class InfixToPostFix {

	public static void main(String[] args) {

		System.out.println(infixToPostfix("a+b+c+d-e"));
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

	public static String infixToPostfix(String exp) {
		// Write your code here

		String s = new String("");
		Stack<Character> st = new Stack<>();
		for (char c : exp.toCharArray()) {
			if (Character.isLetterOrDigit(c)) {
				s += c;
			} else if (c == '(') {
				st.push(c);
			} else if (c == ')') {
				while (!st.empty() && st.peek() != '(') {
					s += st.pop();
				}
				st.pop();
			} else {

				while (!st.empty() && Prec(st.peek()) >= Prec(c)) {
					s += st.pop();
				}
				st.push(c);
			}

		}
		while (!st.empty()) {
			if (st.peek() == '(')
				return "Invalid Expression";
			s += st.pop();
		}

		return s;

	}

}
