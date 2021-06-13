package week10;

import java.util.HashSet;
import java.util.Set;

/**
 * @author : admin
 * @version V1.0
 * @Project: leecode
 * @Package week10
 * @Description: leecode771 宝石与石头
 * @date Date : 2021年06月08日 23:11
 */
public class NumJewelsInStones {

    public int numJewelsInStones(String jewels, String stones) {
        Set<Character> set = new HashSet<>();
        char[] typeA= jewels.toCharArray();
        for(Character c : typeA)
        {
            set.add(c);
        }
        int count=0;
        for(int i=0;i<stones.length();i++){
            if(set.contains(stones.charAt(i))){
                count++;
            }
        }
     return count;
    }
}
