/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */

class Solution {
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
       if (root == null || p == root || q == root) {
        return root;
       }

       TreeNode cur = root;

       while (cur != null) {
        int val = cur.val;

        if (val > p.val && val > q.val) {
            cur = cur.left;
        } else if (val < p.val && val < q.val) {
            cur = cur.right;
        } else {
            return cur;
        }
       }

       return null;
    }
}
