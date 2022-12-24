package checkerboard;

/**
 * 编写一个程序，通过填充空格来解决数独问题。
 *
 * 数独的解法需 遵循如下规则：
 *
 * 数字1-9在每一行只能出现一次。
 * 数字1-9在每一列只能出现一次。
 * 数字1-9在每一个以粗实线分隔的3x3宫内只能出现一次。（请参考示例图）
 * 数独部分空格内已填入了数字，空白格用'.'表示。
 */


/**
 * 数独问题相比于n皇后问题，更为复杂
 *      n皇后问题，在回溯函数中只需要一层for就可以控制 从左至右的遍历，其中递归自调用过程即是 一行（固定住行），这样可以处理完
 *          如：for(int i = 0; i < nums.length; i++),在其中，根据 i的值来向右依次遍历一行中的元素
 *      而数独问题，一层for不足以解决，因为在 一行上的 待填充位置，都有9中可能性，分别是1~9，即固定一个空格位不动，能够划分出9种分支出来
 *      需要固定住 空格位 不动，遍历1~9的9种分支，就需要两层for，两层for刚好可以确定唯一一个空格位，然后再利用一个for遍历1~9的9种分支的情况
 *      然后递归的时候，处理的是 下一个空格位，直到把数独填满，直接返回
 */
public class SolveSudoku {
    public void solveSudoku(char[][] board) {
        solveSudokuR(board);
    }

    /**
     * 回溯
     * @param board：数独盘
     * @return 当前位置所填数字是否可行（最后一个空格可行了，表示一种成功的解法，直接返回）
     */
    public boolean solveSudokuR(char[][] board) {

        //这里可以不用写终止条件，因为递归自调用是在两层for种进行的，即有条件的 递归，当不满足条件了，不会继续递归而是直接退出
        //另外这个函数是比较特殊的，有返回值的一个回溯函数，当在某个分支下找到结果了，后面的分支就不会继续找了，直接将结果一直往上层返，最终退出

        //行
        for (int row = 0; row < board.length; row++) {
            //列
            for (int col = 0; col < board.length; col++) {
                //确定的唯一的 位置
                //不是.,即该位置上本来就有数字，直接找下一个
                if (board[row][col] != '.') continue;

                //遍历1~9
                for (int value = '1'; value <= '9'; value++) {
                    //当前填入的数合法，可单独写函数判断
                    if (isValidSudoku(row, col, (char) value, board)) {
                        board[row][col] = (char) value;
                        //这里递归直接会拿到一个结果，可能是填满的true，也可能是有冲突的false，总之会有一个结果返回
                        boolean res = solveSudokuR(board);
                        //如果这个结果是true，说明找到了一个解，向上返回true
                        if (res) return true;
                        //不是true，冲突了，需要改值，即回溯
                        board[row][col] = '.';
                    }
                }

                //能走到这，说明1~9的所有分支都找过了，而没有返回true，说明无解，返回false
                // 因为如果一行一列确定下来了，这里尝试了9个数都不行，说明这个棋盘找不到解决数独问题的解！
                // 那么会直接返回， 「这也就是为什么没有终止条件也不会永远填不满棋盘而无限递归下去！」
                return false;
            }
        }

        // 遍历完没有返回false，说明找到了合适棋盘位置了
        return true;
    }

    /**
     * 判断棋盘是否合法有如下三个维度:
     *     同行是否重复
     *     同列是否重复
     *     9宫格里是否重复
     */
    private boolean isValidSudoku(int row, int col, char val, char[][] board){
        // 同行是否重复
        for (int i = 0; i < 9; i++){
            if (board[row][i] == val){
                return false;
            }
        }
        // 同列是否重复
        for (int j = 0; j < 9; j++){
            if (board[j][col] == val){
                return false;
            }
        }
        // 9宫格里是否重复
        int startRow = (row / 3) * 3;
        int startCol = (col / 3) * 3;
        for (int i = startRow; i < startRow + 3; i++){
            for (int j = startCol; j < startCol + 3; j++){
                if (board[i][j] == val){
                    return false;
                }
            }
        }
        return true;
    }
}
