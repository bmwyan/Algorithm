package com.bmywan.backtracking;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * @author : admin
 * @version V1.0
 * @Project: leecode
 * @Package com.bmywan.backtracking
 * @Description: leecode131 分割回文串
 * @date Date : 2021年04月18日 22:05
 */
public class Partition {

    List<List<String>> res = new ArrayList<>();

    public List<List<String>> partition(String s) {
        if (s == null || s.length() == 0) {
            return res;
        }

        LinkedList<String> list = new LinkedList<>();

        backTracking(s, 0, list);

        return res;

    }

    private void backTracking(String s, int startIndex, LinkedList<String> list) {

        if (startIndex == s.length()) {
            res.add(new ArrayList<>(list));
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
        boolean flag = true;
        char[] array = temp.toCharArray();
        int i = 0, j = temp.length() - 1;
        while (i < j) {
            if (array[i++] != array[j--]) {
                return false;
            }
        }
        return flag;
    }

}
