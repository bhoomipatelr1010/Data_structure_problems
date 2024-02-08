package shradhdhadidi.easy;

import java.util.HashMap;
import java.util.Stack;

public class StringValidParentheses_20 {
	private HashMap<Character, Character> mappings;

	public static void main(String[] args) {

	}

	public StringValidParentheses_20() {
		this.mappings = new HashMap<Character, Character>();
		this.mappings.put(')', '(');
		this.mappings.put('}', '{');
		this.mappings.put(']', '[');
	}

	public boolean isValid(String s) {
		Stack<Character> stack = new Stack<Character>();

		for (int i = 0; i < s.length(); i++) {
			char c = s.charAt(i);

			if (mappings.containsKey(c)) {
				if (stack.empty()) {
					return false;
				} else {
					char topElement = stack.pop();
					if (topElement != this.mappings.get(c)) {
						return false;
					}
				}
			} else {
				stack.push(c);
			}
		}
		return stack.isEmpty();
	}
}
