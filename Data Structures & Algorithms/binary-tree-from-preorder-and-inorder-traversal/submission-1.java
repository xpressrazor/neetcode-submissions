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
    Map<Integer, Integer> inMap = new HashMap<>();
    int preIndex = 0;

    public TreeNode buildTree(int[] preorder, int[] inorder) {
        int n = inorder.length;

        for (int i = 0; i < n; i++) {
            inMap.put(inorder[i], i);
        }

        return buildTree(preorder, 0, n-1);
    }

    private TreeNode buildTree(int[] preorder, int l, int r) {
        if (l > r) {
            return null;
        }

        TreeNode root = new TreeNode(preorder[preIndex++]);
        int inIndex = inMap.get(root.val);
        root.left = buildTree(preorder, l, inIndex - 1);
        root.right = buildTree(preorder, inIndex + 1, r);
        
        return root;
    }
}
