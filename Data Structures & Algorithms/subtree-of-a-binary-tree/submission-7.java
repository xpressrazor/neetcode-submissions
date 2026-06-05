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
    private String serialize(TreeNode root) {
        return root == null ? "$#" 
            : "$" + root.val + serialize(root.left) + serialize(root.right);
    }

    private int[] zfunction(String s) {
        int n = s.length();
        int l = 0, r = 0;
        int[] z = new int[n];

        for (int i = 1; i < n; i++) {
            if (r >= i) {
                z[i] = Math.min(r - i + 1, z[i - l]);
            }

            while (i + z[i] < n && s.charAt(i + z[i]) == s.charAt(z[i])) {
                z[i]++;
            }

            if (i + z[i] - 1 > r) {
                r = i + z[i] - 1;
                l = i;
            }
        }

        return z;
    }

    public boolean isSubtree(TreeNode root, TreeNode subRoot) {
        String rootser = serialize(root);
        String subser = serialize(subRoot);
        int m = subser.length();
        String combined = subser + "|" + rootser;
        int[] z = zfunction(combined);

        for (int i = m + 1; i < combined.length(); i++) {
            if (z[i] == m) {
                return true;
            }
        }

        return false;
    }
}
