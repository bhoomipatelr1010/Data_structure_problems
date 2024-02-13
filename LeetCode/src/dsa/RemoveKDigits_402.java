package dsa;

import java.util.Stack;

public class RemoveKDigits_402 {
	public static void main(String[] args) {
		System.out.println(removeKdigits("112", 1));
	}

	public static String removeKdigits(String num, int k) {

		Stack<Character> dq = new Stack<>();

		for (char cur : num.toCharArray()) {
			while (k > 0 && !dq.isEmpty() && dq.peek() > cur) {
				dq.pop();
				k--;
			}

			dq.push(cur);
		}

		for (int i = 0; i < k; ++i) {
			dq.pop();
		}

		StringBuilder ret = new StringBuilder();
		boolean leadingZero = true;
		for (char digit : dq) {
			if (leadingZero && digit == '0')
				continue;
			leadingZero = false;
			ret.append(digit);
		}

		/* return the final string */
		if (ret.length() == 0)
			return "0";
		return ret.toString();
	}
}
