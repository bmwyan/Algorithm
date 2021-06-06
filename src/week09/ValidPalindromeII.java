package week09;

/**
 * @author : admin
 * @version V1.0
 * @Project: leecode
 * @Package week09
 * @Description: leecode680 验证回文字符串II
 * @date Date : 2021年06月05日 21:35
 */
public class ValidPalindromeII {

    public boolean validPalindrome(String s) {
        int n = s.length();
        int left = 0, right = n - 1;
        //不满足回文字符串个数
        int wr = 0;
        while (left < right) {
            if (s.charAt(left) != s.charAt(right)) {
                return validPalind(s, left, right - 1) || validPalind(s, left + 1, right);
            }
            left++;
            right--;
        }
        return true;

    }

    private boolean validPalind(String s, int left, int right) {
        while (left < right) {
            if (s.charAt(left) != s.charAt(right)) {
                return false;
            }
            left++;
            right--;
        }
        return true;
    }
}
