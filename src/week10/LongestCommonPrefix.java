package week10;

/**
 * @author : admin
 * @version V1.0
 * @Project: leecode
 * @Package week10
 * @Description: leecode14 最长公共前缀
 * @date Date : 2021年06月08日 23:24
 */
public class LongestCommonPrefix {
    public String longestCommonPrefix(String[] strs) {
        int length = strs.length;
        if (length == 0) {
            return "0";
        }
        String ans = strs[0];
        for (int i = 1; i < length; i++) {
            int j = 0;
            for (; j < ans.length() && j < strs[i].length(); j++) {
                if (ans.charAt(j) != strs[i].charAt(j)) {
                    break;
                }
            }
            ans = ans.substring(0, j);
            if (ans.equals("")) {
                return ans;
            }

        }

        return ans;
    }
}
