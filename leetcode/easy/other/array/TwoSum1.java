/* 
 * #1
 * - Given an array of integers nums and an integer target, 
 * return indices of the two numbers such that they add up to target.
 * - You may assume that each input would have exactly one solution, 
 * and you may not use the same element twice.
 * - You can return the answer in any order
 * 
 * - Constraints:
 * 2 <= nums.length <= 104
 * -109 <= nums[i] <= 109
 * -109 <= target <= 109
 * Only one valid answer exists.
 */

package other.array;

import java.util.Arrays;
import java.util.HashMap;

public class TwoSum1 {

  public static void main(String[] args) {
    // int[] nums = { 2, 7, 11, 15 };
    // int[] nums = { 3, 2, 4 };
    int[] nums = { 3, 3 };

    // System.out.println(Arrays.toString(twoSum1(nums, 6)));
    System.out.println(Arrays.toString(twoSum2(nums, 6)));
  }

  // my soluton. O(n2)
  // ==> Runtime: 5 ms, Memory Usage: 42.4 MB
  public static int[] twoSum1(int[] nums, int target) {
    for (int pass = nums.length - 1; pass > 0; pass--) {
      for (int i = 0; i < pass; i++) {
        if (nums[i] + nums[pass] == target) {
          return (new int[] { i, pass });
        }
      }
    }

    return null;
  }

  // using HashMap. O(n)
  public static int[] twoSum2(int[] nums, int target) {
    HashMap<Integer, Integer> hashMap = new HashMap<>();

    int need = 0;
    for (int i = 0; i < nums.length; i++) {
      need = target - nums[i];

      // if need is exist then return index of need and this index
      // which is add up to target
      if (hashMap.get(need) != null) { // == if (hashMap.containsKey(need))
        return (new int[] { hashMap.get(need), i });
      }

      // add key as the element in array and value as index in array
      hashMap.put(nums[i], i);
    }

    return null;
  }
}