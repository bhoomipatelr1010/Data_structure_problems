package amazon.medium;

import java.util.HashMap;
import java.util.Map;

import javafx.util.Pair;

public class MinimumConsecutiveCardstoPickUp_2260 {

	public static void main(String[] args) {
		MinimumConsecutiveCardstoPickUp_2260 obj = new MinimumConsecutiveCardstoPickUp_2260();
		int[] cards = new int[] { 3, 4, 2, 3, 4, 0, 4, 7, 4, 4 };
		System.out.println(obj.minimumCardPickup(cards));
	}

	public int minimumCardPickup1(int[] cards) {

		int minPickUp = Integer.MAX_VALUE;

		Map<Integer, Integer> map = new HashMap<>();

		for (int i = 0; i < cards.length; i++) {

			if (map.containsKey(cards[i])) {
				int totalCard = i - map.get(cards[i]) + 1;

				minPickUp = Math.min(minPickUp, totalCard);
			}
			map.put(cards[i], i);

		}

		if (minPickUp == Integer.MAX_VALUE) {
			return -1;
		} else {
			return minPickUp;
		}
	}

	public int minimumCardPickup(int[] cards) {

		int min = Integer.MAX_VALUE, start = 0;
		boolean[] map = new boolean[1000001];

		for (int end = 0; end < cards.length; end++) {
			while (map[cards[end]]) {
				min = Math.min(min, end - start + 1);
				map[cards[start]] = false;
				start++;
			}
			map[cards[end]] = true;
		}

		return min == Integer.MAX_VALUE ? -1 : min;
	}
}
