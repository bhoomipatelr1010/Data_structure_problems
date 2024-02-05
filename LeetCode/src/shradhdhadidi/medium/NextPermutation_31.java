package shradhdhadidi.medium;

public class NextPermutation_31 {

	public static void main(String[] args) {
		int[] nums = new int[] { 3, 2, 1 };
		NextPermutation_31 obj = new NextPermutation_31();

		obj.nextPerm(nums);
		System.out.println(nums);

	}

	public void nextPerm(int[] nums) {
		int i = nums.length - 2;
		while (i >= 0 && nums[i + 1] <= nums[i]) {
			i--;
		}
		if (i >= 0) {
			int j = nums.length - 1;
			while (nums[j] <= nums[i]) {
				j--;
			}
			swap(nums, i, j);
		}
		reverse(nums, i + 1);
		
	}

	private void reverse(int[] nums, int start) {
		int i = start, j = nums.length - 1;
		while (i < j) {
			swap(nums, i, j);
			i++;
			j--;
		}
	}

	private void swap(int[] nums, int i, int j) {
		int temp = nums[i];
		nums[i] = nums[j];
		nums[j] = temp;
	}

}
