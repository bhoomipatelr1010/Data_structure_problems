package leetcode.medium;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.TreeMap;

public class CountNumberofRectanglesContainingEachPoint_2250 {

	public static void main(String[] args) {
		CountNumberofRectanglesContainingEachPoint_2250 obj = new CountNumberofRectanglesContainingEachPoint_2250();

		int[][] rectangles = new int[][] { { 1, 1 }, { 2, 2 }, { 4, 4 } };
		int[][] points = new int[][] { { 1, 3 }, { 2, 1 } };
		obj.countRectangles(rectangles, points);

	}

	public int[] countRectangles1(int[][] rectangles, int[][] points) {
		int[] counts = new int[points.length];

		for (int i = 0; i < points.length; i++) {

			int px = points[i][0];
			int py = points[i][1];
			for (int j = 0; j < rectangles.length; j++) {
				int rx = rectangles[j][0];
				int ry = rectangles[j][1];

				if (px >= 0 && px <= rx && py >= 0 && py <= ry) {
					counts[i]++;
				}
			}

		}

		return counts;

	}

	public int[] countRectangles(int[][] rectangles, int[][] points) {

		TreeMap<Integer, List<Integer>> map = new TreeMap<>();
		Arrays.sort(rectangles, (a, b) -> {
			if (a[0] == b[0])
				return Integer.compare(a[1], b[1]);

			return Integer.compare(a[0], b[0]);
		});

		for (int[] rect : rectangles) {
			int x = rect[0], y = rect[1];
			map.putIfAbsent(y, new ArrayList<>());
			map.get(y).add(x);
		}

		int[] res = new int[points.length];
		for (int i = 0; i < points.length; i++) {
			int x = points[i][0], y = points[i][1];
			int r = 0;

			for (List<Integer> list : map.subMap(y, Integer.MAX_VALUE).values()) {
				int idx = Collections.binarySearch(list, x);
				if (idx < 0)
					idx = -idx - 1;

				r += (list.size() - idx);
			}

			res[i] = r;

		}
		return res;
	}

	private int binarySearch(List<Integer> vals, int val) {
		int lo = 0;
		int hi = vals.size() - 1;
		int id = -1;

		while (lo <= hi) {
			int mid = lo + (hi - lo) / 2;

			if (vals.get(mid) < val) {
				lo = mid + 1;
			} else {
				id = mid;
				hi = mid - 1;
			}
		}

		if (id < 0) {
			return 0;
		}

		return vals.size() - id;
	}
}
