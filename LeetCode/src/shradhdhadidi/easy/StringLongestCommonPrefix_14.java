package shradhdhadidi.easy;

public class StringLongestCommonPrefix_14 {

	public static void main(String[] args) {
		StringLongestCommonPrefix_14 obj = new StringLongestCommonPrefix_14();
		String[] strs = new String[] { "flower", "flow", "flight" };
		String prefix = obj.longestCommonPrefix(strs);
		System.out.println(prefix);
	}

	public String longestCommonPrefix(String[] strs) {
		if (strs.length == 0)
			return "";
		String prefix = strs[0];
		for (int i = 1; i < strs.length; i++)
			while (strs[i].indexOf(prefix) != 0) {
				prefix = prefix.substring(0, prefix.length() - 1);
				if (prefix.isEmpty())
					return "";
			}
		return prefix;
	}
}
