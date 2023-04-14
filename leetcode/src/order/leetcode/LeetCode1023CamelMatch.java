package order.leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 * 如果我们可以将小写字母插入模式串pattern得到待查询项query，那么待查询项与给定模式串匹配。（我们可以在任何位置插入每个字符，也可以插入 0 个字符。）
 *
 * 给定待查询列表queries，和模式串pattern，返回由布尔值组成的答案列表answer。只有在待查项queries[i] 与模式串pattern 匹配时，answer[i]才为 true，否则为 false。
 *
 *
 *
 * 示例 1：
 *
 * 输入：queries = ["FooBar","FooBarTest","FootBall","FrameBuffer","ForceFeedBack"], pattern = "FB"
 * 输出：[true,false,true,true,false]
 * 示例：
 * "FooBar" 可以这样生成："F" + "oo" + "B" + "ar"。
 * "FootBall" 可以这样生成："F" + "oot" + "B" + "all".
 * "FrameBuffer" 可以这样生成："F" + "rame" + "B" + "uffer".
 * 示例 2：
 *
 * 输入：queries = ["FooBar","FooBarTest","FootBall","FrameBuffer","ForceFeedBack"], pattern = "FoBa"
 * 输出：[true,false,true,false,false]
 * 解释：
 * "FooBar" 可以这样生成："Fo" + "o" + "Ba" + "r".
 * "FootBall" 可以这样生成："Fo" + "ot" + "Ba" + "ll".
 *
 *
 * @author tengxq
 */
public class LeetCode1023CamelMatch {

    public List<Boolean> camelMatch(String[] queries, String pattern) {
        int p;
        int q;
        List<Boolean> list = new ArrayList<>();
        for (String query : queries) {
            int patternLength = pattern.length();
            int queryLength = query.length();
            if (queryLength < patternLength) {
                list.add(false);
                continue;
            }
            q = 0;
            p = 0;
            for (; q < queryLength; q++) {
                // 如果pattern还没未匹配完，并且与query匹配上，则匹配下一个字符
                if (p < patternLength && query.charAt(q) == pattern.charAt(p)) {
                    p++;
                } else if (query.charAt(q) < 'a') {
                    // 两种情况，第一种pattern还未匹配完，遇到了大写的未匹配上的字符
                    //         第二种patter匹配完成了，遇到了大写的未匹配上的字符
                    break;
                }
            }
            list.add(p == patternLength && q == queryLength);
        }
        return list;
    }
}
