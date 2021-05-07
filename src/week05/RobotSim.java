package week05;

import java.util.HashSet;
import java.util.Set;

/**
 * @author : admin
 * @version V1.0
 * @Project: leecode
 * @Package week05
 * @Description: leecode874 模拟行走机器人
 * @date Date : 2021年04月30日 23:08
 */
public class RobotSim {

    public int robotSim(int[] commands, int[][] obstacles) {
        int res = 0;
        //分别代表向北、向东、向南、向西方向
        int[][] directions = {{0, 1}, {1, 0}, {0, -1}, {-1, 0}};
        Set<String> set = new HashSet<>();
        for (int[] row : obstacles) {
            set.add(row[0] + "," + row[1]);

        }

        //起始坐标
        int x = 0, y = 0;
        //当前方向
        int curDirectionIndex = 0;
        for (int command : commands) {
            if (command == -1) {
                //向右转90度
                curDirectionIndex = (curDirectionIndex + 1) % 4;
            } else if (command == -2) {
                //向左转90度
                curDirectionIndex = (curDirectionIndex + 3) % 4;
            } else {
                for (int i = 1; i <= command; i++) {
                    int nextx = x + directions[curDirectionIndex][0];
                    int nexty = y + directions[curDirectionIndex][1];
                    if (set.contains(nextx + "," + nexty)) {
                        break;
                    } else {
                        x = nextx;
                        y = nexty;
                        res = Math.max(res, x * x + y * y);
                    }
                }
            }
        }
        return res;
    }
}
