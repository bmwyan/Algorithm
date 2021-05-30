package week08.day;

/**
 * @author : admin
 * @version V1.0
 * @Project: leecode
 * @Package week08.day
 * @Description: leecode1122 数组的相对排序
 * @date Date : 2021年05月30日 23:16
 */
public class RelativeSortArray {
    public int[] relativeSortArray(int[] arr1, int[] arr2) {

        //采用计数排序
        int[] res = new int[arr1.length];
        int[] cs = new int[1001];
        //对内容进行计数
        for (int arr : arr1) {
            cs[arr] += 1;
        }
        int i = 0;
        for (int arr : arr2) {
            while (cs[arr] > 0) {
                res[i++] = arr;
                cs[arr]--;
            }
        }

        //找出不在里面的内容
        for (int j = 0; j < cs.length; j++) {
            while (cs[j] > 0) {
                res[i++] = j;
                cs[j]--;
            }
        }
        return res;
    }
}
