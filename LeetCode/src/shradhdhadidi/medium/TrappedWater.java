package shradhdhadidi.medium;

import java.util.Stack;

public class TrappedWater {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] height = new int[] { 0, 3, 2, 1, 4, 2, 1, 2 };
		int ans = 0, current = 0;
		Stack<Integer> st = new Stack<>();
		while (current < height.length) {
			while (!st.empty() && height[current] > height[st.peek()]) {
				int top = st.peek();
				st.pop();
				if (st.empty())
					break;
				int distance = current - st.peek() - 1;
				int bounded_height = Math.min(height[current], height[st.peek()]) - height[top];
				ans += distance * bounded_height;
			}
			st.push(current++);
		}
		System.out.println(ans);
	}

}
