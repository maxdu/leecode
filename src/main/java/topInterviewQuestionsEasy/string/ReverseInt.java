package topInterviewQuestionsEasy.string;

public class ReverseInt {

	public ReverseInt() {

	}

	public static void main(String[] args) {
		ReverseInt rs = new ReverseInt();
		System.out.println(String.format("%s", rs.reverse(1)));
		System.out.println(String.format("%s", rs.reverse(23762)));
		System.out.println(String.format("%s", rs.reverse(237625)));
		System.out.println(String.format("%s", rs.reverse(9587342)));
		System.out.println(String.format("%s", rs.reverse(0)));
		System.out.println(String.format("%s", rs.reverse(-1)));
		System.out.println(String.format("%s", rs.reverse(-23762)));
		System.out.println(String.format("%s", rs.reverse(-237625)));
		System.out.println(String.format("%s", rs.reverse(-9587342)));
	}

	public int reverse(int x) {
		long result = 0;
		long num = (long) x;
		while (num != 0) {
			result *= 10;
			result += num % 10;
			num /= 10;
		}
		int test = (int) result;
		if (test == result)
			return test;
		return 0;
	}

	public int reverse2(int x) {
		boolean negative = x < 0;
		if (negative)
			x = -x;
		long r = 0;
		while (x > 0) {
			r = r * 10 + x % 10;
			x /= 10;
		}
		if (negative)
			r = -r;
		if (r > Integer.MAX_VALUE || r < Integer.MIN_VALUE)
			return 0;
		return (int) r;
	}

	public int reverseSilly(int x) {
		try {

			boolean ng = false;
			if (x < 0)
				ng = true;
			char[] charAry = String.valueOf(x).toCharArray();
			int l = charAry.length - 1;
			int mid = 0;
			mid = charAry.length / 2;
			char temp;
			for (int i = 0; i < mid; i++) {
				temp = charAry[i];
				charAry[i] = charAry[l - i];
				charAry[l - i] = temp;
			}
			if (ng)
				charAry[l] = ' ';
			int output = Integer.parseInt(ng ? "-" + String.valueOf(charAry).trim() : String.valueOf(charAry).trim());
			return output;

		} catch (NumberFormatException e) {
			return 0;
		}
	}

}
