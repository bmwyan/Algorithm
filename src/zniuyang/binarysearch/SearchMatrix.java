package zniuyang.binarysearch;

/**
 * @author : admin
 * @version V1.0
 * @Project: leecode
 * @Package zniuyang.binarysearch
 * @Description: leecode74 搜索二维矩阵
 * @date Date : 2021年05月05日 14:15
 */
public class SearchMatrix {
    public boolean searchMatrix(int[][] matrix, int target) {
        int m = matrix.length - 1;
        int n = matrix[0].length - 1;
        if (matrix[0][0] > target || matrix[m][n] < target) {
            return false;
        }

        int left = 0, right = matrix.length-1;
        while (left <= right) {
            int mid = left + (right - left) / 2;
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
        right = matrix[0].length-1;
        while (left <= right) {
            int mid = left + (right - left) / 2;
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
