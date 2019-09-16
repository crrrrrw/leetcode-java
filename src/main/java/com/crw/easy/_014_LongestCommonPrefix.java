package com.crw.easy;

/**
 * 最长公共前缀
 * <p>
 * 编写一个函数来查找字符串数组中的最长公共前缀。
 * 如果不存在公共前缀，返回空字符串 ""。
 * <p>
 * 示例 1:
 * 输入: ["flower","flow","flight"]
 * 输出: "fl"
 * <p>
 * 示例 2:
 * 输入: ["dog","racecar","car"]
 * 输出: ""
 * 解释: 输入不存在公共前缀。
 * <p>
 * 说明:
 * 所有输入只包含小写字母 a-z 。
 */
public class _014_LongestCommonPrefix {


    public static void main(String[] args) {
        System.out.println(longestCommonPrefix2(new String[]{"flower", "flow", "flight"}));
        System.out.println(longestCommonPrefix2(new String[]{"dog", "racecar", "car"}));

    }

    /**
     * 迭代扫描，从第二个开始每次与前一个比对。
     * 如果第一个就不匹配，直接返回""
     * 如果匹配上了，得出当前匹配前缀，然后下一个与当前前缀进行匹配
     *
     * @param strs
     * @return
     */

    public static String longestCommonPrefix(String[] strs) {
        if (strs.length == 0) return "";
        String prefix = strs[0];
        for (int i = 1; i < strs.length; i++)
            // 存在不匹配的前缀
            while (strs[i].indexOf(prefix) != 0) {
                prefix = prefix.substring(0, prefix.length() - 1);
                if (prefix.isEmpty()) return "";
            }
        return prefix;
    }

    /**
     * 垂直查找，每次比对各个字符串的第 i 个字符，如果不相等了就返回。例如
     * flower
     * flow
     * flight
     * <p>
     * 第一次比对是否都有f。
     * 第二次比对是否都有l。
     * 第三次比对是否都有o。发现了 flight 第三个不是 o ，结束，返回 fl
     *
     * @param strs
     * @return
     */
    public static String longestCommonPrefix2(String[] strs) {
        if (strs == null || strs.length == 0) return "";

        // 第一个元素当做前缀
        String prefix = strs[0];
        for (int i = 0; i < prefix.length(); i++) {
            // 前缀第一个字符
            char c = prefix.charAt(i);
            // 比对每一个字符串是否第 i 个位置都是c，如果存在不匹配，则最长公共前缀就是前面i-1个位置
            for (int j = 1; j < strs.length; j++) {
                if (i == strs[j].length() || strs[j].charAt(i) != c)
                    return prefix.substring(0, i);
            }
        }
        return prefix;
    }


}
