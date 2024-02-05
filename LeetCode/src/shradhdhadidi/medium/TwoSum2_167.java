package shradhdhadidi.medium;

public class TwoSum2_167 {

	public static void main(String[] args) {
		int[] numbers = new int[] { -1, 0 };
		TwoSum2_167 obj = new TwoSum2_167();
		obj.twoSum(numbers, -1);
	}

	public int[] twoSum(int[] numbers, int target) {

		int left = 0;
		int right = numbers.length - 1;

		while (true) {

			if (numbers[left] + numbers[right] == target) {

				return new int[] { ++left, ++right };
			}
			if (numbers[left] + numbers[right] > target) {

				right--;
			} else {
				left++;
			}
		}

	}
}
