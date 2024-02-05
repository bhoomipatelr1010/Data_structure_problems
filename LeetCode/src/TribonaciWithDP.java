import java.util.HashMap;

public class TribonaciWithDP {
	public static void main(String[] args) {
		TribonaciWithDP obj = new TribonaciWithDP();
		int trib = obj.tribonacci(25);
		System.out.println(trib);
	}

	private HashMap<Integer, Integer> memo = new HashMap<Integer, Integer>();

	private int dp(int n) {
		// Base cases
		if (n == 0) {
			return 0;
		}
		if (n == 1 || n == 2) {
			return 1;
		}

		if (!memo.containsKey(n)) {
			memo.put(n, dp(n - 1) + dp(n - 2) + dp(n - 3)); // Recurrence relation
		}
		return memo.get(n);
	}

	public int tribonacci(int n) {

		return dp(n);

	}
}
