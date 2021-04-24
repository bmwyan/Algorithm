package week04;

import java.util.LinkedList;

/**
 * @author : admin
 * @version V1.0
 * @Project: leecode
 * @Package week04
 * @Description: leecode647 回文子串
 * @date Date : 2021年04月20日 0:41
 */
public class CountSubString {
    private Integer count = 0;

    public int countSubstrings(String s) {

        if (s == null || s.length() == 0) {
            return count;
        }
        LinkedList<String> list = new LinkedList<>();
        backTracking(s, 0, list);
        return count;
    }

    private void backTracking(String s, int startIndex, LinkedList<String> list) {

        if (startIndex == s.length()) {
            count++;
            return;
        }

        for (int i = startIndex; i < s.length(); i++) {

            String temp = s.substring(startIndex, i + 1);
            if (!valid(temp)) {
                continue;
            }

            list.add(temp);
            this.backTracking(s, i + 1, list);
            list.removeLast();
        }
    }

    private boolean valid(String temp) {
        char[] array = temp.toCharArray();
        int i = 0, j = temp.length() - 1;
        while (i < j) {
            if (array[i++] != array[j--]) {
                return false;
            }
        }
        return true;
    }
}
