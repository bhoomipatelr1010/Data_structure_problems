package dsa;
import java.util.HashMap;

public class ReachStairCase {
	private HashMap<Integer, Integer> memo = new HashMap<>();

	private int dp(int i) {
		if (i <= 2)
			return i;
		// Instead of just returning dp(i - 1) + dp(i - 2), calculate it once and then
		// store it inside a hashmap to refer to in the future
		if (!memo.containsKey(i)) {
			memo.put(i, dp(i - 1) + dp(i - 2));
		}

		return memo.get(i);
	}

	public int climbStairs(int n) {
		return dp(n);
	}

	public static void main(String[] args) {
		ReachStairCase obj = new ReachStairCase();
		obj.climbStairs(3);
	}

}
