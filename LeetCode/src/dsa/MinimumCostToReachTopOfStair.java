package dsa;
import java.util.HashMap;

public class MinimumCostToReachTopOfStair {
	public static void main(String[] args) {
		MinimumCostToReachTopOfStair obj = new MinimumCostToReachTopOfStair();
		obj.minCostClimbingStairs(new int[] { 10, 15, 20 });
	}

	private HashMap<Integer, Integer> memo = new HashMap<Integer, Integer>();
	private int[] cost;

	private int dp(int i) {
		// Base cases
		if (i < 2) {
			return 0;
		}

		if (!memo.containsKey(i)) {
			memo.put(i, Math.min(cost[i - 1] + dp(i - 1), cost[i - 2] + dp(i - 2))); // Recurrence relation
		}
		return memo.get(i);
	}

	public void minCostClimbingStairs(int[] cost) {
		this.cost = cost;
		System.out.println(dp(cost.length));

	}
}
