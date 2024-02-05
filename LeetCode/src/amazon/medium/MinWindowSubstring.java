package amazon.medium;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.Stack;

public class MinWindowSubstring {

	/*
	 * static int sumDIgits(int num) {
	 * 
	 * return sum;
	 * 
	 * }
	 */

	volatile String s = "abc";

	public static void main(String[] args) {
		int[] bew = new int[] { 1, 2, 3, 4, 4, 4 };

		PriorityQueue<Integer> heap = new PriorityQueue<Integer>((a, b) -> b - a);

		List<Character> lst = new ArrayList<>();

		lst.add('a');
		lst.add('b');
		lst.add('c');
		lst.add('a');
Collections.sy
		System.out.println(lst);
		System.out.println(lst.indexOf('b'));
		lst.remove(lst.indexOf('b'));
		System.out.println(lst);

		/*
		 * Queue<Integer> que = new LinkedList<>(); que.re que.
		 * 
		 * Set<Integer> s = Arrays.stream(b).boxed().collect(Collectors.toSet());
		 * 
		 * System.out.println(s.size()); System.out.println(Math.abs(-1));
		 */

		/*
		 * int a = 1111; int count = 0;
		 * 
		 * while (a / 10 != 0) { int sum = 0; while (a / 10 != 0) {
		 * 
		 * sum += a % 10; a = a / 10; } a = sum; count++; } System.out.println(count);
		 */

		/*
		 * String[] strArr = new String[] { "1, 3, 4, 7, 13", "1, 2, 4, 13, 15" };
		 * 
		 * String input = "a1b^c2d3e"; String[] result = input.split("[^a-z^0-9]");
		 * 
		 * for (String s : result) { System.out.println(s); }
		 */
		/*
		 * List<Integer> lst1 = Arrays.stream(strArr[0].replace(" ",
		 * "").split(",")).map(Integer::parseInt) .collect(Collectors.toList());
		 * 
		 * List<Integer> lst2 = Arrays.stream(strArr[1].replace(" ",
		 * "").split(",")).map(Integer::parseInt) .collect(Collectors.toList());
		 * 
		 * lst1.retainAll(lst2);
		 * 
		 * System.out.println();
		 */
		/*
		 * Pattern p = Pattern.compile("[a-zA-Z][a-zA-Z0-9_]{2,23}[a-zA-Z0-9]");
		 * 
		 * System.out.println(p.matcher("aa_").matches() ? "true" : "false");
		 */
		/*
		 * String[] strArr = new String[] { "aaffhkksfhemckelloe", "fhe" };
		 * 
		 * System.out.println(MinWindowSubstring(strArr));
		 */
	}

	public static String MinWindowSubstring(String[] strArr) {

		String str1 = strArr[0];
		String str2 = strArr[1];
		int str2Length = str2.length();

		int minWindow = Integer.MAX_VALUE;
		Map<Character, Integer> countMap = new HashMap<>();

		for (char c : str2.toCharArray())
			countMap.put(c, countMap.getOrDefault(c, 0) + 1);

		int start = 0;

		String answer = null;

		for (int end = 0; end < str1.length(); end++) {
			char char1 = str1.charAt(end);

			if (countMap.containsKey(char1)) {
				countMap.put(char1, countMap.get(char1) - 1);

				if (countMap.get(char1) >= 0) {
					str2Length -= 1;
				}
			}

			while (str2Length == 0) {
				if (countMap.containsKey(str1.charAt(start))) {

					countMap.put(str1.charAt(start), countMap.get(str1.charAt(start)) + 1);

					if (countMap.get(str1.charAt(start)) > 0) {

						if (minWindow > (end - start + 1)) {
							answer = str1.substring(start, end + 1);
							minWindow = end - start + 1;
						}
						break;
					}
				}

				start++;

			}

		}

		// code goes here
		return answer;
	}

	public static String BracketMatcher(String str) {

		Queue<Character> que = new PriorityQueue<Character>();

		Stack<Character> stk = new Stack<>();

		for (char curChar : str.toCharArray()) {
			if (curChar == '(') {
				stk.push(curChar);
			} else if (curChar == ')') {

				if (stk.isEmpty() || stk.peek() != '(') {
					return "0";
				}
				stk.pop();
			}

		}
		return stk.isEmpty() ? "1" : "0";
	}

}
