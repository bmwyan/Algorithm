package week06;

/**
 * @author : admin
 * @version V1.0
 * @Project: leecode
 * @Package week06
 * @Description: leecode74 搜索二维矩阵
 * @date Date : 2021年05月04日 23:15
 */
public class SearchMatrix {

    public boolean searchMatrix(int[][] matrix, int target) {
        int rows = matrix.length - 1;
        int cols = matrix[0].length - 1;
        int row = 0;
        int col = 0;
        while (row <= rows && col <= cols) {
            if (matrix[row][col] == target) {
                return true;
            } else if (matrix[row][cols] < target) {
                row++;
            } else {
                col++;
            }
        }
        return false;
    }


    public boolean searchMatrix2(int[][] matrix, int target) {
        int m = matrix.length - 1;
        int n = matrix[0].length - 1;
        if (matrix[0][0] > target || matrix[m][n] < target) {
            return false;
        }

        int left = 0, right = matrix.length - 1;

        //优先获取在哪一行
        int mid = 0;
        while (left <= right) {
            mid = left + (right - left) / 2;
            if (matrix[mid][0] == target) {
                return true;
            } else if (matrix[mid][0] < target) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        int row = left - 1;

        left = 0;
        right = n;
        while (left <= right) {
            mid = left + (right - left) / 2;
            if (matrix[row][mid] == target) {
                return true;
            } else if (matrix[row][mid] < target) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }

        return false;
    }
}
