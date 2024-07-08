/**
 * xxx
 *
 * @author tengxq
 */
class Solution {
    public int canCompleteCircuit(int[] gas, int[] cost) {
        for (int i = 0; i < gas.length; i++) {
            int go = go(i, gas, cost);
            if (go == 0) {
                return i;
            }
            i = go;
        }
        return -1;
    }

    public int go(int start, int[] gas, int[] cost) {
        int index = 0;
        int length = gas.length;
        int gasSum = 0;
        for (int i = 0; i < length; i++) {
            index = (i + start) % length;
            gasSum += gas[index];
            // 向前进一步
            gasSum -= cost[index];
            if (gasSum  < 0) {
                return index;
            }
        }
        return 0;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.print(solution.canCompleteCircuit(new int[]{2, 3, 4}, new int[]{3, 4, 3}));
    }
}
