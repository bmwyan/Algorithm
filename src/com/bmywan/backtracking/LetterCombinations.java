package com.bmywan.backtracking;

import com.sun.jdi.ArrayReference;

import java.util.ArrayList;
import java.util.Arrays;
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

    private String[] mappins = new String[]{"", "!@#", "abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz"};
    List<String> res = new ArrayList<>();

    /**
     * 回溯法
     *
     * @param digits
     * @return
     */
    public List<String> letterCombinations2(String digits) {
        int size = digits.length();
        if (size == 0) {
            return res;
        }
        StringBuilder sb = new StringBuilder();
        backTracking(digits, 0, sb);
        return res;
    }

    private void backTracking(String digits, int index, StringBuilder sb) {
        if (index == digits.length()) {
            res.add(sb.toString());
            return;
        }
        int digit = digits.charAt(index) - '0';
        String letters = mappins[digit];

        for (char letter : letters.toCharArray()) {
            this.backTracking(digits, index + 1, sb.append(String.valueOf(letter)));
            sb.deleteCharAt(sb.length() - 1);
        }

    }


    /**
     * 采用递归解法
     *
     * @param digits
     * @return
     */
    public List<String> letterCombinations(String digits) {

        List<String> result = new ArrayList<>();

        //递归终止条件
        int size = digits.length();
        if (size == 0) {
            return result;
        }

        //递归条件
        int digit = digits.charAt(0) - '0';
        String letters = mappins[digit];

        if (digits.length() == 1) {
            for (char c : letters.toCharArray()) {
                result.add(String.valueOf(c));
            }
            return result;
        }

        List<String> rests = letterCombinations(digits.substring(1));
        for (int i = 0; i < letters.length(); i++) {
            for (String rest : rests) {
                result.add(String.valueOf(letters.charAt(i)) + rest);
            }
        }
        return result;
    }

}
