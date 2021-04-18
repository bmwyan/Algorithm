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
    private List<List<String>> res = new ArrayList<>();

    public List<List<String>> partition(String s) {
        if (s == null || s.length() == 0) {
            return res;
        }
        LinkedList<String> list = new LinkedList<>();
        int size = s.length();

        backTracking(s, size, 0, list);
        return res;
    }

    private void backTracking(String s, int size, int startIndex, LinkedList<String> list) {
        if (startIndex >= size) {
            res.add(new ArrayList<>(list));
            return;
        }
        for (int i = startIndex; i < size; i++) {
            String temp = s.substring(startIndex, i + 1);
            if (!isValid(temp)) {
                continue;
            }

            list.add(temp);
            this.backTracking(s, size, i + 1, list);
            list.removeLast();
        }
    }

    private boolean isValid(String s) {
        boolean flag = true;
        char[] cs = s.toCharArray();
        int begin = 0;
        int end = s.length() - 1;
        while (begin < end) {
            if (cs[begin++] != cs[end--]) {
                flag = false;
                break;
            }

        }
        return flag;
    }

}
