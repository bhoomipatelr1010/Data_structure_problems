package shradhdhadidi.twodarray.medium;

import java.io.*;
import java.util.*;

public class CandidateCode {
	public static void main(String args[]) throws Exception {

		// Write code here

		Scanner sc = new Scanner(System.in);
		int length = sc.nextInt();
		System.out.println(length);
		int[] input = new int[length];

		for (int i = 0; i < length; i++) {
			int userInput = sc.nextInt();
			input[i] = userInput;
		}
		findSolution(length, input);
	}

	static void findSolution(int n, int[] arr) {

		int l = 0;
		int r = 0;

		int op = 0;
		int sum = 0;
		boolean continuousNag = false;
		for (int i = 0; i < arr.length; i++) {
			if (arr[i] < 0) {
				sum += arr[i] * -1;
				if (!continuousNag) {
					continuousNag = true;
					op += 1;
				}
			}
			if (arr[i] > 0) {
				sum += arr[i];
				continuousNag = false;
			}
		}

		/*
		 * while (l < n && r < n) { if (arr[l] >= 0) { sum += arr[l]; l++; r++; } else
		 * if (arr[r] <= 0) { r++; }
		 * 
		 * if (l != n && (r == n || arr[r] > 0) && (arr[l] < 0 && arr[r - 1] <= 0)) { op
		 * += 1; for (int i = l; i < r; i++) { sum += arr[i] * -1; } l = r; } }
		 */

		System.out.println(sum + " " + op);

	}
}
