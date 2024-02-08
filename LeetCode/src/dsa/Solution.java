package dsa;
class Solution {

	public static void main(String[] args) {
		Solution obj = new Solution();
		int nums[] = { 1, 2, 5, 6, 1, 4, 3 };
		int removeQueries[] = { 0, 5, 3, 2, 4, 6, 1 };
		System.out.println(obj.maximumSegmentSum(nums, removeQueries));
	}

	public long[] maximumSegmentSum(int[] nums, int[] removeQueries) {
		// Compute the prefix sum for the input array
		long[] prefixSum = new long[nums.length + 1];
		for (int i = 0; i < nums.length; i++) {
			prefixSum[i + 1] = prefixSum[i] + nums[i];
		}

		long currentMax = 0;
		int[] leftEnd = new int[nums.length];
		int[] rightEnd = new int[nums.length];
		long[] ans = new long[removeQueries.length];
		// We can eliminate this extra space by modifying the input array and marking
		// visited elements as -1, but it's not a good practise
		boolean[] isOccupied = new boolean[nums.length];

		// We start processing deletions from right to left i.e. from the last deletion
		// to first deletion
		for (int i = removeQueries.length - 1; i >= 0; i--) {
			ans[i] = currentMax;

			int index = removeQueries[i];
			isOccupied[index] = true;

			// Inspiration from Union Find - find left end and right end
			rightEnd[index] = index;
			if (index < nums.length - 1 && isOccupied[index + 1] == true) {
				rightEnd[index] = rightEnd[index + 1];
			}

			leftEnd[index] = index;
			if (index > 0 && isOccupied[index - 1] == true) {
				leftEnd[index] = leftEnd[index - 1];
			}

			// Get current segment sum using left end and right end of current segment on
			// the prefix sum array
			int leftIndex = leftEnd[index];
			int rightIndex = rightEnd[index];
			long currSegmentSum = prefixSum[rightIndex + 1] - prefixSum[leftIndex];
			currentMax = Math.max(currentMax, currSegmentSum);

			// Also update the right end index for the left end value and the left end index
			// for the right end value
			rightEnd[leftIndex] = rightIndex;
			leftEnd[rightIndex] = leftIndex;
		}
		return ans;
	}
}