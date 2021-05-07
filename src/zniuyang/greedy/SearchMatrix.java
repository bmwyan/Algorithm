package zniuyang.greedy;

/**
 * @author : admin
 * @version V1.0
 * @Project: leecode
 * @Package zniuyang.greedy
 * @Description: leecode74 搜索二维矩阵
 * @date Date : 2021年05月05日 14:08
 */
public class SearchMatrix {
    public boolean searchMatrix(int[][] matrix, int target) {
        int row = 0;
        int cols = matrix[0].length;
        int col = 0;
        while (row < matrix.length && col < cols) {
            if (matrix[row][col] == target) return true;
            if (matrix[row][cols - 1] < target) {
                row++;
            } else {
                col++;
            }
        }

        return false;
    }
}
