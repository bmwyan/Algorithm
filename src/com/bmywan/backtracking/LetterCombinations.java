package com.bmywan.backtracking;

import java.util.ArrayList;
import java.util.List;

/**
 * @author : admin
 * @version V1.0
 * @Project: leecode17
 * @Package com.bmywan.backtracking
 * @Description: week02
 * @date Date : 2021年04月11日 16:32
 */
public class LetterCombinations {
    String[] mapping = new String[]{"_", "!@#", "abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz"};
    List<String> res = new ArrayList<>();

    public List<String> letterCombinations(String digits) {
        if (digits.length() == 0) {
            return res;
        }
        StringBuilder sb = new StringBuilder();
        backTrace(digits, sb, 0);
        return res;
    }

    private void backTrace(String digits, StringBuilder sb, int index) {
        if (index >= digits.length()) {
            res.add(sb.toString());
            return;
        }

        int s = digits.charAt(index) - '0';
        String letters = mapping[s];
        for (int j = 0; j < letters.length(); j++) {
            char c = letters.charAt(j);
            backTrace(digits, sb.append(c), index + 1);
            sb.deleteCharAt(sb.length() - 1);
        }

    }
}
