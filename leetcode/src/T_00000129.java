import common.TreeNode;

import java.util.ArrayList;
import java.util.List;

/**
 * 给定一个二叉树，它的每个结点都存放一个 0-9 的数字，每条从根到叶子节点的路径都代表一个数字。
 * <p>
 * 例如，从根到叶子节点路径 1->2->3 代表数字 123。
 * <p>
 * 计算从根到叶子节点生成的所有数字之和。
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/sum-root-to-leaf-numbers
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class T_00000129 {


    public int sumNumbers(TreeNode root) {
        return getSum(root,0);
    }

    public int getSum(TreeNode root,int parentNumber) {
        if (root==null){
            return 0;
        }
        int sum=parentNumber*10+root.val;
        if (root.left==null&&root.right==null){
            return sum;
        }else {
            return getSum(root.left,sum)+getSum(root.right,sum);
        }
        


    }
}
