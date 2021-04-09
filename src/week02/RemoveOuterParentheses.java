package week02;

import java.util.Stack;

/**
 * @author : admin
 * @version V1.0
 * @Project: leecode
 * @Package week02
 * @Description: TODO
 * @date Date : 2021年04月09日 23:52
 */
public class RemoveOuterParentheses {
    /**
     * 易于理解的写法
     *
     * @param S
     * @return
     */
    public String removeOuterParentheses2(String S) {
        StringBuilder sb = new StringBuilder();
        int level = 0;
        for (int i = 0; i < S.length(); i++) {
            if (S.charAt(i) == '(') {

                level++;
                if (level == 1) {
                    continue;
                }
            } else {
                level--;
                if (level == 0) {
                    continue;
                }
            }
            sb.append(S.charAt(i));
        }
        return sb.toString();
    }

    /**
     * 优化方法
     *
     * @param S
     * @return
     */
    public String removeOuterParentheses3(String S) {
        StringBuilder sb = new StringBuilder();
        int level = 0;
        for (char c : S.toCharArray()) {
            if (c == '(') level++;
            if (level > 1) {
                sb.append(c);
            }
            if (c == ')') level--;
        }
        return sb.toString();
    }

    /**
     * 采用栈的方式来求解
     *
     * @param S
     * @return
     */
    public String removeOuterParentheses(String S) {
        StringBuilder sb = new StringBuilder();
        Stack<Character> stack = new Stack<>();
        //每个原语括号的位置
        int start = 0;
        int end = 0;
        boolean flag = false;//标识每个原语

        for (int i = 0; i < S.length(); i++) {
            char c = S.charAt(i);
            if (c == '(') {
                stack.push(c);
                if (!flag) {
                    start = i;
                    flag = true;
                }

            }
            if (c == ')') {
                stack.pop();
                if (stack.isEmpty()) {
                    end = i;
                    sb.append(S.substring(start + 1, end));
                    flag = false;
                    //start = end;
                }
            }
        }

        return sb.toString();
    }
}
