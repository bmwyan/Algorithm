package week10;

import java.util.HashMap;
import java.util.Map;

/**
 * @author : admin
 * @version V1.0
 * @Project: leecode
 * @Package week10
 * @Description: leecode205 同构字符串
 * @date Date : 2021年06月13日 1:01
 */
public class IsIsomorphic {

    public boolean isIsomorphic(String s, String t) {
        char[] sc = s.toCharArray();
        char[] tc = t.toCharArray();
        int n = sc.length;
        Map<Character, Character> map = new HashMap<>();
        for (int i = 0; i < n; i++) {
            if (map.containsKey(sc[i])) {
                if (tc[i] != map.get(sc[i])) {
                    return false;
                }
            } else if (map.containsValue(tc[i])) {
                return false;
            } else {
                map.put(sc[i], tc[i]);
            }

        }

        return true;
    }
}
