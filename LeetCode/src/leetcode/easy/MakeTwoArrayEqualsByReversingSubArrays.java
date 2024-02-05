package leetcode.easy;

public class MakeTwoArrayEqualsByReversingSubArrays {

	public static void main(String[] args) {
		MakeTwoArrayEqualsByReversingSubArrays obj = new MakeTwoArrayEqualsByReversingSubArrays();
		int[] target = new int[] { 7 };
		int[] arr = new int[] { 7 };

		System.out.println(obj.canBeEqual(target, arr));

	}

	public boolean canBeEqual(int[] target, int[] arr) {

		int i = 0;
		int j = 0;
		while (i < target.length && j < arr.length) {
			if (target[i] == arr[j]) {
				if (i == j) {
					i++;
					j++;
				} else {
					reverseArray(i, j, arr);
					i++;
					j = i;
				}
			} else {
				j++;
			}
		}

		if (i == target.length) {
			return true;
		} else
			return false;

	}

	void reverseArray(int i, int j, int[] arr) {
		int mid = (j - i) / 2;
		for (int k = 0; k <= mid; k++) {

			int temp = arr[i + k];
			arr[i + k] = arr[j - k];
			arr[j - k] = temp;

		}
	}
}
