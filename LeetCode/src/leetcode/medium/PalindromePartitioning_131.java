package leetcode.medium;

import java.util.ArrayList;
import java.util.List;

public class PalindromePartitioning_131 {

	public static void main(String[] args) {

		PalindromePartitioning_131 obj = new PalindromePartitioning_131();
		System.out.println(obj.partition("aab"));

	}

	public List<List<String>> partition(String s) {
		List<List<String>> result = new ArrayList<List<String>>();
		rec(s, new ArrayList<>(), result, 0);
		return result;
	}

	public void rec(String s, List<String> lst, List<List<String>> res, int i) {

		if (i >= s.length()) {
			res.add(new ArrayList<>(lst));
			return;
		}

		for (int p = i; p < s.length(); p++) {

			if (checkIfPalindrom(s, i, p)) {

				lst.add(s.substring(i, p + 1));
				rec(s, lst, res, p + 1);
				lst.remove(lst.size() - 1);

			}

		}
	}

	public boolean checkIfPalindrom(String s, int low, int high) {
		while (low < high) {
			if (s.charAt(low++) != s.charAt(high--))
				return false;
		}
		return true;
	}
}
