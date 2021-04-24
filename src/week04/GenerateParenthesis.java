package week04;

import java.util.ArrayList;
import java.util.List;

/**
 * @author : admin
 * @version V1.0
 * @Project: leecode
 * @Package week04
 * @Description: leecode22 数字 n 代表生成括号的对数，请你设计一个函数，用于能够生成所有可能的并且 有效的 括号组合。
 * @date Date : 2021年04月21日 23:17
 */
public class GenerateParenthesis {
    List<String> res = new ArrayList<>();

    /**
     * 采用递归解法
     *
     * @param n
     * @return
     */
    public List<String> generateParenthesis2(int n) {
        recursion(n, 0, 0, "");
        return res;
    }

    private void recursion(int n, int leftCount, int rightCount, String sb) {
        if (leftCount == n && rightCount == n) {
            System.out.println(sb.toString());
            res.add(sb.toString());
            return;
        }

        if (leftCount <= n) {
            recursion(n, leftCount + 1, rightCount, sb + "(");
        }
        if (leftCount > rightCount) {
            recursion(n, leftCount, rightCount + 1, sb + ")");

        }
    }


    /**
     * 求组合可以用回溯法
     *
     * @param n
     * @return
     */
    public List<String> generateParenthesis(int n) {

        StringBuilder sb = new StringBuilder();
        backTracking(n, 0, 0, sb);
        return res;
    }

    private void backTracking(int n, int left, int right, StringBuilder sb) {
        if (left == n && right == n) {
            System.out.println(sb.toString());
            res.add(sb.toString());
            return;
        }

        if (left < n) {
            sb.append("(");
            this.backTracking(n, left + 1, right, sb);
            sb.deleteCharAt(sb.length() - 1);
        }
        if (left > right) {
            sb.append(")");
            this.backTracking(n, left, right + 1, sb);
            sb.deleteCharAt(sb.length() - 1);
        }

    }


}
