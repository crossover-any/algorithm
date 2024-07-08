package order.leetcode;

import java.util.*;
import java.util.stream.Collectors;

/**
 * 给你一个仅由小写英文字母组成的字符串 s 。
 * <p>
 * 如果一个字符串仅由单一字符组成，那么它被称为 特殊 字符串。例如，字符串 "abc" 不是特殊字符串，而字符串 "ddd"、"zz" 和 "f" 是特殊字符串。
 * <p>
 * 返回在 s 中出现 至少三次 的 最长特殊子字符串 的长度，如果不存在出现至少三次的特殊子字符串，则返回 -1 。
 * <p>
 * 子字符串 是字符串中的一个连续 非空 字符序列。
 * 示例 1：
 * <p>
 * 输入：s = "aaaa"
 * 输出：2
 * 解释：出现三次的最长特殊子字符串是 "aa" ：子字符串 "aaaa"、"aaaa" 和 "aaaa"。
 * 可以证明最大长度是 2 。
 * 示例 2：
 * <p>
 * 输入：s = "abcdef"
 * 输出：-1
 * 解释：不存在出现至少三次的特殊子字符串。因此返回 -1 。
 * 示例 3：
 * <p>
 * 输入：s = "abcaba"
 * 输出：1
 * 解释：出现三次的最长特殊子字符串是 "a" ：子字符串 "abcaba"、"abcaba" 和 "abcaba"。
 * 可以证明最大长度是 1 。
 *
 * @author tengxq
 */
public class LeetCode2982MaxMumLenth {

    public static void main(String[] args) {
        LeetCode2982MaxMumLenth solution = new LeetCode2982MaxMumLenth();
        System.out.println(solution.maximumLength("akphhppppp"));
    }

    public int maximumLength(String s) {
        int max = -1;
        char[] array = s.toCharArray();
        List<Integer>[] ch = new List[26];
        // 初始化数组
        for (int i = 0; i < 26; i++) {
            ch[i] = new ArrayList<>();
        }
        int count = 0;
        // 遍历字符串
        for (int i = 0; i < array.length; i++) {
            count++;
            if (i == array.length - 1 || array[i] != array[i + 1]) {
                List<Integer> list = ch[array[i] - 'a'];
                list.add(count);
                count = 0;
                // 排序
                if (list.size() > 1) {
                    for (int i1 = list.size() -1 ; i1 > 0; i1--) {
                        if (list.get(i1) > list.get(i1 -1)) {
                            Collections.swap(list, i1, i1-1);
                        }
                    }
                }
                if (list.size() > 3) {
                    list.remove(3);
                }
            }
        }
        // 计算最大长度
        for (List<Integer> list : ch) {
            if (list.size() > 0 && list.get(0) > 2) {
                max = Math.max(max, list.get(0) - 2);
            }
            if (list.size() > 1 && list.get(0) > 1) {
                max = Math.max(max, Math.min(list.get(0) - 1, list.get(1)));
            }
            if (list.size() > 2) {
                max = Math.max(max, list.get(2));
            }
        }
        return max;
    }
}
