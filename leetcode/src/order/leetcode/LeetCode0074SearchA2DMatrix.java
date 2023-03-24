package order.leetcode;

/**
 * 编写一个高效的算法来判断m x n矩阵中，是否存在一个目标值。该矩阵具有如下特性：
 *
 * 每行中的整数从左到右按升序排列。
 * 每行的第一个整数大于前一行的最后一个整数。
 *
 * 输入：matrix = [[1,3,5,7],
 *              [10,11,16,20],
 *              [23,30,34,60]], target = 13
 * 输出：false
 *
 * @author tengxq
 */
public class LeetCode0074SearchA2DMatrix {

    /**
     * 思路： 把二维数组拆分成n个有序的一维数组，用二分查找，分别查找数组中是否存在target
     * 时间复杂度：O(nlogn)
     * @param array 二维数组
     * @param target 目标值
     * @return 是否存在目标值
     */
    public boolean searchMatrix1(int[][] array, int target) {
        for (int[] ints : array) {
            if (binarySearch(ints, target)) {
                return true;
            }
        }
        return false;
    }
    public boolean binarySearch(int[] array , int target){
        int p = 0 ;
        int q = array.length-1;
        int mid;
        while(p<=q){
            mid = (p+q)>>>1;
            if(array[mid] > target){
                q = mid -1;
            }else if(array[mid] < target){
                p = mid+1;
            }else{
                return true;
            }
        }
        return false;
    }


    /**
     * 思路： 通过观察可知，将这个有序的二维数组变成一维数组的话，是一个递增有序的数组
     *       那么我们可以通过二分查找的方法来确定数组是否存在target
     * 时间复杂度：logn
     * @param matrix 二维数组
     * @param target 目标值
     * @return 是否存在目标值
     */
    public static boolean searchMatrix2(int[][] matrix, int target) {
        int p = 0;
        int q = matrix.length * matrix[0].length - 1;
        int mid;
        int row;
        int col;
        while (p <= q) {
            mid = p + (q - p >> 1);
            row = mid / matrix[0].length;
            col = mid % matrix[0].length;
            if (matrix[row][col] > target) {
                q = mid - 1;
            } else if (matrix[row][col] < target){
                p = mid + 1;
            } else {
                return true;
            }
        }
        return false;
    }
}
