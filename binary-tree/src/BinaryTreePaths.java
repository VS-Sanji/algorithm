import treenode.TreeNode;

import java.util.ArrayList;
import java.util.List;

/**
 * 给你一个二叉树的根节点 root ，按 任意顺序 ，返回所有从根节点到叶子节点的路径。
 * 叶子节点 是指没有子节点的节点。
 */
public class BinaryTreePaths {
    public List<String> binaryTreePaths(TreeNode root) {
        List<String> res = new ArrayList<>();
        if (root == null) {
            return res;
        }
        List<Integer> paths = new ArrayList<>();
        traversal(root, paths, res);
        return res;
    }

    private void traversal(TreeNode root, List<Integer> paths, List<String> res) {
        //先处理中，存该节点的值
        paths.add(root.val);

        // 叶子结点
        // 碰到叶子节点即可将整个路径存入结果集，并且结束递归
        if (root.left == null && root.right == null) {
            // 输出
            StringBuilder sb = new StringBuilder();
            for (int i = 0; i < paths.size() - 1; i++) {
                sb.append(paths.get(i)).append("->");
            }
            sb.append(paths.get(paths.size() - 1));
            res.add(sb.toString());
            return;
        }

        //左子树
        if (root.left != null) {
            traversal(root.left, paths, res);// 递归
            paths.remove(paths.size() - 1);// 回溯
        }

        //右子树
        if (root.right != null) {
            traversal(root.right, paths, res);// 递归
            paths.remove(paths.size() - 1);// 回溯
        }
    }
}
