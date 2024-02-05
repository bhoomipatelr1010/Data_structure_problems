package leetcode.hard;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class CountSubarraysAtMostKElementDivisibleByP_2274 {

	public static void main(String[] args) {
		CountSubarraysAtMostKElementDivisibleByP_2274 obj = new CountSubarraysAtMostKElementDivisibleByP_2274();
		int[] nums = new int[] { 1, 2, 3, 4 };
		System.out.println(obj.countDistinct(nums, 4, 1));

	}

	public int countDistinct(int[] nums, int k, int p) {

		Set<String> subArraySet = new HashSet<>();

		for (int i = 0; i < nums.length; i++) {
			int count = 0;
			StringBuilder sb = new StringBuilder();
			for (int j = i; j < nums.length; j++) {
				if (nums[j] % p == 0) {
					count++;
				}
				if (count > k) {
					break;
				}
				sb.append(nums[j] + "_");
				subArraySet.add(sb.toString());
			}
		}
		return subArraySet.size();

	}

}

class TrieNode {
	int num;
	Map<Integer, TrieNode> map;

	TrieNode(int num) {
		this.num = num;
		this.map = new HashMap<>();
	}
	
	 public int countDistinct(int[] nums, int k, int p) {
	        int ans = 0;
	        Trie trie = new Trie();
	        for(int i = 0;i < nums.length;i++) {
	            int cnt = 0;
	            for(int j = i;j < nums.length;j++) {
	                cnt += nums[j]%p == 0 ? 1 : 0;
	                if(cnt > k) break;
	                if(trie.move(nums[j])) ans++;
	            }
	            trie.reset();
	        }
	        return ans;
	    }
}

class Trie {
	TrieNode root;
	TrieNode curr;

	Trie() {
		root = new TrieNode(0);
		curr = root;
	}

	public boolean move(int num) {
		if (curr.map.containsKey(num)) {
			curr = curr.map.get(num);
			return false;
		}
		TrieNode node = new TrieNode(num);
		curr.map.put(num, node);
		curr = node;
		return true;
	}

	public void reset() {
		curr = root;
	}
}
