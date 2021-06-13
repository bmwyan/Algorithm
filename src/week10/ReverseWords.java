package week10;

/**
 * @author : admin
 * @version V1.0
 * @Project: leecode
 * @Package week10
 * @Description: leecode557 反转字符串中的单词II
 * @date Date : 2021年06月13日 0:20
 */
public class ReverseWords {

    public String reverseWords(String s) {
        String[] sc = s.split(" ");
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < sc.length; i++) {

            sb.append(new StringBuilder(sc[i]).reverse());
            if (i != sc.length - 1) {
                sb.append(" ");
            }
        }

        return sb.toString();
    }
}
