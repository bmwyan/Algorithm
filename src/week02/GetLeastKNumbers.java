package week02;

import java.util.Arrays;
import java.util.PriorityQueue;

/**
 * @author : admin
 * @version V1.0
 * @Project: leecode
 * @Package week02
 * @Description: TODO
 * @date Date : 2021年04月11日 14:26
 */
public class GetLeastKNumbers {

    /**
     * 采用优先级队列方式
     * @param arr
     * @param k
     * @return
     */
    public int[] getLeastNumbers(int[] arr, int k) {
        if (arr.length < k) {
            return arr;
        }
        int[] res = new int[k];

        PriorityQueue<Integer> queue = new PriorityQueue<>();
        for(int a:arr){
            queue.add(a);
        }
        for(int i=0;i<k;i++){
            res[i]=queue.poll();
        }

        return res;
    }
    /**
     * 采用优先级队列方式
     * @param arr
     * @param k
     * @return
     */
    public int[] getLeastNumbers2(int[] arr, int k) {
        if (arr.length < k) {
            return arr;
        }
        int[] res = new int[k];
        Arrays.sort(arr);
        System.arraycopy(arr,0,res,0,k);
        return res;
    }
}
