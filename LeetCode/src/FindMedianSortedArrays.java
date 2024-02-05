
public class FindMedianSortedArrays {
	public static void main(String[] args) {
		FindMedianSortedArrays arrays = new FindMedianSortedArrays();
		int[] num1 = { 1, 2 };
		int[] num2 = { 3 };
		System.out.println(arrays.findMedianSortedArraysV(num1, num2));
	}

	public double findMedianSortedArraysV(int[] num1, int[] num2) {
		int l1 = num1.length;
		int l2 = num2.length;
		int l = l1 + l2;
		int[] num = new int[l];
		int i = 0;
		int j = 0;
		int k = 0;
		while (i <= l1 && j <= l2) {

			if (i == l1) {
				while (j < l2)
					num[k++] = num2[j++];
				break;

			} else if (j == l2) {
				while (i < l1)
					num[k++] = num1[i++];
				break;
			}

			if (num1[i] < num2[j]) {
				num[k] = num1[i];
				i++;
			} else {
				num[k] = num2[j];
				j++;
			}
			k++;

		}

		if (l % 2 == 0)
			return (float) (num[l / 2 - 1] + num[l / 2]) / 2;
		else
			return num[l / 2];

	}
}
