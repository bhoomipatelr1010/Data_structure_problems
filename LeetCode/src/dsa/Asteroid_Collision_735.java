package dsa;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Stack;

public class Asteroid_Collision_735 {

	public static void main(String[] args) {
		int nums[] = new int[] { 9, 4, 9, -1, -7, -6, -6, 5, 6, 0 };
		System.out.println(asteroidCollision(nums));
	}

	public static List<Integer> asteroidCollision(int[] asteroids) {

		Stack<Integer> st = new Stack<>();

		for (int i = 0; i < asteroids.length; i++) {

			boolean flag = true;

			while (!st.empty() && asteroids[i] < 0 && st.peek() > 0) {

				if (Math.abs(asteroids[i]) > Math.abs(st.peek())) {
					st.pop();
					continue;

				}

				if (Math.abs(asteroids[i]) == Math.abs(st.peek())) {
					st.pop();

				}
				flag = false;
				break;

			}

			if (flag)
				st.push(asteroids[i]);

		}

		List<Integer> ans = new ArrayList<>();
		while (!st.empty()) {
			ans.add(st.pop());
		}

		Collections.reverse(ans);
		return ans;

	}

}
