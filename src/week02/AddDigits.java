package week02;

/**
 * @author : admin
 * @version V1.0
 * @Project: leecode
 * @Package week02
 * @Description: TODO
 * @date Date : 2021年04月11日 14:06
 */
public class AddDigits {

    /**
     * 采用递归方式
     *
     * @param num
     * @return
     */
    public int addDigits(int num) {
        int sum = 0;
        while (num != 0) {
            sum += num % 10;
            num = num / 10;

        }
        if (sum < 10) {
            return sum;
        }
        return this.addDigits(sum);
    }

    /**
     * 数据解法
     *
     * @param num
     * @return
     */
    public int addDigits2(int num) {
        return (num - 1) % 9 + 1;
    }

    /**
     * 迭代方式
     *
     * @param num
     * @return
     */
    public int addDigits3(int num) {
        int sum = 0;
        while (true) {
            sum += num % 10;
            num = num / 10;
            if (num == 0) {
                if (sum < 10) {
                    break;
                } else {
                    num = sum;
                    sum = 0;
                }
            }
        }
        return sum;
    }

}
