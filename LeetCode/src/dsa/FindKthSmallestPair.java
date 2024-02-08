package dsa;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Set;

public class FindKthSmallestPair {

	public static void main(String[] args) {
		FindKthSmallestPair obj = new FindKthSmallestPair();
		int nums1[] = { 1, 2, 6 };
		int nums2[] = { 1, 4, 5 };
		System.out.println(obj.kSmallestPairs(nums1, nums2, 3));

	}

	public List<List<Integer>> kSmallestPairs(int[] nums1, int[] nums2, int k) {
		List<List<Integer>> resV = new ArrayList<>(); // Result list to store the pairs
		PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> a[0] - b[0]);
		// Priority queue to store pairs with smallest sums, sorted by the sum

		// Push the initial pairs into the priority queue

		for (int i = 0; i < nums1.length; i++) {
			pq.offer(new int[] { nums1[i] + nums2[0], 0 });
			if (k-1 == i) {
				break;
			}
		}
		for (int x : nums1) {
			pq.offer(new int[] { x + nums2[0], 0 }); // The sum and the index of the second element in nums2
		}

		// Pop the k smallest pairs from the priority queue
		while (k > 0 && !pq.isEmpty()) {
			int[] pair = pq.poll();
			int sum = pair[0]; // Get the smallest sum
			int pos = pair[1]; // Get the index of the second element in nums2

			List<Integer> currentPair = new ArrayList<>();
			currentPair.add(sum - nums2[pos]);
			currentPair.add(nums2[pos]);
			resV.add(currentPair); // Add the pair to the result list

			// If there are more elements in nums2, push the next pair into the priority
			// queue
			if (pos + 1 < nums2.length) {
				pq.offer(new int[] { sum - nums2[pos] + nums2[pos + 1], pos + 1 });
			}

			k--; // Decrement k
		}

		return resV; // Return the k smallest pairs
	}

	/*
	 * public List<List<Integer>> kSmallestPairs2(int[] nums1, int[] nums2, int k) {
	 * int m = nums1.length; int n = nums2.length;
	 * 
	 * List<List<Integer>> ans = new ArrayList<>(); Set<Pair<Integer, Integer>>
	 * visited = new HashSet<>();
	 * 
	 * PriorityQueue<int[]> minHeap = new PriorityQueue<>((a, b) -> (a[0] - b[0]));
	 * minHeap.offer(new int[] { nums1[0] + nums2[0], 0, 0 }); visited.add(new
	 * Pair<Integer, Integer>(0, 0));
	 * 
	 * while (k-- > 0 && !minHeap.isEmpty()) { int[] top = minHeap.poll(); int i =
	 * top[1]; int j = top[2];
	 * 
	 * ans.add(List.of(nums1[i], nums2[j]));
	 * 
	 * if (i + 1 < m && !visited.contains(new Pair<Integer, Integer>(i + 1, j))) {
	 * minHeap.offer(new int[] { nums1[i + 1] + nums2[j], i + 1, j });
	 * visited.add(new Pair<Integer, Integer>(i + 1, j)); }
	 * 
	 * if (j + 1 < n && !visited.contains(new Pair<Integer, Integer>(i, j + 1))) {
	 * minHeap.offer(new int[] { nums1[i] + nums2[j + 1], i, j + 1 });
	 * visited.add(new Pair<Integer, Integer>(i, j + 1)); } }
	 * 
	 * return ans; }
	 */
}
