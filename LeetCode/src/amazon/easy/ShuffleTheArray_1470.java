package amazon.easy;

public class ShuffleTheArray_1470 {

	public static void main(String[] args) {
		int[] nums = new int[] { 4, 9, 8, 9, 1, 9, 1, 7, 1, 8, 6, 6, 2, 10, 4, 3, 9, 2, 6, 9 };
		ShuffleTheArray_1470 obj = new ShuffleTheArray_1470();
		obj.findSolution(nums, nums.length / 2);

	}

	public int[] findSolution(int[] nums, int n) {

		int j = n;
		int i = 1;

		while (i < n && j < nums.length - 1) {

			nums[i] = nums[i] * 10000 + nums[j];
			i++;
			j++;
		}
		i = n - 1;
		j = j - 1;
		while (i > 0) {
			nums[j] = nums[i] / 10000;
			nums[j - 1] = nums[i] % 10000;
			j = j - 2;
			i--;
		}
		return nums;
	}

	
}
