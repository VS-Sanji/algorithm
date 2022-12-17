import treenode.TreeNode;

/**
 * 给定一个二叉搜索树的根节点 root 和一个值 key，删除二叉搜索树中的key对应的节点，并保证二叉搜索树的性质不变。返回二叉搜索树（有可能被更新）的根节点的引用。
 *
 * 一般来说，删除节点可分为两个步骤：
 *      首先找到需要删除的节点；
 *      如果找到了，删除它。
 */
public class DeleteNode {


    //返回值：递归函数的返回值的确定根据它的作用来定
    //如果上一层需要处理下一层的结果，那么需要定义出返回值以便于上一层的操作，比如 在求公共祖先 的过程中，碰到目标节点，向上返回，由上一层来处理和判断，同时将结果往回返
    //这里需要一个返回值treenode，用来接收调整后的根节点
    public TreeNode deleteNode(TreeNode root, int key) {

        //情况一：遇到空，说明没找到，返回null
        if (root == null) return null;
        //找到要删除的节点了
        if (root.val == key) {
            //情况二：root不为null，root的左孩子为空，右孩子不为null
            if (root.left == null && root.right != null) {
                return root.right;
            }
            //情况三：root不为null,root的左孩子不为null，右孩子为null
            if (root.left != null && root.right == null) {
                return root.left;
            }
            //情况四：root不为null，root的左孩子右孩子都为null,说明是叶子节点，直接删除即可
            if (root.left == null && root.right == null) {
                return null;
            }
            //情况五：root不为null，root的左孩子右孩子都不为null
            //这种情况比较麻烦，需要将当前节点的左子树嫁接到右子树的最小节点上，然后返回右子树的根节点
            if (root.left != null && root.right != null) {
                TreeNode temp = root.right;
                while (temp.left != null) {
                    temp = temp.left;
                }
                temp.left = root.left;
                return root.right;
            }

        }

        //左
        if (root.val > key) {
            //拿到删除节点后的新树的根节点
            TreeNode treeNode = deleteNode(root.left, key);
            //连接到原树上,依然连接到左节点上，因为是在左子树中找到的需要删除的元素，那么删掉它后，剩下所有元素也都是小于当前节点的，所以将新的根节点置为目前节点的左孩子
            root.left = treeNode;
        }

        //右
        if (root.val < key) {
            //拿到删除节点后的新树的根节点
            TreeNode treeNode = deleteNode(root.right, key);
            //连接到原树上
            root.right = treeNode;
        }

        //返回根节点，每层的根节点都不尽相同，最终返回初始节点
        return root;
    }


}
