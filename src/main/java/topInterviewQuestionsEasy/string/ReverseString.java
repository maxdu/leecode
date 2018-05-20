package topInterviewQuestionsEasy.string;

public class ReverseString {

	public ReverseString() {

	}

	public static void main(String[] args) {
		ReverseString rs = new ReverseString();
		System.out.println(String.format("%s", rs.reverseString("hello")));

	}

	public String reverseString(String s) {
		char[] charAry = s.toCharArray();
		int l = charAry.length - 1;
		int mid = charAry.length / 2;
		char t;
		for (int i = 0; i < mid; i++) {
			t = charAry[i];
			charAry[i] = charAry[l - i];
			charAry[l - i] = t;
		}
		return String.valueOf(charAry);

	}

	public String reverseStringSilly(String s) {
		byte[] byteStr = new byte[s.length()];
		byte[] strByte = s.getBytes();
		for (int i = 0; i < s.length(); i++) {
			byteStr[i] = strByte[s.length() - 1 - i];
		}
		return new String(byteStr);

	}

}
