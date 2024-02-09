package dsa;

public class CountNextGreaterElement {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		int nums[] = new int[] { 44, 449, 449, 483, 453, 458, 53, 101, 142, 443, 13, 130, 474, 59, 316, 213, 455, 136,
				50, 437, 128, 59, 366, 214, 449, 59, 404, 52, 368, 409, 139, 414, 483, 149, 393, 132, 469, 494, 216,
				146, 390, 48, 65, 422, 494, 426, 180, 397, 49, 224 };

		int[] query = new int[] { 49, 7, 10, 2, 27, 27, 21, 6, 12, 46, 44, 49, 2, 42, 43, 25, 7, 17, 4, 27, 35, 37, 17,
				8, 4, 29, 37, 30, 32, 16, 22, 34, 16, 8, 23, 6, 48, 20, 23, 37, 45 };
		countGreater(nums, query);
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

}
