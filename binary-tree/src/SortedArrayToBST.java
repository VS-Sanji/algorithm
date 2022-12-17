import treenode.TreeNode;

/**
 * 给你一个整数数组 nums ，其中元素已经按 升序 排列，请你将其转换为一棵 高度平衡 二叉搜索树。
 *
 * 高度平衡 二叉树是一棵满足「每个节点的左右两个子树的高度差的绝对值不超过 1 」的二叉树。
 */
public class SortedArrayToBST {

    //返回值:
    public TreeNode sortedArrayToBST(int[] nums) {
        int left = 0;
        int right = nums.length - 1;
        return sorted(nums, left, right);
    }

    //构造的根节点
    //左闭右闭区间
    public TreeNode sorted(int[] nums, int left, int right) {
        //非法区间，返回null
        if (left > right) return null;

        int mid = left + ((right - left) >> 1);
        //int mid = (left + right) / 2;
        TreeNode root = new TreeNode(nums[mid]);

        root.left = sorted(nums, left, mid - 1);
        root.right = sorted(nums, mid + 1, right);
        return root;
    }

}
