/*
 * #13
 * - Roman numerals are represented by seven different 
 * symbols: I, V, X, L, C, D and M.
 * 
 * Symbol       Value
 * I             1
 * V             5
 * X             10
 * L             50
 * C             100
 * D             500
 * M             1000
 * 
 * - Roman numerals are usually written largest to smallest 
 * from left to right. However, the numeral for four is not 
 * IIII. Instead, the number four is written as IV. Because 
 * the one is before the five we subtract it making four. 
 * The same principle applies to the number nine, which is 
 * written as IX. There are six instances where subtraction is used:
 *    I can be placed before V (5) and X (10) to make 4 and 9. 
 *    X can be placed before L (50) and C (100) to make 40 and 90. 
 *    C can be placed before D (500) and M (1000) to make 400 and 900.
 * - Given a roman numeral, convert it to an integer.
 * 
 * - Constraints:
 * 1 <= s.length <= 15
 * s contains only the characters ('I', 'V', 'X', 'L', 'C', 'D', 'M').
 * It is guaranteed that s is a valid roman numeral in the range [1, 3999].
 */

package other.string;

public class RomanToInteger13 {

  public static void main(String[] args) {
    // String s = "III";
    // String s = "LVIII";
    String s = "MCMXCIV";

    System.out.println(romanToInt(s));
  }

  // my solution: Problem is simpler to solve by working 
  // the string from back to front and using a map
  public static int romanToInt(String s) {
    int value = valueOfRomanChar(s.charAt(s.length() - 1));

    for (int i = s.length() - 1; i > 0; i--) {
      int frontChar = valueOfRomanChar(s.charAt(i));
      int afterChar = valueOfRomanChar(s.charAt(i - 1));

      if (frontChar > afterChar) {
        value -= afterChar;
      } else {
        value += afterChar;
      }
    }

    return value;
  }

  private static int valueOfRomanChar(char romanChar) {
    switch (romanChar) {
    case 'I':
      return 1;
    case 'V':
      return 5;
    case 'X':
      return 10;
    case 'L':
      return 50;
    case 'C':
      return 100;
    case 'D':
      return 500;
    case 'M':
      return 1000;
    default:
      return 0;
    }
  }
}