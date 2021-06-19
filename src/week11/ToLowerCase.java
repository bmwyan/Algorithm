package week11;

/**
 * @author : admin
 * @version V1.0
 * @Project: leecode
 * @Package week11
 * @Description: leecode 709 转换成小写字赠
 * @date Date : 2021年06月14日 23:19
 */
public class ToLowerCase {
    public String toLowerCase(String s) {
        char[] sc = s.toCharArray();

        for (int i = 0; i < sc.length; i++) {
            char c = sc[i];
            if (c >= 'A' && c <= 'Z') {
                sc[i] = (char) (sc[i] - 'A' + 'a');
            }
        }
        return new String(sc);
    }

}
