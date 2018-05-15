package topInterviewQuestionsEasy.arrays;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class IsValidSudoku {

	public static void main(String[] args) {

		IsValidSudoku instance = new IsValidSudoku();
		System.out.println(instance.isValidSudoku(new char[][] { { '5', '3', '.', '.', '7', '.', '.', '.', '.' },
				{ '6', '.', '.', '1', '9', '5', '.', '.', '.' }, { '.', '9', '8', '.', '.', '.', '.', '6', '.' },
				{ '8', '.', '.', '.', '6', '.', '.', '.', '3' }, { '4', '.', '.', '8', '.', '3', '.', '.', '1' },
				{ '7', '.', '.', '.', '2', '.', '.', '.', '6' }, { '.', '6', '.', '.', '.', '.', '2', '8', '.' },
				{ '.', '.', '.', '4', '1', '9', '.', '.', '5' }, { '.', '.', '.', '.', '8', '.', '.', '7', '9' } }));

		System.out.println(instance.isValidSudoku(new char[][] { { '8', '3', '.', '.', '7', '.', '.', '.', '.' },
				{ '6', '.', '.', '1', '9', '5', '.', '.', '.' }, { '.', '9', '8', '.', '.', '.', '.', '6', '.' },
				{ '8', '.', '.', '.', '6', '.', '.', '.', '3' }, { '4', '.', '.', '8', '.', '3', '.', '.', '1' },
				{ '7', '.', '.', '.', '2', '.', '.', '.', '6' }, { '.', '6', '.', '.', '.', '.', '2', '8', '.' },
				{ '.', '.', '.', '4', '1', '9', '.', '.', '5' }, { '.', '.', '.', '.', '8', '.', '.', '7', '9' } }));
	}

	// fixed 9x9
	public boolean isValidSudoku(char[][] board) {

		if (board.length != 9)
			return false;

		List<Integer> rowCheck = null;
		List<Integer> colCheck = null;
		List<List<Integer>> gridCheck = new ArrayList<>();
		for (int i = 0; i < 9; i++) {
			gridCheck.add(new ArrayList<>());
		}

		for (int i = 0; i < 9; i++) {

			rowCheck = new ArrayList<>();
			colCheck = new ArrayList<>();

			for (int j = 0; j < 9; j++) {

				if (board[i][j] != '.' && board[i][j] < '1' && board[i][j] > '9')
					return false;

				int rowValue = board[i][j] - '0' - 1;
				int colValue = board[j][i] - '0' - 1;
				// row check & grid check
				if (board[i][j] != '.') {
					rowCheck.add(rowValue);
					int chkIdx = mapping(mapping(i), mapping(j));
					gridCheck.get(chkIdx).add(rowValue);
				}

				// col check
				if (board[j][i] != '.') {
					colCheck.add(colValue);
				}
			}

			// check row
			if (!checkDuplications(rowCheck))
				return false;

			// check col
			if (!checkDuplications(colCheck))
				return false;
		}

		// check grid
		for (int i = 0; i < 9; i++) {
			if (!checkDuplications(gridCheck.get(i)))
				return false;
		}

		return true;

	}

	private int mapping(int i) {
		if (i >= 0 && i <= 2)
			return 0;
		if (i >= 3 && i <= 5)
			return 1;
		if (i >= 6 && i <= 8)
			return 2;
		return -1;

	}

	private int mapping(int x, int y) {
		if (x == 0 && y == 0)
			return 0;
		if (x == 0 && y == 1)
			return 1;
		if (x == 0 && y == 2)
			return 2;

		if (x == 1 && y == 0)
			return 3;
		if (x == 1 && y == 1)
			return 4;
		if (x == 1 && y == 2)
			return 5;

		if (x == 2 && y == 0)
			return 6;
		if (x == 2 && y == 1)
			return 7;
		if (x == 2 && y == 2)
			return 8;
		return -1;
	}

	private boolean checkDuplications(List<Integer> list) {
		for (int i = 0; i < list.size(); i++) {
			int count = 0;
			for (int j = 0; j < list.size(); j++) {
				if (list.get(j) == list.get(i)) {
					count++;
				}
				if (count > 1)
					return false;
			}
		}
		return true;
	}
}
