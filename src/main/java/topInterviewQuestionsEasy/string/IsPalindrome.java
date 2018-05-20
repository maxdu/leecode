package topInterviewQuestionsEasy.string;

public class IsPalindrome {

	// palindrome的定义
	// 名词
	// a word, phrase, or sequence that reads the same backward as forward,
	// e.g., madam or nurses run.
	// The word is a palindrome , reading the same backwards and forwards - or,
	// to put it more cynically, making little sense whichever way up you hold
	// it.

	public IsPalindrome() {
		// TODO Auto-generated constructor stub
	}

	public static void main(String[] args) {

		IsPalindrome rs = new IsPalindrome();
		/* */
		  System.out.println(String.format("%s", rs.isPalindrome(
		  "A man, a plan, a canal: Panama")));
		  System.out.println(String.format("%s", rs.isPalindrome("race a car"
		  ))); System.out.println(String.format("%s", rs.isPalindrome("a")));
		  System.out.println(String.format("%s", rs.isPalindrome(" ")));
		  System.out.println(String.format("%s", rs.isPalindrome("1")));
		  System.out.println(String.format("%s", rs.isPalindrome("aa")));
		 System.out.println(String.format("%s", rs.isPalindrome("")));
		 System.out.println(String.format("%s", rs.isPalindrome(".,")));
		
		System.out.println(String.format("%s", rs.isPalindrome(".,")));
	}
	
	public boolean isPalindrome(String s) {
		//2 pointer, head to tail & tail to head, compare
	    if(s == null || s.length() == 0) return true;
        int start = 0;
        int end = s.length() - 1;
        while(start < end) {
            char c = ' ';
            while(start < end) {
                c = s.charAt(start);
                if(c >= 'a' && c <= 'z') {
                    break;
                } else if(c >= '0' && c <= '9') {
                    break;
                } else if(c >= 'A' && c <= 'Z') {
                    c = (char) (c - 'A' + 'a');
                    break;
                } else {
                    start++;
                }
            }
            
            char b = ' ';
            while(start < end) {
                b = s.charAt(end);
                if(b >= 'a' && b <= 'z') {
                    break;
                } else if(b >= '0' && b <= '9') {
                    break;
                } else if(b >= 'A' && b <= 'Z') {
                    b = (char) (b - 'A' + 'a');
                    break;
                } else {
                    end--;
                }
            }
            if(start < end) {
                if(c != b) {
                    return false;
                }
                start++;
                end--;
            }
        }
        return true;
	}

	public boolean isPalindromeSlow(String s) {
		if ("".equals(s))
			return true;
		char[] charAry = s.toCharArray();
		if (charAry.length == 0)
			return false;
		if (charAry.length == 1)
			return true;
		char[] seq = new char[charAry.length];
		char[] rev = new char[charAry.length];
		int seqIdx = 0, revIdex = 0;
		for (int i = 0; i < charAry.length; i++) {
			if (Character.isAlphabetic(charAry[i]) || Character.isDigit(charAry[i]) ) {
				seq[seqIdx++] = Character.toLowerCase(charAry[i]);
			}
			if (Character.isAlphabetic(charAry[charAry.length - i - 1])
					|| Character.isDigit(charAry[charAry.length - i - 1])) {
				rev[revIdex++] = Character.toLowerCase(charAry[charAry.length - i - 1]);
			}
		}
		if (seqIdx != 0 && seqIdx != revIdex)
			return false;

		for (int j = 0; j < seqIdx; j++) {
			if (seq[j] != rev[j])
				return false;
		}
		return true;
	}

}
