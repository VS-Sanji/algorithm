import jdk.nashorn.internal.IntDeque;

import java.util.Arrays;

/**
 * 给定一个正整数 n，生成一个包含 1 到 n^2 所有元素，且元素按顺时针顺序螺旋排列的正方形矩阵。
 * 示例:
 *      输入: 3 输出: [ [ 1, 2, 3 ], [ 8, 9, 4 ], [ 7, 6, 5 ] ]
 *
 * 模拟顺时针画矩阵的过程:
 * 填充上行从左到右
 * 填充右列从上到下
 * 填充下行从右到左
 * 填充左列从下到上
 * 由外向内一圈一圈这么画下去。
 * 可以发现这里的边界条件非常多，在一个循环中，如此多的边界条件，如果不按照固定规则来遍历，那就是一进循环深似海，从此offer是路人。
 * 这里一圈下来，我们要画每四条边，这四条边怎么画，每画一条边都要坚持一致的左闭右开，或者左开右闭的原则，这样这一圈才能按照统一的规则画下来。
 *      与二分法类似，在处理的过程当中要坚持循环不变量规则
 */

public class generateMatrix {
    public static void main(String[] args) {
        int val = 3;
        int[][] matrix = genMatrix(val);
        System.out.println(Arrays.deepToString(matrix));

    }


    //左闭右开写法
    public static int[][] genMatrix(int val) {
        int num = 1;//初始化为1
        int squared = val * val;
        int[][] array_2d = new int[val][val];
        int loop = val / 2;//总共转的圈数
        int count = 1;//计数，表示转第几圈
        int begin = count - 1;//左界
        int last = val - 1;//右界

        while (count <= loop) {

            //上
            for (int top = begin; top < last; top++) {
                array_2d[begin][top] = num;
                num++;
            }

            //右
            for (int right = begin; right < last; right++) {
                array_2d[right][last] = num;
                num++;
            }

            //下
            for (int down = last; down > begin; down--) {
                array_2d[last][down] = num;
                num++;
            }

            //左
            for (int left = last; left > begin; left--) {
                array_2d[left][begin] = num;
                num++;
            }

            begin++;
            last--;
            count++;
        }

        if (val % 2 == 1) {
            array_2d[loop][loop] = num;
        }

        return array_2d;
    }

}
