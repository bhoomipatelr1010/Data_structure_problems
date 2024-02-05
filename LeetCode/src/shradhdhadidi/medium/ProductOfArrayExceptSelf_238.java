package shradhdhadidi.medium;

public class ProductOfArrayExceptSelf_238 {

	public static void main(String[] args) {
		int[] nums = new int[] { 1, 2, 3, 4 };
		solution(nums);
	}

	public static int[] solution(int[] nums) {

		int[] output = new int[nums.length];

		output[0] = 1;
		for (int i = 1; i < nums.length; i++) {
			output[i] = output[i - 1] * nums[i - 1];
		}
		int right = 1;
		for (int j = nums.length - 2; j >= 0; j--) {
			right = right * nums[j + 1];
			output[j] = output[j] * right;
		}

		return output;
	}

}
