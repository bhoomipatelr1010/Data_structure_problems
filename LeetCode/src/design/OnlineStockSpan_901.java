package design;

import java.util.Stack;

public class OnlineStockSpan_901 {

	Stack<int[]> stack = new Stack<>();

	public static void main(String[] args) {
		OnlineStockSpan_901 obj = new OnlineStockSpan_901();
		obj.next(100);
		obj.next(80);
		obj.next(60);
		obj.next(70);
		obj.next(60);
		obj.next(75);
		obj.next(85);

	}

	public int next(int price) {

		int ans = 1;
		while (!stack.isEmpty() && stack.peek()[0] <= price) {
			ans += stack.pop()[1];
		}

		stack.push(new int[] { price, ans });
		System.out.println(ans);
		return ans;
	}
}
