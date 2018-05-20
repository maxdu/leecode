package topInterviewQuestionsEasy.string;

public class IsAnagram {

	// anagram的定义
	// 名词
	// a word, phrase, or name formed by rearranging the letters of another,
	// such as cinema , formed from iceman.
	// 字母异位词指字母相同，但排列不同的字符串

	public IsAnagram() {
		// TODO Auto-generated constructor stub
	}

	public static void main(String[] args) {
		
		String res = new String("你好".toCharArray());
		System.out.println(res);
		
		String res2 = new String("ABCDEFG\u1023".toCharArray());
		System.out.println(res2);
		
		IsAnagram rs = new IsAnagram();
		System.out.println(String.format("%s", rs.isAnagram("anagram", "nagaram")));
		System.out.println(String.format("%s", rs.isAnagram("rat", "car")));
		
		
	}
	
/*
 * Actually char can contain unicode chars utf16
 * The values of the integral types are integers in the following ranges:
For char, from '\u0000' to '\uffff' inclusive, that is, from 0 to 65535
 */

	public boolean isAnagram(String s, String t) {
		char[] source = s.toCharArray();
		char[] target = t.toCharArray();
		if (source.length != target.length)
			return false;

		int[] srouceTester = new int[26];
		int[] targetTester = new int[26];

		for (char es : source) {
			srouceTester[es - 'a'] += 1;
		}
		for (char et : target) {
			targetTester[et - 'a'] += 1;
		}

		for (int i = 0; i < 26; i++) {
			if (srouceTester[i] != targetTester[i]) {
				return false;
			}
		}
		return true;

	}
	


}
