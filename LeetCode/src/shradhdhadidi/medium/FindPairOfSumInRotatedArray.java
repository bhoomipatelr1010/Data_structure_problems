package shradhdhadidi.medium;

import java.util.HashSet;

public class FindPairOfSumInRotatedArray {

	public static void main(String[] args) {

		FindPairOfSumInRotatedArray obj = new FindPairOfSumInRotatedArray();
		int[] arr = new int[] { 11, 15, 26, 38, 9, 10 };
		System.out.println(obj.findPair2(arr, 37));

	}

	public boolean findPair(int[] arr, int x) {

		HashSet<Integer> set = new HashSet<>();

		for (int i = 0; i < arr.length; i++) {
			int remaining = x - arr[i];
			if (set.contains(remaining)) {
				return true;
			} else {
				set.add(arr[i]);
			}

		}
		return false;
	}

	public boolean findPair2(int[] arr, int x) {
		int n = arr.length;
		int i;
		for (i = 0; i < n - 1; i++)
			if (arr[i] > arr[i + 1])
				break;

		int l = (i + 1) % n;
		int r = i;
		while (l != r) {

			if (arr[l] + arr[r] == x)
				return true;

			if (arr[l] + arr[r] < x)
				l = (l + 1) % n;

			else
				r = (n + r - 1) % n;
		}

		return false;
	}

}
