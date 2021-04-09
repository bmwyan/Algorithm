package week02;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class GetHint {
    /**
     * 采用双数组的方式
     *
     * @param secret
     * @param guess
     * @return
     */
    public String getHint2(String secret, String guess) {
        int bulls = 0;
        int cows = 0;
        int[] sec = new int[10];
        int[] gus = new int[10];

        for (int i = 0; i < secret.length(); i++) {
            int s = secret.charAt(i) - '0';
            int g = guess.charAt(i) - '0';
            if (s == g) {
                bulls++;
            } else {
                sec[s]++;
                gus[g]++;
            }
        }

        for (int i = 0; i < sec.length; i++) {
            cows += Math.min(sec[i], gus[i]);
        }

        return new StringBuilder().append(bulls).append("A").append(cows).append("B").toString();
    }


    /**
     * 采用单数据方式进行优化
     *
     * @param secret
     * @param guess
     * @return
     */
    public String getHint(String secret, String guess) {
        int bulls = 0;
        int cows = 0;

        int[] sec = new int[10];
        for (int i = 0; i < secret.length(); i++) {
            int s = secret.charAt(i) - '0';
            int g = guess.charAt(i) - '0';
            if (s == g) {
                bulls++;
            } else {
                if (sec[s]++ < 0) cows++;
                if (sec[g]-- > 0) cows++;

            }
        }
        return new StringBuilder().append(bulls).append("A").append(cows).append("B").toString();
    }
}
