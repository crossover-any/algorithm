package order.leetcode;


import java.util.Deque;
import java.util.LinkedList;

/**
 * 给你一个以字符串表示的非负整数num 和一个整数 k ，移除这个数中的 k 位数字，使得剩下的数字最小。请你以字符串形式返回这个最小的数字。
 * <p>
 * <p>
 * 示例 1 ：
 * <p>
 * 输入：num = "1432219", k = 3
 * 输出："1219"
 * 解释：移除掉三个数字 4, 3, 和 2 形成一个新的最小的数字 1219 。
 * 示例 2 ：
 * <p>
 * 输入：num = "10200", k = 1
 * 输出："200"
 * 解释：移掉首位的 1 剩下的数字为 200. 注意输出不能有任何前导零。
 *
 * @author tengxq
 */
public class LeetCode0402RemoveKDigits {
    /**
     * 思路：
     * 移除K位，使得数字最小。
     * 假设移除1位使得数字最小
     * 移除后应使得高位尽可能小，
     * 所以我们维护一个递增的栈（从底到顶），如果入栈元素比栈顶元素小，移除栈顶元素让较小的元素占据高位
     * 如果入栈元素比栈顶元素大，则入栈保持该元素的位置
     *
     * @param num 数字
     * @param k   移除个数
     * @return 最小数字
     */
    public String removeKdigits(String num, int k) {
        Deque<Character> stack = new LinkedList<>();
        for (int i = 0; i < num.length(); i++) {
            char c = num.charAt(i);
            while (k > 0 && !stack.isEmpty() && stack.peek() > c) {
                stack.pop();
                k--;
            }
            stack.push(c);
        }
        // 如果移除的数字小于K,继续移除
        while (k > 0) {
            stack.pop();
            k--;
        }
        // 处理前导0
        while (!stack.isEmpty() && stack.peekLast() == '0') {
            stack.removeLast();
        }
        char[] charArray = new char[stack.size()];
        for (int i = charArray.length -1; i >= 0 ; i--) {
            charArray[i] = stack.pop();
        }
        num = new String(charArray);
        return num.length() == 0? "0": num;
    }
}
