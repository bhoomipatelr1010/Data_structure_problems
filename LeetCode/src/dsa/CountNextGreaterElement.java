package dsa;

public class CountNextGreaterElement {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		int nums[] = new int[] { 44, 449, 449, 483, 453, 458, 53, 101, 142, 443, 13, 130, 474, 59, 316, 213, 455, 136,
				50, 437, 128, 59, 366, 214, 449, 59, 404, 52, 368, 409, 139, 414, 483, 149, 393, 132, 469, 494, 216,
				146, 390, 48, 65, 422, 494, 426, 180, 397, 49, 224 };

		int[] query = new int[] { 49, 7, 10, 2, 27, 27, 21, 6, 12, 46, 44, 49, 2, 42, 43, 25, 7, 17, 4, 27, 35, 37, 17,
				8, 4, 29, 37, 30, 32, 16, 22, 34, 16, 8, 23, 6, 48, 20, 23, 37, 45 };
		countGreaterUsingMergeSort(nums, query);
	}

	public static int[] countGreater(int[] nums, int[] query) {

		int Q = query.length;
		int N = nums.length;
		int[] res = new int[Q];
		for (int i = 0; i < Q; i++) {
			int count = 0;
			for (int j = query[i] + 1; j < N; j++) {
				if (nums[j] > nums[query[i]]) {
					count++;
				}
			}
			res[i] = count;
		}
		return res;
	}

	// Using count inversion way to solve this problem
	public static int[] countGreaterUsingMergeSort(int[] nums, int[] query) {

		Pair<Integer, Integer>[] pairs = new Pair[nums.length];

		for (int i = 0; i < nums.length; i++) {
			pairs[i] = new Pair<Integer, Integer>(nums[i], i);
		}

		int[] ans = new int[nums.length];
		mergeSort(pairs, ans, nums.length - 1, 0);

		int[] res = new int[query.length];

		for (int i = 0; i < res.length; i++) {
			res[i] = ans[query[i]];
		}
		return res;
	}

	private static void mergeSort(Pair<Integer, Integer>[] pairs, int[] ans, int high, int low) {

		int mid;

		if (low < high) {

			mid = (high + low) / 2;
			mergeSort(pairs, ans, mid, low);
			mergeSort(pairs, ans, high, mid + 1);
			merge(pairs, ans, high, low, mid);
		}
	}

	private static void merge(Pair<Integer, Integer>[] pairs, int[] ans, int high, int low, int mid) {

		Pair<Integer, Integer>[] temp = new Pair[high - low + 1];
		int left = low;
		int right = mid + 1;
		int i = 0;
		while (left <= mid && right <= high) {
			if (pairs[left].first < pairs[right].first) {
				temp[i] = pairs[left];
				ans[pairs[left].second] += high - right + 1;
				left++;
			} else {
				temp[i] = pairs[right];
				right++;
			}
			i++;
		}

		while (left <= mid) {
			temp[i] = pairs[left];
			left++;
			i++;

		}

		while (right <= high) {
			temp[i] = pairs[right];
			right++;
			i++;

		}

		for (int k = low; k <= high; k++) {
			pairs[k] = temp[k - low];
		}
	}

	static class Pair<K, V> {
		K first;
		V second;

		Pair(K first, V second) {
			this.first = first;
			this.second = second;
		}

		@Override
		public String toString() {
			return first + " " + second;
		}
	}
}
