import java.util.HashMap;

public class HouseRobberMaxMoney {
	private HashMap<Integer, Integer> memo = new HashMap<Integer, Integer>();
	private int[] nums;

	public static void main(String[] args) {
		HouseRobberMaxMoney obj = new HouseRobberMaxMoney();
		obj.rob(new int[] { 1, 2, 3, 4 });
	}

	private int dp(int i) {
		// Base cases
		if (i == 0)
			return nums[0];
		if (i == 1)
			return Math.max(nums[0], nums[1]);
		if (!memo.containsKey(i)) {
			memo.put(i, Math.max(dp(i - 1), dp(i - 2) + nums[i])); // Recurrence relation
		}
		return memo.get(i);
	}

	public int rob(int[] nums) {
		this.nums = nums;
		return dp(nums.length - 1);
	}
}
