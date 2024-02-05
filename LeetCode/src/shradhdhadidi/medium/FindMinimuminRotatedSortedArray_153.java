package shradhdhadidi.medium;

public class FindMinimuminRotatedSortedArray_153 {

	public int solution(int[] nums) {

		return findMin(nums, 0, nums.length - 1);
	}

	public int findMin(int[] nums, int startIndex, int endIndex) {

		if (startIndex >= endIndex) {
			return nums[startIndex];
		}
		if (nums[endIndex] > nums[startIndex]) {
			return nums[startIndex];
		}
		int mid = (endIndex + startIndex) / 2;

		if (nums[mid] > nums[mid + 1]) {
			return nums[mid + 1];
		}

		if (nums[mid - 1] > nums[mid]) {
			return nums[mid];
		}

		if (nums[startIndex] > nums[mid]) {
			return findMin(nums, startIndex, mid);

		} else {
			return findMin(nums, mid + 1, endIndex);
		}

	}

	public static void main(String[] args) {
		FindMinimuminRotatedSortedArray_153 obj = new FindMinimuminRotatedSortedArray_153();
		int[] nums = new int[] { 3, 1, 2 };
		int min = obj.solution(nums);
		System.out.println(min);

	}

}
