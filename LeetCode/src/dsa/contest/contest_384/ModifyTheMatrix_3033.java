package dsa.contest.contest_384;

public class ModifyTheMatrix_3033 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	public int[][] modifiedMatrix(int[][] matrix) {

		int n = matrix.length;
		int m = matrix[0].length;
		for (int j = 0; j < m; j++) {
			int colMax = Integer.MIN_VALUE;
			for (int i = 0; i < n; i++) {
				colMax = Math.max(colMax, matrix[i][j]);
			}
			for (int i = 0; i < n; i++) {
				if (matrix[i][j] == -1) {
					matrix[i][j] = colMax;
				}
			}

		}
		return matrix;
	}
}
