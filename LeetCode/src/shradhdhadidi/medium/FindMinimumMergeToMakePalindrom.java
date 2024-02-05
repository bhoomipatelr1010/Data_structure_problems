package shradhdhadidi.medium;

public class FindMinimumMergeToMakePalindrom {

	public static void main(String[] args) {
		FindMinimumMergeToMakePalindrom obj = new FindMinimumMergeToMakePalindrom();
		int arr[] = new int[] { 1, 4, 5, 9, 1 };
		System.out.println("Count of minimum operations is " + obj.makePalindrom(arr));
	}

	public int makePalindrom(int[] arr) {
		int maxMerge = 0;
		for (int i = 0; i < arr.length / 2; i++) {
			int l = 0;
			int r = arr.length - i - 1;

			if (arr[l] == arr[r]) {
				continue;
			}else if(arr[l] < arr[r]) {
				
			}
		}
		return 0;
	}

}
