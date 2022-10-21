/**
 * 有效字母异位词
 *      判断两个词是否是由 相同的次数的 字母 所组成的，字母位置可以不一样
 *      如：abcabc 与 cbacba 是有效字母异位词
 *         abcabc 与 cbacb 不是有效字母异位词
 *
 *         242. 有效的字母异位词 字典解法
 *              时间复杂度O(m+n) 空间复杂度O(1)
 *
 *      利用hash表来解决，将a-z的字母一一映射到长为26的数组上，如a映射到下标0处
 *      遍历字串，将字串的字母与 a 做差，所得即为该字母所对应下标，将该下标的值 自增（表示出现一次）
 *      遍历字串，同样的逻辑，不过是自减操作，如果最后数组的所有元素均为0，表示两个字串是有效异位词
 */
public class isAnagram {
    public static boolean isAnagram(String s, String t) {
        int[] hash = new int[26];
        for (int i = 0; i < s.length(); i++) {
            hash[s.charAt(i) - 'a'] ++;
        }
        for (int j = 0; j < t.length(); j++) {
            hash[t.charAt(j) - 'a'] --;
        }

        boolean isAnagram = true;
        for (int i = 0; i < 26; i++) {
            if (hash[i] != 0) {
                isAnagram = false;
                break;
            }
        }
        return isAnagram;
    }
}
