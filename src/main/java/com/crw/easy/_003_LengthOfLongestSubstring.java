package com.crw.easy;

import java.util.HashMap;
import java.util.Map;

/**
 * 给定一个字符串，请你找出其中不含有重复字符的 最长子串 的长度。
 * <p>
 * 示例 1:
 * 输入: "abcabcbb"
 * 输出: 3
 * 解释: 因为无重复字符的最长子串是 "abc"，所以其长度为 3。
 * <p>
 * 示例 2:
 * 输入: "bbbbb"
 * 输出: 1
 * 解释: 因为无重复字符的最长子串是 "b"，所以其长度为 1。
 * <p>
 * 示例 3:
 * 输入: "pwwkew"
 * 输出: 3
 * 解释: 因为无重复字符的最长子串是 "wke"，所以其长度为 3。
 *      请注意，你的答案必须是 子串 的长度，"pwke" 是一个子序列，不是子串。
 */
public class _003_LengthOfLongestSubstring {

    public static void main(String[] args) {
        System.out.println(lengthOfLongestSubstring("abcabcbb")); // 3
        System.out.println(lengthOfLongestSubstring("tmmzuxt")); // 5
    }


    /**
     * 滑动窗口思想
     *
     * @param str
     * @return
     */
    public static int lengthOfLongestSubstring(String str) {
        int result = 0;
        // 字符当前的索引位置，key:字符，value:字符位置
        Map<Character, Integer> map = new HashMap<>();
        // 窗口范围 [left, right]
        for (int right = 0, left = 0; right < str.length(); right++) {
            // 如果存在重复的字符 x，则说明之前的 x 到 x前一个都是不重复的，计算长度与最大值比较。
            // 之前字符 x 的后一个到现在这个 x 直接都是不重复的，所以窗口的变化是 left 变成字符 x 的后一个
            // 然后把当前 x 放入字符map，然后继续往后比较
            // 注意，在窗口内部的已存在的才重置窗口
            if (map.containsKey(str.charAt(right)) && map.get(str.charAt(right)) >= left) {
                result = Math.max(result, right - left);
                left = map.get(str.charAt(right)) + 1;
                map.put(str.charAt(right), right);
                // left = Math.max(map.get(str.charAt(right)), left);
            } else {
                // 每次都把不重复的字符放入map
                map.put(str.charAt(right), right);
                // 更新最大值
                result = Math.max(result, right - left + 1);
            }
        }
        return result;
    }
}
