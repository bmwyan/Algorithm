package week06;

/**
 * @author : admin
 * @version V1.0
 * @Project: leecode
 * @Package week06
 * @Description: TODO
 * @date Date : 2021年05月09日 22:11
 */
public class ReplaceSpace {
    public String replaceSpace(String s) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (c == ' ') sb.append("%20");
            else sb.append(c);
        }
        return sb.toString();

    }
}
