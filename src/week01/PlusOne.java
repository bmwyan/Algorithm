package week01;

public class PlusOne {
    public int[] plusOne(int[] digits) {
        for(int i=digits.length-1;i>=0;i--)
        {
            int temp = digits[i]+1;
            if(temp%10==0)
            {
                digits[i]=0;
            }else{
                digits[i]=temp;
                return digits;
            }
        }
        if(digits[0]==0)
        {
            digits = new int[digits.length+1];
            digits[0]=1;
        }
        return digits;
    }
}
