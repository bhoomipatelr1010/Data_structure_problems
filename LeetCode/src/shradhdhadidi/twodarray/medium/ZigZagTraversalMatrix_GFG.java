package shradhdhadidi.twodarray.medium;

public class ZigZagTraversalMatrix_GFG {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int M[][] = { { 1, 2, 3, 4 }, { 5, 6, 7, 8 }, { 9, 10, 11, 12 }, { 13, 14, 15, 16 }, { 17, 18, 19, 20 } };
		mySolution(M);
	}

	static void mySolution(int[][] arr) {

		int n = arr.length;
		int m = arr[0].length;

		int i = 0, j = 0;

		for (int line = 1; line < n + m; line++) {

			int row = i;
			int col = j;

			while (row >= 0 && col < m) {
				System.out.print(arr[row][col] + " ");
				row--;
				col++;
			}
			if (i < n - 1) {
				i++;
			} else {
				j++;
			}

			System.out.println("");
		}
	}
}
