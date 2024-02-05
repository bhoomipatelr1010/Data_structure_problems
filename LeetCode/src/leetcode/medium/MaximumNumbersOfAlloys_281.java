package leetcode.medium;

import java.util.List;
import java.util.PriorityQueue;

import javafx.util.Pair;

public class MaximumNumbersOfAlloys_281 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	public int maxNumberOfAlloys(int n, int k, int budget, List<List<Integer>> composition, List<Integer> stock,
			List<Integer> cost) {

		int maxCost = 0;
		int optimumMachineIndex = -1;

		for (int i = 0; i < composition.size(); i++) {

			int currentMachineCost = 0;
			for (int j = 0; j < composition.size(); j++) {
				currentMachineCost += composition.get(i).get(j) * cost.get(j);
			}
			if(currentMachineCost>=) {
				maxCost=
			}
		}

		selectionOfMachine.peek();

	}
}
