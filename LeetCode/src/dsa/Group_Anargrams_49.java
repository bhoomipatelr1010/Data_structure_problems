package dsa;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Deque;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.LinkedList;
import java.util.List;

public class Group_Anargrams_49 {

	public static void main(String[] args) {
		
		HashSet<Integer> hashSet = new LinkedHashSet<>();

		hashSet.add(2);
		hashSet.add(1);
		hashSet.add(2);
		
		System.out.println(hashSet);
		
		String[] s = new String[] { "eat", "tea", "tan", "ate", "nat", "bat" };
	//	System.out.println(groupAnagrams(s));
	}

	public static List<List<String>> groupAnagrams(String[] strs) {

		HashMap<String, List<String>> map = new HashMap<>();

		Deque<Integer> doublyQueue = new LinkedList<>();

		
		for (int i = 0; i < strs.length; i++) {

			char[] tempArray = strs[i].toCharArray();
			Arrays.sort(tempArray);
			String sorted = new String(tempArray);
			if (map.containsKey(sorted)) {
				map.get(sorted).add(strs[i]);
			} else {
				List<String> lst = new ArrayList();
				lst.add(strs[i]);
				map.put(sorted, lst);
			}
		}

		return new ArrayList(map.values());

	}
}
