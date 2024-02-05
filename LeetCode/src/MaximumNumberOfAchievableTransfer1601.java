
public class MaximumNumberOfAchievableTransfer1601 {
	int answer = 0;

	public static void main(String[] args) {
		int requests[][] = new int[][] { { 0, 1 }, { 1, 0 }, { 0, 1 }, { 1, 2 }, { 2, 0 }, { 3, 4 } };
		int requests2[][] = new int[][] { { 1, 2 }, { 1, 2 }, { 2, 2 }, { 0, 2 }, { 2, 1 }, { 1, 1 }, { 1, 2 } };

		int requests1[][] = new int[][] { { 0, 0 }, { 2, 0 }, { 1, 0 }, { 1, 2 }, { 2, 1 } };

		int requests4[][] = new int[][] { { 0, 0 }, { 1, 1 }, { 0, 0 }, { 2, 0 }, { 2, 2 }, { 1, 1 }, { 2, 1 },
				{ 0, 1 }, { 0, 1 } };

		int n1 = 3;
		MaximumNumberOfAchievableTransfer1601 obj = new MaximumNumberOfAchievableTransfer1601();
		System.out.println(obj.maximumRequests(n1, requests1));
	}

	public int solution(int n, int[][] requests) {
		int[] extraEmployees = new int[n];
		int[] maxServed = new int[1];

		employeeTransfer(extraEmployees, 0, requests, maxServed);
		return maxServed[0];
	}

	public void requestServed(int[] extraEmployees, int i, int[][] requests, int[] maxServed) {

		if (i == requests.length) {
			return;
		}

		extraEmployees[requests[i][0]] = extraEmployees[requests[i][0]] - 1;
		extraEmployees[requests[i][1]] = extraEmployees[requests[i][1]] + 1;
		requestServed(extraEmployees, i + 1, requests, maxServed);

		if (extraEmployees[requests[i][0]] == 0 && extraEmployees[requests[i][1]] == 0) {
			maxServed[0] += 1;
		}
	}

	public void employeeTransfer(int[] extraEmployees, int i, int[][] requests, int[] maxServed) {
		if (i == requests.length) {
			return;
		}

		extraEmployees[requests[i][0]] = extraEmployees[requests[i][0]] - 1;
		employeeTransfer(extraEmployees, i + 1, requests, maxServed);

		extraEmployees[requests[i][1]] = extraEmployees[requests[i][1]] + 1;
		if (extraEmployees[requests[i][1]] <= 0) {
			maxServed[0] += 1;
		}
	}

	public int maximumRequests(int n, int[][] requests) {
		int[] indegree = new int[n];
		maxRequest(requests, indegree, n, 0, 0);

		return answer;
	}

	void maxRequest(int[][] requests, int[] indegree, int n, int index, int count) {
		if (index == requests.length) {
			// Check if all buildings have an in-degree of 0.
			for (int i = 0; i < n; i++) {
				if (indegree[i] != 0) {
					return;
				}
			}

			answer = Math.max(answer, count);
			return;
		}

		// Consider this request, increment and decrement for the buildings involved.
		indegree[requests[index][0]]--;
		indegree[requests[index][1]]++;
		// Move on to the next request and also increment the count of requests.
		maxRequest(requests, indegree, n, index + 1, count + 1);
		// Backtrack to the previous values to move back to the original state before
		// the second recursion.
		indegree[requests[index][0]]++;
		indegree[requests[index][1]]--;

		// Ignore this request and move on to the next request without incrementing the
		// count.
		maxRequest(requests, indegree, n, index + 1, count);
	}
}
