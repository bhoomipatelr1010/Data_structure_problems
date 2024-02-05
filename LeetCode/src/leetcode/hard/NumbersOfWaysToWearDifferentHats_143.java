package leetcode.hard;

import java.util.ArrayList;
import java.util.List;

public class NumbersOfWaysToWearDifferentHats_143 {

	public static void main(String[] args) {
		NumbersOfWaysToWearDifferentHats_143 obj = new NumbersOfWaysToWearDifferentHats_143();

		List<Integer> caps = new ArrayList<>();
		List<List<Integer>> hats = new ArrayList<>();

		List<Integer> hat1 = new ArrayList<>();

		hat1.add(3);
		hat1.add(2);
		hat1.add(4);
		hat1.add(1);
		
		List<Integer> hat3 = new ArrayList<>();

		hat3.add(3);
		hat3.add(2);
		hat3.add(4);
		hat3.add(1);
		List<Integer> hat2 = new ArrayList<>();

		hat2.add(3);
		hat2.add(2);
		hat2.add(4);
		hat2.add(1);
		List<Integer> hat4 = new ArrayList<>();

		hat4.add(3);
		hat4.add(2);
		hat4.add(4);
		hat4.add(1);
		/*
		 * List<Integer> hat2 = new ArrayList<>(); hat2.add(4); hat2.add(3);
		 */

		/*
		 * List<Integer> hat3 = new ArrayList<>(); hat3.add(5);
		 */
		hats.add(hat1);
		hats.add(hat2);
		hats.add(hat3);
		hats.add(hat4);
		// hats.add(hat3);
		System.out.println(obj.tab(hats, 0, caps));

	}

	public int numberWays(List<List<Integer>> hats) {

		int[][] dp = new int[hats.size()][41];

		dp[0][0] = 1;

		for (int i = 0; i < dp.length; i++) {

			for (int j = 0; j < 41; j++) {

			}
		}

		return 0;

	}

	public int tab(List<List<Integer>> hats, int i, List<Integer> caps) {

		if (i == hats.size()) {
			if (caps.size() == hats.size()) {
				return 1;
			} else
				return 0;
		}

		List<Integer> availableCaps = hats.get(i);

		int ans = 0;
		for (int j = 0; j < availableCaps.size(); j++) {

			if (!caps.contains(availableCaps.get(j))) {
				caps.add(i, availableCaps.get(j));
				ans += tab(hats, i + 1, caps);
				caps.remove(i);
			}

		}

		return ans;

	}
}
