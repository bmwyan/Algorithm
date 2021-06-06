package week09;

/**
 * @author : admin
 * @version V1.0
 * @Project: leecode
 * @Package week09
 * @Description: leecode541 反转字符串II
 * @date Date : 2021年06月02日 23:04
 */
public class ReverseStr {

    public String reverseStr(String s, int k) {
        int n = s.length();
        char[] src = s.toCharArray();
        for (int start = 0; start < n; start += k * 2) {
            int i = start;
            int j = Math.min(n - 1, start + k - 1);
            while(i<j){
                char tmp =src[i];
                src[i++]=src[j];
                src[j--]=tmp;
            }
        }
        return new String(src);
    }

    public String reverseStr2(String s, int k) {
        int n = s.length();
        int cy = 1;
        StringBuilder sb = new StringBuilder();
        StringBuilder tmp = new StringBuilder();
        for (int i = 0; i < n; i++) {
            tmp.append(s.charAt(i));
            if (i + 1 == cy * k || i == n - 1) {
                if (cy % 2 != 0) {
                    sb.append(tmp.reverse());
                } else {
                    sb.append(tmp);
                }
                tmp = new StringBuilder();
                cy++;
            }
        }
        return sb.toString();
    }

}
