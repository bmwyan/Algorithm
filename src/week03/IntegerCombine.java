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
        if (n < k) {
            return res;
        }

        LinkedList<Integer> list = new LinkedList<>();
        backTracking(n, k, 1, list);

        return res;
    }

    private void backTracking(int n, int k, int startIndex, LinkedList<Integer> list) {
        if (list.size() == k) {
            res.add(new ArrayList<>(list));
            return;
        }

        for (int i = startIndex; i <= n; i++) {
            list.add(i);
            this.backTracking(n, k, i + 1, list);
            list.removeLast();

        }
    }


}
