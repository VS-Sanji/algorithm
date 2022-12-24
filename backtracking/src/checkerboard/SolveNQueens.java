package chessboard;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 按照国际象棋的规则，皇后可以攻击与之处在同一行或同一列或同一斜线上的棋子。
 *
 * n皇后问题 研究的是如何将 n个皇后放置在 n×n 的棋盘上，并且使皇后彼此之间不能相互攻击。
 *
 * 给你一个整数 n ，返回所有不同的n皇后问题 的解决方案。
 *
 * 每一种解法包含一个不同的n 皇后问题 的棋子放置方案，该方案中 'Q' 和 '.' 分别代表了皇后和空位。
 */
public class SolveNQueens {

    public List<List<String>> solveNQueens(int n) {
        //棋盘
        char[][] chessboard = new char[n][n];
        //将棋盘上的所有点位全部初始化为 '.'，之后只需要 重新赋值即可
        for (char[] row : chessboard) {
            Arrays.fill(row, '.');
        }
        solveNQueens(n, chessboard, 0);
        return res;
    }

    //回溯求解n皇后

    //结果集
    List<List<String>> res = new ArrayList<>();

    /**
     * 参数说明
     * @param n：棋盘的大小，n*n
     * @param chessboard：模拟的棋盘，用二维数组来模拟
     * @param row：表示第几行，每一行对应一层递归
     */
    public void solveNQueens(int n, char[][] chessboard, int row) {

        //递归终止条件，如果是正确的摆放方式，那么最后一定能到达最后一行，反之，到不了最后一行的一定是有冲突，所以当递归深度（即行数）与n相等时，可以收集正确结果
        if (row == n) {
            List<String> strings = Array2List(chessboard);
            res.add(strings);
            return;
        }

        //单层逻辑
        //for循环中定义的col表示列，整个递归函数在同一层中，那么由for中col的变化即可依次遍历棋盘的一行中的每一个格子
        for (int col = 0; col < n; col++) {
            //写个单独的函数判断当前这个位置是否合法，合法即摆放一个 'Q'，摆放一个'.'
            boolean valid = isValid(row, col, chessboard, n);
            if (valid) {
                //合法
                chessboard[row][col] = 'Q';
                //递归处理下一行
                solveNQueens(n, chessboard, row + 1);
                //回溯,撤销摆放的‘Q’，进入下轮循环，测试下一个位置
                chessboard[row][col] = '.';
            }
            //非法不处理，因为传入的棋盘上所有点位都默认为 '.’，所以直接进入下一轮循环验证下一个点位即可
        }
    }

    /**
     * 判断当前位置的合法性，合法即继续，反之退出，找下一个
     * 是否合法根据摆放要求得来
     *      1.不能同行
     *      2.不能同列
     *      3.不能同斜线 （45度和135度角）
     */
    /**
     * 参数说明
     * @param row:当前行
     * @param col:当前列，即回溯for中的col
     * @param chessboard：棋盘
     * @param n：棋盘大小
     * @return
     */
    /**
     * 注意，这里并没有 对当前行进行检查，这是因为在回溯函数中，要在当前位置摆放皇后，一定是经过回溯取消之前摆放过的皇后，
     * 即之前摆放的结果处理完后会移除皇后，然后放在下一个位置，这样的话对于行来说，不用检查行上有没有冲突，因为一定没有
     */
    public boolean isValid(int row, int col, char[][] chessboard, int n) {
        //检查列
        //这里有做剪枝，i < row,并没有写成 i < n,这是因为棋子是一行一行向下摆放的，当前行之后的还没有摆放，所以不用考虑，只需要考虑上面的行即可
        for (int i = 0; i < row; i++) {
            if (chessboard[i][col] == 'Q') return false;
        }

        //检查45°角
        for (int i = row - 1, j = col - 1; i >= 0 && j >= 0; i--, j--) {
            if (chessboard[i][j] == 'Q') return false;
        }

        //检查135°角
        for (int i = row - 1, j = col + 1; i >= 0 && j < n; i--, j++) {
            if (chessboard[i][j] == 'Q') return false;
        }

        return true;
    }


    //棋盘中每一行如 {'Q','.','.','.'} -> "Q..."
    //写一个Array > list的方法，用来处理最终合法的一个棋盘摆法，因为使用二维数组来模拟的棋盘，所以它的每一行对应的就是二维数组中的一个元素，将每一行表示成 "Q..."的字串，那么一整个棋盘就表示成一种解法
    public List<String> Array2List(char[][] chessboard) {
        List<String> strings = new ArrayList<>();
        for (char[] row : chessboard) {
            strings.add(String.copyValueOf(row));
        }
        return strings;
    }

}
