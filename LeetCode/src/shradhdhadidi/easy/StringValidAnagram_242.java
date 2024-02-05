package shradhdhadidi.easy;

import java.util.HashMap;

public class StringValidAnagram_242 {

	public static void main(String[] args) {
		StringValidAnagram_242 obj = new StringValidAnagram_242();
		System.out.println(obj.isAnagram("anagram", "ana"));
	}

	public boolean isAnagram(String s, String t) {
		HashMap<Character, Integer> map = new HashMap<>();
		char[] charStr = s.toCharArray();

		if (s.length() != t.length()) {
			return false;
		}
		for (char c : charStr) {

			map.put(c, map.getOrDefault(c, 0) + 1);

		}
		char[] tChar = t.toCharArray();

		for (char tc : tChar) {
			if (!map.isEmpty() && map.containsKey(tc) && map.get(tc) != 0) {
				map.put(tc, map.get(tc) - 1);
			} else {
				return false;
			}
		}
		return true;
	}

}
