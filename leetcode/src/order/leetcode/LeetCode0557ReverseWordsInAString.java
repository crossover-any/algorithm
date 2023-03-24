package order.leetcode;

/**
 * 给定一个字符串s，你需要反转字符串中每个单词的字符顺序，同时仍保留空格和单词的初始顺序。
 *
 *
 *
 * 示例 1：
 *
 * 输入：s = "Let's take LeetCode contest"
 * 输出："s'teL ekat edoCteeL tsetnoc"
 * 示例 2:
 *
 * 输入： s = "God Ding"
 * 输出："doG gniD"
 *
 * @author tengxq
 */
public class LeetCode0557ReverseWordsInAString {

    public  String reverseWords(String s) {
        char[] array = s.toCharArray();
        int length = s.length();
        int left;
        int right;
        for (int i = 0; i < length; i++) {
            // 记录起点位置
            left = i;
            while (i < length && array[i] != ' ') {
                i++;
            }
            // 终点位置
            right = i - 1;
            reverse(array, left, right);
        }
        return new String(array);
    }

    public  void reverse(char[] arr, int left, int right) {
        while (left < right) {
            char temp = arr[left];
            arr[left] = arr[right];
            arr[right] = temp;
            left++;
            right--;
        }
    }
}
