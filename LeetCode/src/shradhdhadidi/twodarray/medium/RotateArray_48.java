package shradhdhadidi.twodarray.medium;

public class RotateArray_48 {

	public static void main(String[] args) {
		RotateArray_48 obj = new RotateArray_48();
		int[][] matrix = new int[][] { { 1, -2, 3 }, { 4, 5, 6 }, { 7, 8, 9 } };
		obj.mySolution(matrix);
	}

	public void mySolution(int[][] matrix) {

		int n = matrix.length;
		for (int row = 0; row < n / 2; row++) {
			for (int col = row; col < n - row - 1; col++) {
				swap(matrix[row][col], matrix[col][n - 1 - row]);
				swap(matrix[row][col], matrix[n - 1 - row][n - 1 - col]);
				swap(matrix[row][col], matrix[n - 1 - col][row]);
			}
		}
		System.out.println("hey ruk");
	}

	private void swap(int i, int j) {
		int temp = j;
		j = i;
		i = j;
	}
}
