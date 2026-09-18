package org.medium;

import org.data.TreeNode;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class AverageOfSubtreeTest {
    private final AverageOfSubtree averageOfSubtree = new AverageOfSubtree();

    @Test
    public void test1() {
        TreeNode root = new TreeNode(4,
                new TreeNode(8, new TreeNode(0), new TreeNode(1)),
                new TreeNode(5, null, new TreeNode(6)));
        Assertions.assertEquals(5, averageOfSubtree.averageOfSubtree(root));
    }

    @Test
    public void test2() {
        TreeNode root = new TreeNode(1);
        Assertions.assertEquals(1, averageOfSubtree.averageOfSubtree(root));
    }
}
