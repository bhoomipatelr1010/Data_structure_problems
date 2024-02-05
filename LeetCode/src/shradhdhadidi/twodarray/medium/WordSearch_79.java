package shradhdhadidi.twodarray.medium;

import java.util.HashSet;
import java.util.Set;

import javafx.util.Pair;

public class WordSearch_79 {

	public static void main(String[] args) {
		char[][] board = new char[][] { { 'A', 'B', 'C', 'E' }, { 'S', 'F', 'C', 'S' }, { 'A', 'D', 'E', 'E' } };
		System.out.println(new WordSearch_79().exist(board, "ABCCED"));
	}

	int[][] directions = { { -1, 0 }, { 0, 1 }, { 1, 0 }, { 0, -1 } };
	int n = 0;
	int m = 0;

	public boolean backtrack(int row, int col, int wordIndex, char[][] board, String word) {
		if (wordIndex >= word.length()) {
			return true;
		}
		if (canMove(row, col) || board[row][col] != word.charAt(wordIndex)) {

			return false;
		}
		  board[row][col] = '#';
		boolean ret = false;
		for (int i = 0; i < 4; ++i) {

			int newRow = row + directions[i][0];
			int newCol = col + directions[i][1];

			ret = backtrack(newRow, newCol, wordIndex + 1, board, word);
			if (ret)
				return true;

		}
		board[row][col] = word.charAt(wordIndex);
		return false;
	}

	public boolean canMove(int i, int j) {
		if (i >= 0 && i < n && j >= 0 && j < m) {
			return false;
		}
		return true;
	}

	public boolean exist(char[][] board, String word) {

		this.n = board.length;
		this.m = board[0].length;
		char startingLetter = word.charAt(0);
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < m; j++) {

				if (board[i][j] == startingLetter && backtrack(i, j, 0, board, word)) {
					return true;
				}

			}
		}
		return false;

	}

}
