package shradhdhadidi.sorting.medium;

// JAVA Code for Make all array elements
// equal with minimum cost
import java.io.*;
import java.util.Arrays;

public class GFG {

	// Utility method to compute cost, when
	// all values of array are made equal to X
	public static int computeCost(int arr[], int N, int X) {
		int cost = 0;
		for (int i = 0; i < N; i++)
			cost += Math.abs(arr[i] - X);
		return cost;
	}

	// Method to find minimum cost to make all
	// elements equal
	public static int minCostToMakeElementEqual(int arr[], int N) {
		int low, high;
		low = high = arr[0];

		// setting limits for ternary search by
		// smallest and largest element
		for (int i = 0; i < N; i++) {
			if (low > arr[i])
				low = arr[i];
			if (high < arr[i])
				high = arr[i];
		}

		/*
		 * loop until difference between low and high become less than 3, because after
		 * that mid1 and mid2 will start repeating
		 */
		while ((high - low) > 2) {
			// mid1 and mid2 are representative array
			// equal values of search space
			int mid1 = low + (high - low) / 3;
			int mid2 = high - (high - low) / 3;

			int cost1 = computeCost(arr, N, mid1);
			int cost2 = computeCost(arr, N, mid2);

			// if mid2 point gives more total cost,
			// skip third part
			if (cost1 < cost2)
				high = mid2;

			// if mid1 point gives more total cost,
			// skip first part
			else
				low = mid1;
		}

		// computeCost gets optimum cost by sending
		// average of low and high as X
		return computeCost(arr, N, (low + high) / 2);
	}

	/* Driver program to test above function */
	public static void main(String[] args) {
		int arr[] = { 1, 10, 50, 100, 101 };
		int N = arr.length;
		System.out.println(minCostToMakeElementEqual2(arr, N));
	}

	public static int minCostToMakeElementEqual2(int a[], int n) {

// If there are odd elements, we choose
// middle element

		Arrays.sort(a);
		int y;

		if (n % 2 == 1)
			y = a[n / 2];

// If there are even elements, then we
// choose the average of middle two.
		else
			y = (a[n / 2] + a[(n - 2) / 2]) / 2;

// After deciding the final value,
// find the result.
		int s = 0;

		for (int i = 0; i < n; i++)
			s += Math.abs(a[i] - y);

		return s;
	}
}
// This code is contributed by Arnav Kr. Mandal.
