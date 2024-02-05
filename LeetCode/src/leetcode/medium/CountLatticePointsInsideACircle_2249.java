package leetcode.medium;

import java.util.HashSet;
import java.util.Set;

import javafx.util.Pair;

public class CountLatticePointsInsideACircle_2249 {

	public static void main(String[] args) {
		CountLatticePointsInsideACircle_2249 obj = new CountLatticePointsInsideACircle_2249();
		int[][] circles = new int[][] { { 10, 7, 3 }, { 5, 9, 5 }, { 10, 4, 2 }, { 3, 8, 2 }, { 2, 3, 1 }, { 2, 10, 1 },
				{ 10, 9, 8 }, { 6, 6, 3 }, { 8, 6, 3 }, { 9, 8, 7 }, { 9, 4, 3 }, { 7, 4, 1 }, { 4, 6, 2 }, { 4, 3, 2 },
				{ 8, 3, 3 } };
		obj.countLatticePoints(circles);
	}

	public int countLatticePoints1(int[][] circles) {

		Set<Pair<Integer, Integer>> points = new HashSet<>();

		for (int i = 0; i < circles.length; i++) {
			int x = circles[i][0];
			int y = circles[i][1];
			int r = circles[i][2];

			points.add(new Pair<Integer, Integer>(x, y));
			// consider all border points
			points.add(new Pair<Integer, Integer>(x, y + r));
			points.add(new Pair<Integer, Integer>(x, y - r));
			points.add(new Pair<Integer, Integer>(x - r, y));
			points.add(new Pair<Integer, Integer>(x + r, y));

			// points inside circle
			// decreament x point till you reach to border
			int up = r;
			while (up > 0) {

				for (int j = 1; j < r - 1; j++) {
					points.add(new Pair<Integer, Integer>(x, y + j));
					points.add(new Pair<Integer, Integer>(x, y - j));

				}

				for (int k = x - 1; k > x - r; k--) {
					points.add(new Pair<Integer, Integer>(k, y));

					for (int j = 1; j <= up; j++) {
						points.add(new Pair<Integer, Integer>(k, y + j));
						points.add(new Pair<Integer, Integer>(k, y - j));

					}
				}

				for (int k = x + 1; k < x + r; k++) {
					points.add(new Pair<Integer, Integer>(k, y));

					for (int j = 1; j < r; j++) {
						points.add(new Pair<Integer, Integer>(k, y + j));
						points.add(new Pair<Integer, Integer>(k, y - j));
					}
				}
				up--;
			}

		}

		System.out.println(points.size());
		return points.size();
	}

	public int countLatticePoints(int[][] circles) {
		boolean[][] plane = new boolean[201][201];
		int count = 0;
		for (int[] circle : circles) {
			int x = circle[0];
			int y = circle[1];
			int r = circle[2];
			int leftX = x - r;
			int leftY = y - r;
			int rightX = x + r;
			int rightY = r + y;

			for (int i = leftX; i <= rightX; i++) {
				for (int j = leftY; j <= rightY; j++) {
					if (!plane[i][j]) {
						if ((i - x) * (i - x) + (j - y) * (j - y) <= r * r) {
							plane[i][j] = true;
							count++;
						}
					}
				}
			}
		}
		System.out.println(count);
		return count;

	}

	public boolean inCircle(int x, int y, int[] circle) {
		int xCenter = circle[0];
		int yCenter = circle[1];
		int r = circle[2];

		return dist((double) x, (double) y, (double) xCenter, (double) yCenter) <= r * r;
	}

	public double dist(double x1, double y1, double x2, double y2) {
		return (x1 - x2) * (x1 - x2) + (y1 - y2) * (y1 - y2);
	}
}
