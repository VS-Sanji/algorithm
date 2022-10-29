import java.util.HashSet;
import java.util.Set;

/**
 * 两个数组的交集：如【1， 2， 2， 1】 与 【2， 2】交集是 2（去重)
 */
public class Intersection {

    public static int[] intersection(int[] array1, int[] array2) {
        if (array1 == null || array1.length == 0 || array2 == null || array2.length == 0) {
            return new int[0];
        }
        Set<Integer> set1 = new HashSet<>();
        Set<Integer> resSet = new HashSet<>();
        //将数组1当中的所有数据存入到set集合中，重复的数据只会存入一个，因为hashSet无序不可重复的
        for (int i : array1) {
            set1.add(i);
        }

        for (int i : array2) {
            if (set1.contains(i)) {
                resSet.add(i);
            }
        }
        //将set转为int[]
        return resSet.stream().mapToInt(x -> x).toArray();
    }



    public static int[] intersectionExample(int[] nums1, int[] nums2) {
        if (nums1 == null || nums1.length == 0 || nums2 == null || nums2.length == 0) {
            return new int[0];
        }
        Set<Integer> set1 = new HashSet<>();
        Set<Integer> resSet = new HashSet<>();
        //遍历数组1
        for (int i : nums1) {
            set1.add(i);
        }
        //遍历数组2的过程中判断哈希表中是否存在该元素
        for (int i : nums2) {
            if (set1.contains(i)) {
                resSet.add(i);
            }
        }
        //将结果几何转为数组
        return resSet.stream().mapToInt(x -> x).toArray();
    }
}
