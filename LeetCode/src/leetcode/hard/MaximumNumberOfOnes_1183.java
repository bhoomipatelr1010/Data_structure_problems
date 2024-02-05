package leetcode.hard;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class MaximumNumberOfOnes_1183 {

	public static void main(String[] args) {
		MaximumNumberOfOnes_1183 obj = new MaximumNumberOfOnes_1183();
		System.out.println(obj.maximumNumberOfOnes(3, 3, 2, 1));
	}

	public int maximumNumberOfOnes(int width, int height, int sideLength, int maxOnes) {
		List<Integer> count = new ArrayList<>();

		for (int r = 0; r < sideLength; ++r) {
			for (int c = 0; c < sideLength; ++c) {
				count.add((1 + (width - 1 - c) / sideLength) * (1 + (height - 1 - r) / sideLength));

			}
		}

		count.sort(Comparator.reverseOrder());
		int answer = 0;
		for (int i = 0; i < maxOnes; ++i) {
			answer += count.get(i);
		}

		return answer;
	}

}
