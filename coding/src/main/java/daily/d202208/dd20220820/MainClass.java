package daily.d202208.dd20220820;

import base.mo.TreeNode;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.LinkedList;
import java.util.Queue;

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
    public TreeNode constructMaximumBinaryTree1(int[] nums) {
        return buildTree(0, nums.length - 1, nums);
    }

    private TreeNode buildTree(int s, int e, int[] nums) {
        if (s > e) {
            return null;
        }

        if (s == e) {
            return new TreeNode(nums[s]);
        }

        int max = nums[s];
        int id = s;
        for (int i = s + 1; i <= e; i++) {
            if (nums[i] > max) {
                max = nums[i];
                id = i;
            }
        }

        TreeNode node = new TreeNode(max);
        node.left = buildTree(s, id - 1, nums);
        node.right = buildTree(id + 1, e, nums);
        return node;
    }

    public TreeNode constructMaximumBinaryTree(int[] nums) {
        Deque<TreeNode> stack = new ArrayDeque<>();
        for (int x : nums) {
            TreeNode node = new TreeNode(x);
            while (!stack.isEmpty() && stack.peek().val < x) {
                node.left = stack.pop();
            }

            if (!stack.isEmpty()) {
                stack.peek().right = node;
            }
            stack.push(node);
        }

        return stack.peekLast();
    }
}
/*[3,2,1,6,0,5]
[3,2,1]*/

public class MainClass {
    public static int[] stringToIntegerArray(String input) {
        input = input.trim();
        input = input.substring(1, input.length() - 1);
        if (input.length() == 0) {
          return new int[0];
        }
    
        String[] parts = input.split(",");
        int[] output = new int[parts.length];
        for(int index = 0; index < parts.length; index++) {
            String part = parts[index].trim();
            output[index] = Integer.parseInt(part);
        }
        return output;
    }
    
    public static String treeNodeToString(TreeNode root) {
        if (root == null) {
            return "[]";
        }
    
        String output = "";
        Queue<TreeNode> nodeQueue = new LinkedList<>();
        nodeQueue.add(root);
        while(!nodeQueue.isEmpty()) {
            TreeNode node = nodeQueue.remove();
    
            if (node == null) {
              output += "null, ";
              continue;
            }
    
            output += String.valueOf(node.val) + ", ";
            nodeQueue.add(node.left);
            nodeQueue.add(node.right);
        }
        return "[" + output.substring(0, output.length() - 2) + "]";
    }
    
    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        String line;
        while ((line = in.readLine()) != null) {
            int[] nums = stringToIntegerArray(line);
            
            TreeNode ret = new Solution().constructMaximumBinaryTree(nums);
            
            String out = treeNodeToString(ret);
            
            System.out.print(out);
        }
    }
}