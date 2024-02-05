package leetcode.hard;

import java.util.ArrayList;
import java.util.List;

public class HackerRank_remo_upwork_binary {

	public static void main(String[] args) {
		HackerRank_remo_upwork_binary obj = new HackerRank_remo_upwork_binary();

		List<Integer> files = new ArrayList<>();
		files.add(7);
		files.add(4);
		files.add(3);
		files.add(5);

		List<Integer> binary = new ArrayList<>();
		binary.add(1);
		binary.add(0);
		binary.add(0);
		binary.add(0);

		obj.solution(files, binary, 1);

	}

	public void solution(List<Integer> files, List<Integer> binary, int k) {

		int decryptedSum = 0;
		int n = files.size();
		for (int i = 0; i < n; i++) {
			if (binary.get(i) == 1) {
				decryptedSum += files.get(i);
			}
		}
		int maxProfit = Integer.MIN_VALUE;
		for (int i = 0; i < n; i++) {
			int currentSum = 0;

			for (int j = 0; j < k && i + j < n; j++) {
				if (binary.get(i + j) == 0) {
					currentSum += files.get(i);
				}
			}

			maxProfit = Math.max(maxProfit, decryptedSum + currentSum);
		}
		System.out.println(maxProfit);
	}

}
