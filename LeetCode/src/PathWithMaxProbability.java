import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;

import javafx.util.Pair;

public class PathWithMaxProbability {

	public static void main(String[] args) {
		PathWithMaxProbability obj = new PathWithMaxProbability();
		int edges[][] = new int[][] { { 0, 1 }, { 1, 2 }, { 0, 2 }, { 1, 3 }, { 2, 3 } };
		double succProb[] = new double[] { 0.8, 0.8, 0.3, 1, 1 };
		System.out.println(obj.solution(4, edges, succProb, 0, 2));
		System.out.println(obj.solution1(4, edges, succProb, 0, 2));

	}

	public double solution(int n, int[][] edges, double[] succProb, int start, int end) {

		Queue<Integer> vertices = new LinkedList<>();

		double[] maxProb = new double[n];
		maxProb[start] = 1.0;
		vertices.offer(start);
		int k = 0;

		while (!vertices.isEmpty()) {
			int node = vertices.poll();

			for (int i = 0; i < edges.length; i++) {
				int[] edge = edges[i];
				if (edge[0] == node) {

					if (maxProb[node] * succProb[i] > maxProb[edge[1]]) {
						maxProb[edge[1]] = maxProb[node] * succProb[i];
						vertices.add(edge[1]);
					}

				}

			}
			k++;

		}
		System.out.println(k);
		return maxProb[end];

	}

	public double solution1(int n, int[][] edges, double[] succProb, int start, int end) {
		Map<Integer, List<Pair<Integer, Double>>> graph = new HashMap<>();
		for (int i = 0; i < edges.length; i++) {
			int u = edges[i][0], v = edges[i][1];
			double pathProb = succProb[i];
			graph.computeIfAbsent(u, k -> new ArrayList<>()).add(new Pair<>(v, pathProb));
			graph.computeIfAbsent(v, k -> new ArrayList<>()).add(new Pair<>(u, pathProb));
		}

		double[] maxProb = new double[n];
		maxProb[start] = 1d;

		Queue<Integer> queue = new LinkedList<>();
		queue.offer(start);
		int k = 0;
		while (!queue.isEmpty()) {
			k++;
			int curNode = queue.poll();
			for (Pair<Integer, Double> neighbor : graph.getOrDefault(curNode, new ArrayList<>())) {
				int nxtNode = neighbor.getKey();
				double pathProb = neighbor.getValue();

				// Only update maxProb[nxtNode] if the current path increases
				// the probability of reach nxtNode.
				if (maxProb[curNode] * pathProb > maxProb[nxtNode]) {
					maxProb[nxtNode] = maxProb[curNode] * pathProb;
					queue.offer(nxtNode);
				}
			}
		}
		System.out.println(k);
		return maxProb[end];
	}
}
