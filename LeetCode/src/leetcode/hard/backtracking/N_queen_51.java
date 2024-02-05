package leetcode.hard.backtracking;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class N_queen_51 {
	public static void main(String[] args) {

	}

	private List<List<String>> solutions = new ArrayList<List<String>>();

	public List<List<String>> solveNQueens(int n) {
		char emptyBoard[][] = new char[n][n];
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < n; j++) {
				emptyBoard[i][j] = '.';
			}
		}

		backtrack(n, emptyBoard, 0, new HashSet<>(), new HashSet<>(), new HashSet<>());
		return solutions;
	}

	public void backtrack(int n, char[][] state, int row, Set<Integer> diagonals, Set<Integer> antiDiagonals,
			Set<Integer> cols) {

		if (row == n) {
			createBoard(state);
		}

		for (int col = 0; col < n; col++) {
			int currAntiDiagonal = row + col;
			int currDiagonal = row - col;
			if (!isSafe(col, currAntiDiagonal, currDiagonal, diagonals, antiDiagonals, cols)) {
				continue;
			}

			diagonals.add(currDiagonal);
			antiDiagonals.add(currAntiDiagonal);
			cols.add(col);
			state[row][col] = 'Q';

			backtrack(n, state, row + 1, diagonals, antiDiagonals, cols);

			diagonals.remove(currDiagonal);
			antiDiagonals.remove(currAntiDiagonal);
			cols.remove(col);
			state[row][col] = '.';
		}

	}

	public void createBoard(char[][] state) {
		List<String> queensBoard = new ArrayList<>();
		for (int i = 0; i < state.length; i++) {
			String current_row = new String(state[i]);
			queensBoard.add(current_row);
		}
		solutions.add(queensBoard);

	}

	public boolean isSafe(int col, int currAntiDiagonal, int currDiagonal, Set<Integer> diagonals,
			Set<Integer> antiDiagonals, Set<Integer> cols) {

		if (cols.contains(col) || diagonals.contains(currDiagonal) || antiDiagonals.contains(currAntiDiagonal)) {
			return false;
		}
		return true;
	}
}
