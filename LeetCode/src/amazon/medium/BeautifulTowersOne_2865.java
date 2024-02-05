package amazon.medium;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.List;
import java.util.Stack;

public class BeautifulTowersOne_2865 {

	public static void main(String[] args) {
		BeautifulTowersOne_2865 obj = new BeautifulTowersOne_2865();
		int arr[] = new int[] { 6, 5, 3, 9, 2, 7 };

		System.out.println(obj.maximumSumOfHeights(arr));
	}

	public long maximumSumOfHeights1(List<Integer> maxHeights) {

		long ans = 0;

		for (int i = 0; i < maxHeights.size(); i++) {

			if (i - 1 >= 0 && maxHeights.get(i - 1) >= maxHeights.get(i))
				continue;
			if (i + 1 < maxHeights.size() && maxHeights.get(i + 1) > maxHeights.get(i))
				continue;

			long currentSum = maxHeights.get(i);
			long previousHt = maxHeights.get(i);
			for (int j = i + 1; j < maxHeights.size(); j++) {
				if (maxHeights.get(j) < previousHt) {
					previousHt = maxHeights.get(j);
				}
				currentSum += previousHt;

			}
			previousHt = maxHeights.get(i);

			for (int k = i - 1; k >= 0; k--) {
				if (maxHeights.get(k) < previousHt) {
					previousHt = maxHeights.get(k);
				}
				currentSum += previousHt;
			}

			ans = Math.max(ans, currentSum);
		}
		return ans;
	}

	public long maximumSumOfHeights(List<Integer> maxHeights) {
		int n = maxHeights.size();
		int[] prevsmall = new int[n];
		Arrays.fill(prevsmall, -1);
		int[] nextsmall = new int[n];
		Arrays.fill(nextsmall, n);
		long[] leftsum = new long[n];
		long[] rightsum = new long[n];
		leftsum[0] = maxHeights.get(0);
		Stack<Integer> st = new Stack<>();
		st.push(0);

		// Calculate prevSmall
		for (int i = 1; i < n; i++) {
			while (!st.isEmpty() && maxHeights.get(st.peek()) >= maxHeights.get(i))
				st.pop();
			if (!st.isEmpty())
				prevsmall[i] = st.peek();
			int prev = prevsmall[i];
			int count = i - prev;
			leftsum[i] += (long) count * maxHeights.get(i);
			if (prev != -1)
				leftsum[i] += leftsum[prev];
			st.push(i);
		}

		while (!st.isEmpty())
			st.pop();
		st.push(n - 1);

		// Calculate nextsmall;
		rightsum[n - 1] = maxHeights.get(n - 1);
		for (int i = n - 2; i >= 0; i--) {
			while (!st.isEmpty() && maxHeights.get(st.peek()) >= maxHeights.get(i))
				st.pop();
			if (!st.isEmpty())
				nextsmall[i] = st.peek();
			int next = nextsmall[i];
			int count = next - i;
			rightsum[i] += (long) count * maxHeights.get(i);
			if (next != n)
				rightsum[i] += rightsum[next];
			st.push(i);
		}

		long maxcount = 0;
		for (int i = 0; i < n; i++) {
			maxcount = Math.max(maxcount, leftsum[i] + rightsum[i] - maxHeights.get(i));
		}
		return maxcount;
	}

	/*
	 * public long maximumSumOfHeights(List<Integer> paramList) { long[][]
	 * arrayOfLong = new long[2][paramList.size() + 1]; long l = 0L;
	 * ArrayDeque<Integer> arrayDeque1 = new
	 * ArrayDeque(List.of(Integer.valueOf(-1))); ArrayDeque<Integer> arrayDeque2 =
	 * new ArrayDeque(List.of(Integer.valueOf(paramList.size()))); int i = 0; while
	 * (i < paramList.size()) { arrayOfLong[0][i + 1] = arrayOfLong[0][i]; while
	 * (arrayDeque1.size() > 1 && ((Integer) paramList.get(((Integer)
	 * arrayDeque1.peek()).intValue())) .intValue() > ((Integer)
	 * paramList.get(i)).intValue()) arrayOfLong[0][i + 1] = arrayOfLong[0][i + 1] -
	 * (long) ((Integer) paramList.get(((Integer)
	 * arrayDeque1.peek()).intValue())).intValue() (((Integer)
	 * arrayDeque1.pop()).intValue() - ((Integer) arrayDeque1.peek()).intValue());
	 * arrayOfLong[0][i + 1] = arrayOfLong[0][i + 1] + (long) ((Integer)
	 * paramList.get(i)).intValue() * (i - ((Integer)
	 * arrayDeque1.peek()).intValue()); arrayDeque1.push(Integer.valueOf(i++)); } i
	 * = paramList.size() - 1; while (i >= 0) { arrayOfLong[1][i] = arrayOfLong[1][i
	 * + 1]; while (arrayDeque2.size() > 1 && ((Integer) paramList.get(((Integer)
	 * arrayDeque2.peek()).intValue())) .intValue() > ((Integer)
	 * paramList.get(i)).intValue()) arrayOfLong[1][i] = arrayOfLong[1][i] - (long)
	 * ((Integer) paramList.get(((Integer)
	 * arrayDeque2.peek()).intValue())).intValue() (-((Integer)
	 * arrayDeque2.pop()).intValue() + ((Integer) arrayDeque2.peek()).intValue());
	 * arrayOfLong[1][i] = arrayOfLong[1][i] + (long) ((Integer)
	 * paramList.get(i)).intValue() * (((Integer) arrayDeque2.peek()).intValue() -
	 * i); arrayDeque2.push(Integer.valueOf(i--)); } for (i = 0; i <
	 * paramList.size(); i++) l = Math.max(l, arrayOfLong[0][i + 1] +
	 * arrayOfLong[1][i] - ((Integer) paramList.get(i)).intValue()); return l; }
	 */
}
