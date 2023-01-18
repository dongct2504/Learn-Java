/*
 * #26 - Given an integer array nums sorted in non-decreasing order, remove the
 * duplicates in-place such that each unique element appears only once. The
 * relative order of the elements should be kept the same. - Since it is
 * impossible to change the length of the array in some languages, you must
 * instead have the result be placed in the first part of the array nums. More
 * formally, if there are k elements after removing the duplicates, then the
 * first k elements of nums should hold the final result. It does not matter
 * what you leave beyond the first k elements. - Return k after placing the
 * final result in the first k slots of nums. - Do not allocate extra space for
 * another array. You must do this by modifying the input array in-place with
 * O(1) extra memory.
 * 
 * - Constraints: 1 <= nums.length <= 3 * 104 -100 <= nums[i] <= 100 nums is
 * sorted in non-decreasing order.
 */

package other.array;

import java.util.Arrays;
import java.util.HashSet;

public class RemoveDuplicatesSorted26 {

	public static void main(String[] args) {
		int[] nums = { 0, 0, 1, 1, 1, 2, 2, 3, 3, 4 };

		System.out.println(Arrays.toString(nums));
		System.out.println(removeDuplicates2(nums));
		System.out.println(Arrays.toString(nums));
	}

	// my solution using HashSet which is NO NO NO because
	// we should use in-place algorithm
	public static int removeDuplicates1(int[] nums) {
		HashSet<Integer> hashSet = new HashSet<>();
		int insertIndex = 0;

		for (int eachElement : nums) {
			if (hashSet.add(eachElement)) {
				nums[insertIndex] = eachElement;
				insertIndex++;
			}
		}

		return insertIndex;
	}

	// better solution
	public static int removeDuplicates2(int[] nums) {
		// index 0 is not duplicate so begin at 1
		int insertIndex = 1;

		for (int i = 1; i < nums.length; i++) {
			if (nums[i] != nums[i - 1]) {
				nums[insertIndex] = nums[i];
				insertIndex++;
			}
		}

		return insertIndex;
	}
}
