package topInterviewQuestionsEasy.arrays;

/**
 * https://leetcode-cn.com/explore/interview/card/top-interview-questions-easy/1
 * /array/21/
 */
public class RemoveDuplicatedValue {

	public static void main(String[] args) throws InterruptedException {
		RemoveDuplicatedValue instance = new RemoveDuplicatedValue();
		int nums[] = { 0, 0, 1, 1, 1, 2, 2, 3, 3, 4 };
		int result = instance.removeDuplicates(nums);
		for (int i = 0; i < result; i++) {
			System.out.println(nums[i]);
		}
	}

	public int removeDuplicates(int[] nums) throws InterruptedException {

		int temp = nums[0];
		int filler = nums[0] == 0 ? -1 : nums[0] * -1;
		int actualSize = nums.length;

		for (int i = 1; i < nums.length;) {
			if (nums[i] == temp && nums[i] != filler) {

				for (int j = i; j < nums.length - i; j++) {
					nums[j] = nums[j + 1];
				}
				for (int j = nums.length - 1; j > nums.length - 1 - i; j--) {
					nums[j] = filler;
				}
				actualSize--;

				// debug
				for (int num : nums) {
					System.out.print(num);
				}
				System.out.println();
				Thread.sleep(300);

			} else {
				temp = nums[i];
				i++;
			}
		}
		return actualSize;
	}

}
