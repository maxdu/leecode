package topInterviewQuestionsEasy.dynamicProgramming;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.IntStream;

public class ClimbStairs {

	public static Set unique;

	public ClimbStairs() {
		// TODO Auto-generated constructor stub
	}

	public static void main(String[] args) {
		System.out.println(climbStairs(1));
		System.out.println(climbStairs(2));
		System.out.println(climbStairs(35));

	}

	public static int climbStairsFastest(int n) {
		int[] nums = new int[n + 1];
		nums[0] = 1;
		nums[1] = 1;
		for (int i = 2, length = nums.length; i < length; i++) {
			nums[i] = nums[i - 1] + nums[i - 2];
		}
		return nums[n];
	}

	//https://www.cnblogs.com/xiaolovewei/p/8072489.html
	// https://www.jianshu.com/p/bd6b834d2546
	// https://blog.csdn.net/my_jobs/article/details/43535179
	public static int climbStairs(int n) {
		if (n == 0 || n == 1 || n == 2) {
			return n;
		}
		int[] r = new int[n + 1];
		r[1] = 1;
		r[2] = 2;
		for (int i = 3; i <= n; i++) {
			r[i] = r[i - 1] + r[i - 2];
		}
		return r[n];
	}

	public static int climbStairsFoolTimeout(int n) {
		int stepByOneMax = n / 1;
		int stepByTwoMax = n / 2;
		int solutions = 0;

		for (int i = 0; i <= stepByOneMax; i++) {
			for (int j = 0; j <= stepByTwoMax; j++) {
				if (i + j * 2 == n) {
					solutions += differSequences(i, j);
				}

			}
		}

		return solutions;

	}

	public static int differSequences(int x, int y) {
		unique = new HashSet();
		if (x == 0 || y == 0) {
			// System.out.println(String.format("1步*%s, 2步*%s", x, y));
			return 1;
		} else {
			List<String> data = new ArrayList<>(x + y);
			String[] dataAry = new String[x + y];
			IntStream.range(0, x).forEach(xx -> data.add("1步"));
			IntStream.range(0, y).forEach(yy -> data.add("2步"));
			dataAry = data.toArray(dataAry);
			permute(dataAry, 0, unique);
			return unique.size();
		}

	}

	// s表示，从array[start]后的数据进行全排列
	public static void permute(String[] array, int start, Set<String> unique) {
		if (start == array.length) { // 输出
			// System.out.println(Arrays.toString(array));
			unique.add(Arrays.toString(array));
		} else
			for (int i = start; i < array.length; ++i) {
				swap(array, start, i); // 交换元素
				permute(array, start + 1, unique); // 交换后，再进行全排列算法
				swap(array, start, i); // 还原成原来的数组，便于下一次的全排列
			}
	}

	private static void swap(String[] array, int s, int i) {
		String t = array[s];
		array[s] = array[i];
		array[i] = t;
	}
}
