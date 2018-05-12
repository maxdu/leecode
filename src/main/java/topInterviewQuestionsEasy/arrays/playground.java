package topInterviewQuestionsEasy.arrays;

import java.util.Arrays;

public class playground {

	public playground() {
	}

	public static void main(String[] args) {
		
		Arrays.asList(new int[] { 1, 2, 3, 4 }).forEach(System.out::println);
		System.out.println();
		
		Arrays.asList(1, 2, 3, 4).forEach(System.out::println);
		System.out.println();
		
		Arrays.stream(new int[] { 1, 2, 3, 4 }).forEach(System.out::println);
		System.out.println();
	}
}
