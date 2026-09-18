package org.hard;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class NumDistinctTest {
    private  final NumDistinct numDistinct = new NumDistinct();

    @Test
    public void test1(){
        String s = "babgbag", t = "bag";
        Assertions.assertEquals(5, numDistinct.numDistinct(s, t));
    }

    @Test
    public void test2(){
        String s = "rabbbit", t = "rabbit";
        Assertions.assertEquals(3, numDistinct.numDistinct(s, t));
    }
}
