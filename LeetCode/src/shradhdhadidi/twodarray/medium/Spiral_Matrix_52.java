package shradhdhadidi.twodarray.medium;

import java.util.ArrayList;
import java.util.List;

public class Spiral_Matrix_52 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Spiral_Matrix_52 obj = new Spiral_Matrix_52();
		int M[][] = { { 3 }, { 4 } };
		obj.mySolution(M);
	}

	public void mySolution(int[][] matrix) {

		int n = matrix.length;
		int m = matrix[0].length;

		List<Integer> res = new ArrayList<>();

		int down = n - 1;
		int right = m - 1;
		int left = 0;
		int up = 0;

		while (res.size() < n * m) {

		

			for (int col = left; col <= right; col++) {
				res.add(matrix[up][col]);
			}

			for (int row = up + 1; row <= down; row++) {
				res.add(matrix[row][right]);
			}
			if (up != down) {
				for (int col = right - 1; col >= left; col--) {
					res.add(matrix[down][col]);
				}
			}
			if (left != right) {
				for (int row = down - 1; row > up; row--) {
					res.add(matrix[row][left]);
				}
			}
			left++;
			right--;
			up++;
			down--;
		}
		System.err.println(res);

	}

}
