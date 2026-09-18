package org.easy;

import org.data.TreeNode;

public class IsSymmetric {
    public boolean isSymmetric(TreeNode root) {
        if(root.left != null && root.right != null) {
            return isSymmetric(root.left, root.right);
        }
        System.out.println(root.val);
        return false;
    }
    boolean isSymmetric(TreeNode subNode1, TreeNode subNode2) {
        if(subNode1.val == subNode2.val) {
            if(subNode1.left != null && subNode2.left != null) isSymmetric(subNode1.left, subNode2.left);
            else if(subNode1.left != null && subNode2.left == null) return false;
            else if(subNode2.left != null && subNode2.left == null) return false;

            if(subNode1.right != null && subNode2.right != null) isSymmetric(subNode1.left, subNode2.left);
            else if(subNode1.right != null && subNode2.right == null) return false;
            else if(subNode2.right != null && subNode2.right == null) return false;
        }
        return false;
    }
}

