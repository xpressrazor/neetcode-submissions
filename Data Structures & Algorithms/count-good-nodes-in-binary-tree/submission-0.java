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
    int count = 0;

    public int goodNodes(TreeNode root) {
        dfs(root, Integer.MIN_VALUE);
        return count;
    }

    void dfs(TreeNode root, int curMax) {
        if (root == null) {
            return;
        }

        if (root.val >= curMax) {
            count++;
            curMax = Math.max(curMax, root.val);
        }

        dfs(root.left, Math.max(curMax, curMax));
        dfs(root.right, Math.max(curMax, curMax));
    }
}

/*
     3
    3 n
   4 2

   3 > INF, count = 1

   // consider >=
*/