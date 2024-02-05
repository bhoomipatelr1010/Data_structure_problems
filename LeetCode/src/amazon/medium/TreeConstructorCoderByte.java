package amazon.medium;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.Set;

public class TreeConstructorCoderByte {

	public static void main(String[] args) {

		String[] strArr = new String[] { "(1,2)", "(3,2)", "(2,12)", "(5,2)" };
		System.out.println(TreeConstructor(strArr));
	}

	public static String TreeConstructor(String[] strArr) {

		Queue<Integer> que = new PriorityQueue<>(Collections.reverseOrder());
		List<Integer> res = new ArrayList();

		res.stream().map(i -> i).toArray();

		que.add(55);
		que.add(67);
		que.add(44);
		que.remove(55);
		Set<String> childSet = new HashSet<>();

		Map<String, Integer> childCount = new HashMap<>();

		for (String str : strArr) {
			String[] node = str.replaceAll("[^0-9,]", "").split(",");
			childSet.add(node[0]);
			Integer count = childCount.get(node[1]);

			if (count != null && count + 1 > 2) {
				return "" + false;
			}

			childCount.put(node[1], count != null ? count + 1 : 1);
		}

		// code goes here
		return (childSet.size() == strArr.length) + "";
	}
}
