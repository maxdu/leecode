package topInterviewQuestionsEasy.arrays;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Rotate {

	// The nature axis for 2 Dimension array is y,x not x,y

	List<Point> temp = new ArrayList<>();

	public static void main(String[] args) {

		Rotate instance = new Rotate();

		int[][] matrix = new int[][] {};

		matrix = new int[][] { { 1, 2, 3 }, { 4, 5, 6 }, { 7, 8, 9 } };
		instance.rotate(matrix);

		System.out.println();

		matrix = new int[][] { { 5, 1, 9, 11 }, { 2, 4, 8, 10 }, { 13, 3, 6, 7 }, { 15, 14, 12, 16 } };
		instance.rotate(matrix);

		System.out.println();
	}

	public void rotate(int[][] matrix) {
		// side length
		int n = matrix.length;

		// circle count
		int circle = n / 2;
		boolean oddPoint = n % 2 == 0 ? false : true;

		// shift distance =n, and -=2 for the next
		int dist = 3;
		for (int c = 0; c < circle; c++) {
			// process by circle
			processTheCircle(new Point(c, c, -1), matrix, dist, n);
			dist -= 2;
		}

	}

	private void processTheCircle(Point p, int[][] matrix, int dist, int n) {
		temp = new ArrayList<>();
		// put other points of p's Y axis to temp
		for (int i = 0; i < dist - 1; i++) {
			temp.add(new Point(p.x, dist - p.y - i - 1, matrix[p.x][dist - p.y - i - 1]));
			matrix[p.x][dist - p.y - i - 1] = -1;
		}
		// shift points of p's X axis
		for (int i = 0; i < dist - 1; i++) {
			matrix[p.x][dist - p.y - i - 1] = matrix[p.x + i][p.y];
		}

		// shift points of p's opposite Y axis
		for (int i = 0; i < dist - 1; i++) {
			matrix[p.x + i][p.y] = matrix[p.x + dist - 1][p.y + i];
		}

		// shift points of p's opposite X axis
		for (int i = 0; i < dist - 1; i++) {
			matrix[p.x + dist - 1][p.y + i] = matrix[dist - p.x - i - 1][p.y + dist - 1];
		}
		// filling value from temp
		for (int i = 0; i < dist - 1; i++) {
			matrix[dist - p.x - i - 1][p.y + dist - 1] = temp.get(i).v;
		}
	}

	class Point {
		int x;
		int y;
		int v;

		public Point(int i, int j, int value) {
			this.x = i;
			this.y = j;
			this.v = value;
		}

	}
}
