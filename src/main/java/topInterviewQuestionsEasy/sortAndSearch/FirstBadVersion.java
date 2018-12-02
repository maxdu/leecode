package topInterviewQuestionsEasy.sortAndSearch;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class FirstBadVersion {

	public FirstBadVersion() {

	}

	public static void main(String[] args) {

		FirstBadVersion instance = new FirstBadVersion();

		System.out.println(instance.firstBadVersion(2126753390));

	}
	
	 public int firstBadVersion(int n) {
	        int l = 1, h = n;         //l---低位   h---高位
	        while (l < h) {
	            int mid = l + (h - l) / 2;      //(1)
	            if (isBadVersion(mid))
	                h = mid;                    //(2)
	            else
	                l = mid + 1;                //(3)
	        }
	        return h;
	    }

	public int firstBadVersionSlow(int n) {
		long start = 0;
		long end = n;
		int res = -1;
		while (res != 0) {
			long half = (end + start) / 2;
			res = search(start, end);
			if (res == -1) {
				end = half;
			}
			if (res == 1) {
				start = half;
			}
		}
		return (int) end;
	}

	public int search(long start, long end) {
		System.out.println(String.format("start %s, end %s", start, end));
		if (end - start == 1)
			return 0;
		long half = (end + start) / 2;
		if (isBadVersion((int) half)) {
			return -1;
		} else {
			return 1;
		}

	}

	public boolean isBadVersion(int version) {
		if (version > 1702766719)
			return true;
		else
			return false;
	}

}
