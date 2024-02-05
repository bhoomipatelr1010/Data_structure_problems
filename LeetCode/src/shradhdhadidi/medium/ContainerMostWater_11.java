package shradhdhadidi.medium;

public class ContainerMostWater_11 {

	public static void main(String[] args) {
		int[] numbers = new int[] { 1, 8, 6, 2, 5, 4, 8, 3, 7 };
		ContainerMostWater_11 obj = new ContainerMostWater_11();
		obj.maxArea(numbers);

	}

	public int maxArea(int[] height) {

		int left = 0;
		int right = height.length - 1;
		int maxArea = 0;
		while (left < right) {

			int d = right - left;
			int currentArea = d * Math.min(height[left], height[right]);
			if (height[left] < height[right]) {
				left++;
			} else {
				right--;
			}

			if (currentArea > maxArea) {
				maxArea = currentArea;
			}
		}
		System.out.println(maxArea);
		return maxArea;
	}

}
