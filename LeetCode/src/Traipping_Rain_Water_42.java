
public class Traipping_Rain_Water_42 {

	public static void main(String[] args) {
		int arr[] = { 4, 2, 3 };

		System.out.println(trap(arr));
	}

	public static int trap(int[] height) {

		int n = height.length;
		int r = n - 1;
		int l = 0;

		int lMx = 0;
		int rMx = 0;
		int tRain = 0;

		while (l < r) {
			if (height[l] <= height[r]) {
				if (height[l] > height[lMx]) {
					lMx = height[l];
				} else {
					tRain += lMx - height[l];
				}
				l++;
			} else {
				if (height[r] > rMx) {
					rMx = height[r];
				} else {
					tRain += rMx - height[r];
				}
				r--;
			}

		}

		return tRain;

	}
}
