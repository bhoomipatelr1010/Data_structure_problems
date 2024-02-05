package shradhdhadidi.twodarray.medium;

import java.util.ArrayList;
import java.util.List;

public class FindCommonElementFromAllRows_GFG {

	public static void main(String[] args) {
		int[][] matrix = new int[][] { { 1, 2, 3, 4, 5 }, { 2, 4, 5, 8, 10 }, { 3, 5, 7, 9, 11 }, { 1, 3, 5, 7, 9 }, };
		FindCommonElementFromAllRows_GFG obj = new FindCommonElementFromAllRows_GFG();
		System.out.println(obj.mySolution(matrix));
	}

	public int mySolution(int[][] matrix) {
		int m = matrix.length;
		int n = matrix[0].length;
		if (m < 2) {
			return -1;
		}

		int first = matrix[0][0];
		int last = matrix[0][n - 1];

		for (int i = 1; i < m; i++) {
			first = Math.max(first, matrix[i][0]);
			last = Math.min(last, matrix[i][n - 1]);
		}

		if (first == last) {
			return first;
		}

		List<Integer> commonSet = new ArrayList<>();

		int x1 = findLowerBoundary(matrix[0], first, 0, n - 1);
		int y1 = findUpperBoundary(matrix[0], last, 0, n - 1);

		if (x1 >= y1) {
			commonSet.add(matrix[0][y1]);
		} else {
			for (int j = x1; j <= y1; j++) {
				commonSet.add(matrix[0][j]);
			}
		}

		for (int i = 1; i < m; i++) {
			int x = findLowerBoundary(matrix[i], first, 0, n - 1);
			int y = findUpperBoundary(matrix[i], last, 0, n - 1);

			if (x >= y) {
				if (!commonSet.contains(matrix[i][y])) {
					commonSet.remove(matrix[i][y]);
				}

			} else {
				for (int j = x; j <= y; j++) {
					if (!commonSet.contains(matrix[i][j])) {
						commonSet.remove(matrix[i][j]);
					}
				}
			}

		}

		if (!commonSet.isEmpty() && commonSet.size() == 1) {
			return commonSet.get(0);
		}
		return -1;
	}

	public int findLowerBoundary(int[] arr, int first, int x, int y) {

		if (x >= y) {
			return y;
		}
		int mid = (x + y) / 2;

		if (mid == 0 || mid == arr.length - 1) {
			return mid;
		}

		if (arr[mid] == first) {
			return mid;
		} else if (arr[mid] > first) {
			return findLowerBoundary(arr, first, x, mid - 1);
		} else {
			return findLowerBoundary(arr, first, mid + 1, y);
		}
	}

	public int findUpperBoundary(int[] arr, int last, int x, int y) {

		if (x >= y) {
			return y;
		}
		int mid = (x + y) / 2;
		if (mid == 0 || mid == arr.length - 1) {
			return mid;
		}
		if (arr[mid] == last) {
			return mid;
		} else if (arr[mid] < last) {
			return findUpperBoundary(arr, last, mid + 1, y);
		} else {
			return findUpperBoundary(arr, last, x, mid - 1);
		}
	}
}
