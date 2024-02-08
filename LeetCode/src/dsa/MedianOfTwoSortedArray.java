package dsa;

public class MedianOfTwoSortedArray {

	public static void main(String[] args) {
		MedianOfTwoSortedArray obj = new MedianOfTwoSortedArray();
		int nums1[] = { 1, 2, 7, 9, 10 };
		int nums2[] = { 3, 4, 6, 11, 12, 13 };
		System.out.println(obj.findMedianSortedArraysWithLogNComplexity(nums1, nums2));

	}

	public double findMedianSortedArraysWithNComplexity1(int[] num1, int[] num2) {
		double median = 0.0;
		int n = num1.length;
		int m = num2.length;
		int result[] = new int[n + m];
		int i = 0, j = 0;
		int k = 0;
		while (i < n && j < m) {

			if (num1[i] < num2[j]) {
				result[k] = num1[i];
				i++;
			} else {
				result[k] = num2[j];
				j++;
			}
			k++;
		}

		if (i < n) {
			while (i < n) {
				result[k] = num1[i];
				i++;
				k++;
			}
		}
		if (j < m) {
			while (j < m) {
				result[k] = num2[j];
				j++;
				k++;
			}
		}
		if (k % 2 == 0) {
			median = (result[k / 2 - 1] + result[k / 2]) / 2.0;
		} else {

			median = result[k / 2];
		}
		return median;
	}

	public double findMedianSortedArraysWithNComplexity(int[] num1, int[] num2) {
		int l1 = num1.length;
		int l2 = num2.length;
		int l = l1 + l2;
		int[] num = new int[l];
		int i = 0;
		int j = 0;
		int k = 0;
		while (i <= l1 && j <= l2) {

			if (i == l1) {
				while (j < l2)
					num[k++] = num2[j++];
				break;

			} else if (j == l2) {
				while (i < l1)
					num[k++] = num1[i++];
				break;
			}

			if (num1[i] < num2[j]) {
				num[k] = num1[i];
				i++;
			} else {
				num[k] = num2[j];
				j++;
			}
			k++;

		}

		if (l % 2 == 0)
			return (float) (num[l / 2 - 1] + num[l / 2]) / 2;
		else
			return num[l / 2];

	}

	public double findMedianSortedArraysWithLogNComplexity(int[] A, int[] B) {
		int na = A.length, nb = B.length;
		int n = na + nb;
		if ((na + nb) % 2 == 1) {
			return solve(A, B, n / 2, 0, na - 1, 0, nb - 1);
		} else {
			return (double) (solve(A, B, n / 2, 0, na - 1, 0, nb - 1) + solve(A, B, n / 2 - 1, 0, na - 1, 0, nb - 1))
					/ 2;
		}
	}

	public int solve(int[] A, int[] B, int k, int aStart, int aEnd, int bStart, int bEnd) {
		// If the segment of on array is empty, it means we have passed all
		// its element, just return the corresponding element in the other array.
		if (aEnd < aStart) {
			return B[k - aStart];
		}
		if (bEnd < bStart) {
			return A[k - bStart];
		}

		// Get the middle indexes and middle values of A and B.
		int aIndex = (aStart + aEnd) / 2, bIndex = (bStart + bEnd) / 2;
		int aValue = A[aIndex], bValue = B[bIndex];

		// If k is in the right half of A + B, remove the smaller left half.
		if (aIndex + bIndex < k) {
			if (aValue > bValue) {
				return solve(A, B, k, aStart, aEnd, bIndex + 1, bEnd);
			} else {
				return solve(A, B, k, aIndex + 1, aEnd, bStart, bEnd);
			}
		}
		// Otherwise, remove the Larger right half.
		else {
			if (aValue > bValue) {
				return solve(A, B, k, aStart, aIndex - 1, bStart, bEnd);
			} else {
				return solve(A, B, k, aStart, aEnd, bStart, bIndex - 1);
			}
		}
	}

}
