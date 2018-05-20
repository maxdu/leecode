package topInterviewQuestionsEasy.string;

import java.util.Arrays;

public class FirstUniqChar {

	public FirstUniqChar() {

	}

	public static void main(String[] args) {
		FirstUniqChar rs = new FirstUniqChar();
		System.out.println(String.format("%s", rs.firstUniqChar("leetcode")));
		System.out.println(String.format("%s", rs.firstUniqChar("loveleetcode")));
	}

	public int firstUniqChar(String s) {
		int[] counter = new int[26];
		char[] charAry = s.toCharArray();
		for (char ca : charAry) {
			counter[ca - 'a'] += 1;
		}
		for (int i = 0; i < charAry.length; i++) {
			if (counter[charAry[i] - 'a'] == 1) {
				return i;
			}
		}

		return -1;
	}

}
