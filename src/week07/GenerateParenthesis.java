package week07;

import java.util.ArrayList;
import java.util.List;

/**
 * @author : admin
 * @version V1.0
 * @Project: leecode
 * @Package week07
 * @Description: leecode22 括号生成
 * @date Date : 2021年05月23日 12:58
 */
public class GenerateParenthesis {

    List<String> res = new ArrayList<>();

    public List<String> generateParenthesis(int n) {

        recurse(n, 0, 0, "");
        return res;
    }

    private void recurse(int n, int leftCount, int rightCount, String sb) {

        if (leftCount == n && rightCount == n) {
            res.add(sb);
            return;
        }

        if (leftCount <= n) {
            recurse(n, leftCount + 1, rightCount, sb + "(");
        }
        if (rightCount < leftCount) {
            recurse(n, leftCount, rightCount+1, sb + ")");
        }

    }

}
