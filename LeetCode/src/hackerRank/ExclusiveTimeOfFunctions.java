package hackerRank;

import java.util.Arrays;
import java.util.List;
import java.util.Stack;

public class ExclusiveTimeOfFunctions {

	public int[] exclusiveTime(int n, List<String> logs) {
		int[] result = new int[n];
		Stack<Integer> stack = new Stack<>();
		int prevTimestamp = 0;

		for (String log : logs) {
			String[] parts = log.split(":");
			int functionId = Integer.parseInt(parts[0]);
			String eventType = parts[1];
			int timestamp = Integer.parseInt(parts[2]);

			if (eventType.equals("start")) {
				if (!stack.isEmpty()) {
					result[stack.peek()] += timestamp - prevTimestamp;
				}
				stack.push(functionId);
				prevTimestamp = timestamp;
			} else {
				result[stack.pop()] += timestamp - prevTimestamp + 1;
				prevTimestamp = timestamp + 1;
			}
		}

		return result;
	}

	public static void main(String[] args) {
		ExclusiveTimeOfFunctions solution = new ExclusiveTimeOfFunctions();
		int n = 3;
		List<String> logs = Arrays.asList("0:start:0", "2:start:4", "2:end:5", "1:start:7", "1:end:10", "0:end:11");
		int[] result = solution.exclusiveTime(n, logs);

		// Print the exclusive times for each function
		for (int i = 0; i < n; i++) {
			System.out.println("Function " + i + ": " + result[i]);
		}
	}
}
