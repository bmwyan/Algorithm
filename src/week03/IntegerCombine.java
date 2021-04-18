package week03;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * @author : admin
 * @version V1.0
 * @Project: leecode
 * @Package week03
 * @Description: leecode77 组合
 * @date Date : 2021年04月18日 11:57
 */
public class IntegerCombine {

    private List<List<Integer>> res = new ArrayList<>();

    public List<List<Integer>> combine(int n, int k) {
        LinkedList<Integer> li = new LinkedList<>();
        backTracking(n, 1, k, li);
        return res;

    }

    private void backTracking(int n, int begin, int k, LinkedList<Integer> li) {

        if (k == 0) {
            res.add(new ArrayList<>(li));
            return;
        }

        if (n == begin) {
            return;

        }

        for (int i = begin; i <= n; i++) {
            li.add(begin);
            backTracking(n, i + 1, k-1, li);
            li.removeLast();
        }

    }
}
