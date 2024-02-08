package dsa;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;

public class FindIfPathExistInGraph {
	public static void main(String[] args) {
		FindIfPathExistInGraph obj = new FindIfPathExistInGraph();
		int nums1[] = { 1, 2, 7, 9, 10 };
		int nums2[] = { 3, 4, 6, 11, 12, 13 };

	}

	public boolean validPath(int n, int[][] edges, int source, int destination) {
		// Store all edges in 'graph'.
		Map<Integer, List<Integer>> graph = new HashMap<>();
		for (int[] edge : edges) {
			int a = edge[0];
			int b = edge[1];
			graph.computeIfAbsent(a, val -> new ArrayList<Integer>()).add(b);
			graph.computeIfAbsent(b, val -> new ArrayList<Integer>()).add(a);
		}

		// Store all the nodes to be visited in 'queue'.
		boolean[] seen = new boolean[n];
		seen[source] = true;
		Queue<Integer> queue = new LinkedList<>();
		queue.offer(source);

		while (!queue.isEmpty()) {
			int currNode = queue.poll();
			if (currNode == destination) {
				return true;
			}

			// For all the neighbors of the current node, if we haven't visit it before,
			// add it to 'queue' and mark it as visited.
			for (int nextNode : graph.get(currNode)) {
				if (!seen[nextNode]) {
					seen[nextNode] = true;
					queue.offer(nextNode);
				}
			}
		}

		return false;
	}
}
