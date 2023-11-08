package order.leetcode;

/**
 * xxx
 *
 * @author tengxq
 */
public class LeetCode0080RemoveDuplicates {

    public int removeDuplicates(int[] nums) {
        int count = 1;
        int num = nums[0];
        int index = 1;
        for (int i = 1; i < nums.length; i++) {
            if (num == nums[i]) {
                count++;
                if (count < 3) {
                    nums[index++] = nums[i];
                }
            } else {
                count = 1;
                num = nums[i];
                nums[index++] = nums[i];
            }
        }
        return index;
    }

    public static void main(String[] args) {
        LeetCode0080RemoveDuplicates solution = new LeetCode0080RemoveDuplicates();
        System.out.println(solution.removeDuplicates(new int[]{0,0,1,1,1,1,2,3,3}));
    }
}
