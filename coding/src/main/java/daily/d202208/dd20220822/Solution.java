package daily.d202208.dd20220822;

import base.mo.TreeNode;

import java.util.ArrayList;
import java.util.List;

/**
 * Definition for a binary tree node.
 * public class TreeNode {
 * int val;
 * TreeNode left;
 * TreeNode right;
 * TreeNode() {}
 * TreeNode(int val) { this.val = val; }
 * TreeNode(int val, TreeNode left, TreeNode right) {
 * this.val = val;
 * this.left = left;
 * this.right = right;
 * }
 * }
 */
class Solution {
    public List<List<String>> printTree(TreeNode root) {
        int height = getHeight(root) - 1;
        int m = height + 1;
        int n = (1 << (height + 1)) - 1;
        List<List<String>> ans = new ArrayList<>();
        for (int i = 0; i < m; i++) {
            ans.add(new ArrayList<>());
            for (int j = 0; j < n; j++) {
                ans.get(i).add("");
            }
        }
        setNodes(root, 0, (n - 1) / 2, ans, height);
        return ans;
    }

    private void setNodes(TreeNode root, int r, int c, List<List<String>> res, int height) {
        if (root == null) {
            return;
        }

        res.get(r).set(c, String.valueOf(root.val));
        setNodes(root.left, r + 1, c - (1 << (height - r - 1)), res, height);
        setNodes(root.right, r + 1, c + (1 << (height - r - 1)), res, height);
    }

    private int getHeight(TreeNode node) {
        if (node == null) {
            return 0;
        }

        return Math.max(getHeight(node.left), getHeight(node.right)) + 1;
    }
}
/*[1,2]
[1,2,3,null,4]*/