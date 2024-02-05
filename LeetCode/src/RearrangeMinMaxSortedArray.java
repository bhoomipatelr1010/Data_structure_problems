
public class RearrangeMinMaxSortedArray {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int arr[] = { 1, 2, 3, 4, 5, 6, 7,9 };
		reArrangeMethod(arr);
	}

	public static void reArrangeMethod(int arr[]) {

		int maxIdex = arr.length - 1;
		int i = 0;
		while (i < maxIdex) {

			int temp = arr[i];

			if (i % 2 == 0) {
				arr[i] = arr[maxIdex];
				arr[maxIdex] = temp;
				maxIdex--;
			} else {
				arr[i] = arr[arr.length - 1];
				arr[arr.length - 1] = temp;
			}
			i++;

		}

		System.out.println(arr);
	}

}
