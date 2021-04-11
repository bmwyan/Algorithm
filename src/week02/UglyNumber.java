package week02;

/**
 * @author : admin
 * @version V1.0
 * @Project: leecode
 * @Package week02
 * @Description: TODO
 * @date Date : 2021年04月10日 18:49
 */
public class UglyNumber {

    public int nthUglyNumber(int n) {

        int[] dp = new int[n];

        dp[0]=1;
        int a=0;
        int b=0;
        int c=0;
        for(int i=1;i<n;i++){
            int n2=a*2;
            int n3=b*3;
            int n5=c*5;
            dp[i] = Math.min(Math.min(n2,n3),n5);
            if(dp[i]==n2){
                a++;
            }
            if(dp[i]==n3){
                b++;
            }
            if(dp[i]==n5){
               c++;
            }

        }
        return dp[n-1];
    }
}
