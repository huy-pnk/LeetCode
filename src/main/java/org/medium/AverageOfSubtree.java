package org.medium;

import org.data.TreeNode;

/**
 * 2265. Count Nodes Equal to Average of Subtree
 * https://leetcode.com/problems/count-nodes-equal-to-average-of-subtree/
 */
public class AverageOfSubtree {
    int count = 0;
    public int averageOfSubtree(TreeNode root) {
        if(root == null) return 0;
        findAverage(root);
        return count;
    }

    public int[] findAverage(TreeNode node) {
        int[] result = new int[]{0,0};
        if(node == null) return result;
        else if(node.left != null || node.right != null) {
            result[0] = node.val;
            result[1] ++;
            if(node.left != null) {
                int[] temp = findAverage(node.left);
                result[0] += temp[0];
                result[1] += temp[1];
            }
            if(node.right != null) {
                int[] temp = findAverage(node.right);
                result[0] += temp[0];
                result[1] += temp[1];
            }
        } else {
            result[0] = node.val;
            result[1] = 1;
            count++;
            return result;
        }
        if(result[0]/result[1] == node.val) count++;
        return result;
    }
}
