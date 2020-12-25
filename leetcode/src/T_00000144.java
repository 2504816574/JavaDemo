import common.TreeNode;

import java.util.ArrayList;
import java.util.List;

/**
 * 给定一个二叉树，返回它的 前序 遍历。
 */
public class T_00000144 {

    /**
     * 递归
     * @param root
     * @return
     */
    public static List<Integer> preorderTraversal(TreeNode root) {
        if (root == null) {
            return new ArrayList<>();
        }
        List<Integer> left = preorderTraversal(root.left);
        List<Integer> right = preorderTraversal(root.right);
        ArrayList<Integer> list = new ArrayList<>();
        list.add(root.val);
        list.addAll(left);
        list.addAll(right);

        return list;
    }
}
