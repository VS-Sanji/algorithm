import treenode.TreeNode;

import java.util.ArrayList;
import java.util.List;

/**
 * 给你二叉树的根节点 root 和一个整数目标和 targetSum ，找出所有 从根节点到叶子节点 路径总和等于给定目标和的路径。
 * 叶子节点 是指没有子节点的节点
 */
public class PathSum {

    //全局变量定义在外边
    List<List<Integer>> res = new ArrayList<>();
    List<Integer> list = new ArrayList<>();
    public List<List<Integer>> pathSum(TreeNode root, int targetSum) {
        pathSum(root, targetSum, 0);
        return res;
    }

    public void pathSum(TreeNode root, int targetSum, int cur){
        if (root == null) return;

        cur += root.val;
        list.add(root.val);
        if (root.left == null && root.right == null && targetSum == cur) {
            res.add(new ArrayList<>(list));
            /**
             * return; 这个return不能有，这里我们到达了叶子节点，收集了结果，如果直接return，会导致下面的 list.remove(list.size() - 1);不会执行，这样就少回溯了一次
             * 本来是当前递归中 list存入一次，执行完必须要 移除一次，即往回返，如果这里return了，那么当是叶子节点时，存了，但是没有及时的 移除（少回溯了一次），就会导致最后去求其它解时多出一个元素
             */
        }

        if (root.left != null) {//左
            pathSum(root.left, targetSum, cur);
        }

        if (root.right != null) {//右
            pathSum(root.right, targetSum, cur);
        }

        list.remove(list.size() - 1);//回溯
    }



    /**
     *      public List<List<Integer>> pathSum(TreeNode root, int targetSum) {
     *         List<List<Integer>> res = new ArrayList<>();
     *         List<Integer> list = new ArrayList<>();
     *         pathSum(root, targetSum, list, res);
     *         return res;
     *     }
     *
     *     递归过程中的全局变量List<Integer> list, List<List<Integer>> res以参数的形式传入
     *
     *     public void pathSum(TreeNode root, int targetSum, List<Integer> list, List<List<Integer>> res){
     *         if (root == null) return;
     *
     *         targetSum -= root.val;
     *         list.add(root.val);
     *         if (root.left == null && root.right == null && targetSum == 0) {
     *             res.add(new ArrayList<>(list));
     *             //return; 这个return不能有，这里我们到达了叶子节点，收集了结果，如果直接return，会导致下面的 list.remove(list.size() - 1);不会执行，这样就少回溯了一次
     *             //本来是当前递归中 list存入一次，执行完必须要 移除一次，即往回返，如果这里return了，那么当是叶子节点时，存了，但是没有及时的 移除（少回溯了一次），就会导致最后去求其它解时多出一个元素
     *         }
     *
     *         if (root.left != null) {
     *             pathSum(root.left, targetSum, list, res);
     *         }
     *
     *         if (root.right != null) {
     *             pathSum(root.right, targetSum, list, res);
     *         }
     *         list.remove(list.size() - 1);//回溯的过程
     *     }
     *
     */


}
