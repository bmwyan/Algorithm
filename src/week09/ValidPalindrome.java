package week09;

import java.util.Locale;

/**
 * @author : admin
 * @version V1.0
 * @Project: leecode
 * @Package week09
 * @Description: leecode125 验证回文字符串
 * @date Date : 2021年06月05日 22:13
 */
public class ValidPalindrome {

    public boolean isPalindrome(String s) {
        int n = s.length();
        char[] sc = s.toLowerCase().toCharArray();
        int left = 0, right = n - 1;
        while (left < right) {

            if (!isCharAndDigits(sc[left])) {
                left++;
                continue;
            }
            if (!isCharAndDigits(sc[right])) {
                right--;
                continue;
            }

            if (sc[left] != sc[right]) {
                return false;
            }
            left++;
            right--;
        }
        return true;
    }

    public boolean isCharAndDigits(char c) {
        return (c >= '0' && c <= '9') || (c >= 'a' && c <= 'z');
    }
}
