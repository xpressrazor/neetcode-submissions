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
    int count;
    int val = -1;

    public int kthSmallest(TreeNode root, int k) {
        count = k;
        dfs(root);
        return val;    
    }

    private void dfs(TreeNode root) {
        if (root == null) {
            return;
        }

        dfs(root.left);
        count--;

        if (count == 0) {
            val = root.val;
            return;
        }

        dfs(root.right);
    }
}
