package shradhdhadidi.medium;

import java.util.Collections;
import java.util.PriorityQueue;

public class KthSmallestElement {

	public static void main(String[] args) {
		KthSmallestElement element = new KthSmallestElement();
		int[] arr = new int[] { 11, 15, 26, 38, 9, 10 };
		System.out.println(element.kthSmallest(arr, 0, 0, 4));

	}

	public int kthSmallest(int[] arr, int l, int r, int k) {

		PriorityQueue<Integer> heap = new PriorityQueue<>(Collections.reverseOrder());

		for (int num : arr) {
			heap.add(num);
			if (heap.size() > k) {
				heap.remove();
			}
		}
		return heap.peek();

	}
}
