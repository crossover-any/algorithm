package order.leetcode;

import java.util.Deque;
import java.util.LinkedList;

/**
 * 你会得到一个字符串text。你应该把它分成 k个子字符串(subtext1, subtext2，…， subtextk)，要求满足:
 *
 * subtexti是 非空字符串
 * 所有子字符串的连接等于 text ( 即subtext1+ subtext2+ ... + subtextk== text)
 * 对于所有 i的有效值( 即1 <= i<= k ) ，subtexti== subtextk - i + 1 均成立
 * 返回k可能最大值。
 *
 * @author tengxq
 */
public class LeetCode1147LongestDecomposition {

    public int longestDecomposition(String text) {
        int ans = 0;
        Deque<Character> deque = new LinkedList<>();
        for (int i = 0, len = text.length(); i < len; i++) {
            if (deque.isEmpty()) {
                ans++;
            }
            char head = text.charAt(i);
            char tail = text.charAt(len-i-1);
            if (!deque.isEmpty() && head == deque.peekLast()) {
                deque.removeLast();
            } else {
                deque.add(head);
            }
            if (!deque.isEmpty() && tail ==deque.peekLast()) {
                deque.removeLast();
            } else {
                deque.add(tail);
            }
        }
        return ans;
    }

    public int longestDecomposition2(String s) {
        if (s.isEmpty())
            return 0;
        for (int i = 1, n = s.length(); i <= n / 2; ++i) // 枚举前后缀长度
            if (s.substring(0, i).equals(s.substring(n - i))) // 立刻分割
                return 2 + longestDecomposition2(s.substring(i, n - i));
        return 1; // 无法分割
    }
}
