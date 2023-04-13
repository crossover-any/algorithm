package order.leetcode;

/**
 * 给定两个字符串 s 和 t，它们只包含小写字母。
 *
 * 字符串 t由字符串 s 随机重排，然后在随机位置添加一个字母。
 *
 * 请找出在 t中被添加的字母。
 *
 *
 *
 * 示例 1：
 *
 * 输入：s = "abcd", t = "abcde"
 * 输出："e"
 * 解释：'e' 是那个被添加的字母。
 * 示例 2：
 *
 * 输入：s = "", t = "y"
 * 输出："y"
 *
 * @author tengxq
 */
public class LeetCode0389FindTheDifference {

    public char findTheDifference(String s, String t) {
        int xor = 0;
        for (int i = 0, len = s.length(); i < len; i++) {
            xor ^= s.charAt(i);
        }
        for (int i = 0, len = t.length(); i < len; i++) {
            xor ^= t.charAt(i);
        }
        return (char) xor;
    }
}
