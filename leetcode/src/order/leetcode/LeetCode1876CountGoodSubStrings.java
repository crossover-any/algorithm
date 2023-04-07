package order.leetcode;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * 如果一个字符串不含有任何重复字符，我们称这个字符串为 好字符串。
 * <p>
 * 给你一个字符串 s，请你返回 s中长度为 3的 好子字符串 的数量。
 * <p>
 * 注意，如果相同的好子字符串出现多次，每一次都应该被记入答案之中。
 * <p>
 * 子字符串 是一个字符串中连续的字符序列。
 * <p>
 * <p>
 * <p>
 * 示例 1：
 * <p>
 * 输入：s = "xyzzaz"
 * 输出：1
 * 解释：总共有 4 个长度为 3 的子字符串："xyz"，"yzz"，"zza" 和 "zaz" 。
 * 唯一的长度为 3 的好子字符串是 "xyz" 。
 *
 * @author tengxq
 */
public class LeetCode1876CountGoodSubStrings {

    public int countGoodSubstrings(String s) {
        int count = 0;
        int length = s.length();
        Map<Character, Integer> dic = new HashMap<>(3);
        for (int i = 0; i < length; i++) {
            char key = s.charAt(i);
            if (i < 2) {
                dic.put(key, dic.getOrDefault(key, 0) + 1);
                continue;
            }
            if (dic.size() == 2 && !dic.containsKey(key)) {
                count++;
            }
            dic.put(key, dic.getOrDefault(key, 0) + 1);
            Integer v = dic.get(s.charAt(i - 2));
            if (v == 1) {
                dic.remove(s.charAt(i - 2));
            } else {
                dic.put(s.charAt(i - 2), v - 1);
            }
        }
        return count;
    }

    public int countGoodSubstrings1(String s) {
        int count = 0;
        int n = s.length() - 2;
        for (int i = 0; i < n; i++) {
            if (s.charAt(i) != s.charAt(i + 1) && s.charAt(i) != s.charAt(i + 2) && s.charAt(i + 1) != s.charAt(i + 2)) {
                count++;
            }
        }
        return count;
    }

    public static void main(String[] args) {
        LeetCode1876CountGoodSubStrings solution = new LeetCode1876CountGoodSubStrings();
        System.out.println(solution.countGoodSubstrings("xyzzaz"));
    }
}
