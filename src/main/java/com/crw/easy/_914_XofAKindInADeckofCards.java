package com.crw.easy;

/**
 * 914. 卡牌分组
 * 给定一副牌，每张牌上都写着一个整数。
 * 此时，你需要选定一个数字 X，使我们可以将整副牌按下述规则分成 1 组或更多组：
 * - 每组都有 X 张牌。
 * - 组内所有的牌上都写着相同的整数。
 * - 仅当你可选的 X >= 2 时返回 true。
 * <p>
 * 示例 1：
 * 输入：[1,2,3,4,4,3,2,1]
 * 输出：true
 * 解释：可行的分组是 [1,1]，[2,2]，[3,3]，[4,4]
 * <p>
 * 示例 2：
 * 输入：[1,1,1,2,2,2,3,3]
 * 输出：false
 * 解释：没有满足要求的分组。
 * <p>
 * 示例 3：
 * 输入：[1]
 * 输出：false
 * 解释：没有满足要求的分组。
 * <p>
 * 示例 4：
 * 输入：[1,1]
 * 输出：true
 * 解释：可行的分组是 [1,1]
 * <p>
 * 示例 5：
 * 输入：[1,1,2,2,2,2]
 * 输出：true
 * 解释：可行的分组是 [1,1]，[2,2]，[2,2]
 * <p>
 * 提示：
 * 1 <= deck.length <= 10000
 * 0 <= deck[i] < 10000
 */
public class _914_XofAKindInADeckofCards {

    public static void main(String[] args) {
        System.out.println(hasGroupsSizeX(new int[]{1, 2, 3, 4, 4, 3, 2, 1}));
        System.out.println(hasGroupsSizeX(new int[]{1, 1, 1, 2, 2, 2, 3, 3}));
        System.out.println(hasGroupsSizeX(new int[]{1}));
        System.out.println(hasGroupsSizeX(new int[]{1, 1}));
        System.out.println(hasGroupsSizeX(new int[]{1, 1, 2, 2, 2, 2}));
    }

    /**
     * 统计各个数出现的次数，然后求次数之间是否存在公约数
     *
     * @param deck
     * @return
     */
    public static boolean hasGroupsSizeX(int[] deck) {
        int len = deck.length;
        if (len < 2) {
            return false;
        }

        // 计数数组，10000 是根据题目给出的数值范围定的
        int[] cnt = new int[10000];
        for (int num : deck) {
            cnt[num]++;
        }

        // 求gcd，gcd大于2的才能算可行的分组
        int x = 0;
        for (int i = 0; i < cnt.length; i++) {
            if (cnt[i] == 0) continue;
            x = gcd(x, cnt[i]);
            if (x == 1) return false;
        }

        return x >= 2;
    }


    private static int gcd(int a, int b) {
        return b == 0 ? a : gcd(b, a % b);
    }
}
