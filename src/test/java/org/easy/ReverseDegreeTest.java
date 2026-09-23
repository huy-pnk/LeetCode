package org.easy;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class ReverseDegreeTest {
    private final ReverseDegree reverseDegree = new ReverseDegree();

    @Test
    public void test1() {
        Assertions.assertEquals(148, reverseDegree.reverseDegree("abc"));
    }

    @Test
    public void test2() {
        Assertions.assertEquals(160, reverseDegree.reverseDegree("zaza"));
    }
}
