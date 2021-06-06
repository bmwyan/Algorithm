package week09;

import java.util.HashMap;
import java.util.Map;

/**
 * @author : admin
 * @version V1.0
 * @Project: leecode
 * @Package week09
 * @Description: leecode205 同构字符串
 * @date Date : 2021年05月31日 23:45
 */
public class Isomorphic {

    public boolean isIsomorphic(String s, String t) {

        //key:value =s.charAt(i) :t.charAt(i)
        Map<Character, Character> map = new HashMap<>();
        int len = s.length();
        for (int i = 0; i < len; i++) {
            Character sc = s.charAt(i);
            Character tc = t.charAt(i);
            if (!map.containsKey(sc)) {
                if (map.containsValue(tc)) {
                    return false;
                }
                map.put(sc, tc);
            } else {
                if (map.get(sc) != tc) {
                    return false;
                }
            }

        }
        return true;
    }
}
