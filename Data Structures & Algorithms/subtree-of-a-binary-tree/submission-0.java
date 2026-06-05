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
    public boolean isSubtree(TreeNode root, TreeNode subRoot) {
        if (root == null || subRoot == null) {
            return subRoot == null;
        }

        if (root.val == subRoot.val && isSameTree(root, subRoot)) {
            return true;
        }

        return isSubtree(root.left, subRoot) || isSubtree(root.right, subRoot);
    }

    private boolean isSameTree(TreeNode p1, TreeNode p2) {
        if (p1 == null || p2 == null) {
            return p1 == p2;
        }

        return p1.val == p2.val && isSameTree(p1.left, p2.left) && isSameTree(p1.right, p2.right);
    }
}
