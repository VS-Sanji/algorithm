import treenode.TreeNode;

/**
 * 给定一个不重复的整数数组nums 。最大二叉树可以用下面的算法从nums 递归地构建:
 *
 * 创建一个根节点，其值为nums 中的最大值。
 * 递归地在最大值左边的子数组前缀上构建左子树。
 * 递归地在最大值 右边 的子数组后缀上构建右子树。
 * 返回nums 构建的 最大二叉树 。
 */
public class ConstructMaximumBinaryTree {

    /**
     * 返回值 为 树的根节点
     * 参数为数组
     */
    public TreeNode constructMaximumBinaryTree(int[] nums) {

        //终止条件，当数组的长度为 1时，表明是叶子节点了，
        if (nums.length == 1) return new TreeNode(nums[0]);

        //单层处理逻辑
        int maxValue = 0;
        int index = 0;
        //取数组中的最大值
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] > maxValue) {
                maxValue = nums[i];
                index = i;
            }
        }

        //构造根节点
        TreeNode root = new TreeNode(maxValue);

        //递归求左子树
        if (index > 0) {//只有index大于0时，才有左子树
            int[] left = new int[index];
            for (int i = 0; i < index; i++) {
                left[i] = nums[i];
            }
            root.left = constructMaximumBinaryTree(left);
        }

        //递归求右子树
        if (index < nums.length - 1) {//只有index小于 nums.length - 1时，才有右子树
            int[] right = new int[nums.length - index - 1];
            for (int i = index + 1, j = 0; i < nums.length; i++, j++) {
                right[j] = nums[i];
            }
            root.right = constructMaximumBinaryTree(right);
        }

        return root;

    }

    /**
     *     public TreeNode constructMaximumBinaryTree(int[] nums) {
     *         return constructMaximumBinaryTree1(nums, 0, nums.length);
     *     }
     *
     *
     *     //这种写法是将 子区间（对应左右子树）的划分利用两个指针进行实现，直接在原数组上进行操作，而不用像上面的实现一样，在每次入递归之前构造出一个子数组，只需要修改 区间左右指针的值即可 效率比较高
     *     public TreeNode constructMaximumBinaryTree1(int[] nums, int leftIndex, int rightIndex) {
     *         if (rightIndex - leftIndex < 1) {// 没有元素了
     *             return null;
     *         }
     *         if (rightIndex - leftIndex == 1) {// 只有一个元素
     *             return new TreeNode(nums[leftIndex]);
     *         }
     *         int maxIndex = leftIndex;// 最大值所在位置
     *         int maxVal = nums[maxIndex];// 最大值
     *         for (int i = leftIndex + 1; i < rightIndex; i++) {
     *             if (nums[i] > maxVal){
     *                 maxVal = nums[i];
     *                 maxIndex = i;
     *             }
     *         }
     *         TreeNode root = new TreeNode(maxVal);
     *         // 根据maxIndex划分左右子树
     *         root.left = constructMaximumBinaryTree1(nums, leftIndex, maxIndex);
     *         root.right = constructMaximumBinaryTree1(nums, maxIndex + 1, rightIndex);
     *         return root;
     *     }
     */



}
