package org.easy;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class MajorityElementTest {
    MajorityElement me = new MajorityElement();
    @Test
    public void test1() {
        int[] input = new int[] {3,2,3};
        Assertions.assertEquals(me.majorityElement(input), 2);
    }
}
