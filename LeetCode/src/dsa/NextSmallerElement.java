package dsa;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Stack;

public class NextSmallerElement {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	static ArrayList<Integer> nextSmallerElement(ArrayList<Integer> arr, int n) {

		ArrayList<Integer> res = new ArrayList<>();
		Stack<Integer> st = new Stack();
		for (int j = n - 1; j >= 0; j--) {
			while (!st.empty() && st.peek() >= arr.get(j)) {
				st.pop();
			}

			if (st.empty()) {
				res.add(-1);
			} else {
				res.add(st.peek());
			}
			st.push(arr.get(j));
		}
		Collections.reverse(res);
		return res;
	}
}
