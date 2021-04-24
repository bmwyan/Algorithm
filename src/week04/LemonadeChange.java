package week04;

import java.util.ArrayDeque;
import java.util.PriorityQueue;
import java.util.Queue;

/**
 * @author : admin
 * @version V1.0
 * @Project: leecode
 * @Package week04
 * @Description: leecode860 柠檬水找零
 * @date Date : 2021年04月24日 12:58
 */
/*
在柠檬水摊上，每一杯柠檬水的售价为 5 美元。

        顾客排队购买你的产品，（按账单 bills 支付的顺序）一次购买一杯。

        每位顾客只买一杯柠檬水，然后向你付 5 美元、10 美元或 20 美元。你必须给每个顾客正确找零，也就是说净交易是每位顾客向你支付 5 美元。

        注意，一开始你手头没有任何零钱。

        来源：力扣（LeetCode）
        链接：https://leetcode-cn.com/problems/lemonade-change
        著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。

 */
public class LemonadeChange {
    public boolean lemonadeChange(int[] bills) {
        boolean flag = true;
        int five = 0, ten = 0;
        for (int bill : bills) {
            if (bill == 5) five++;
            if (bill == 10) {
                if (five > 0) {
                    five--;
                    ten++;
                } else {
                    return false;
                }
            }
            if (bill == 20) {
                //优先用1张10块，1张5块
                if (ten > 0 && five > 0) {
                    ten--;
                    five--;
                } else if (five >= 3) {
                    //再考虑用3张5块
                    five -= 3;
                } else {
                    return false;
                }
            }
        }
        return flag;
    }


    /**
     * 自己想的一个通用解法，代码太多
     *
     * @param bills
     * @return
     */
    public boolean lemonadeChange2(int[] bills) {
        boolean flag = true;
        //已拥有的钱,逆序，优先找大额
        PriorityQueue<Integer> havedMoney = new PriorityQueue<>((o1, o2) -> {
            return o2 - o1;
        });

        //找零过程中需要添加回来的钱
        PriorityQueue<Integer> add = new PriorityQueue<>((o1, o2) -> {
            return o2 - o1;
        });


        //总共有多少钱
        int rest = 0;
        for (int bill : bills) {
            int needBack = bill - 5;
            if (needBack > rest) {
                return false;
            }
            rest += 5;

            //找零要么是5块，要么是15块
            while (needBack > 0 && !havedMoney.isEmpty()) {
                int back = havedMoney.poll();
                if (back > needBack) {
                    add.add(back);
                    continue;
                }
                needBack -= back;
                if (needBack < 0) {
                    flag = false;
                    return flag;
                }
            }
            havedMoney.addAll(add);
            add.clear();
            havedMoney.add(bill);
        }
        return flag;
    }
}
