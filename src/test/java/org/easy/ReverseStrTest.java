package org.easy;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class ReverseStrTest {
    private final ReverseStr reverseStr = new ReverseStr();
    @Test
    public void test1() {
        String s = "abcdefg";
        int k = 2;
        Assertions.assertTrue("bacdfeg".equals(reverseStr.reverseStr(s, k)));
    }

    @Test
    public void test2() {
        String s = "abcd";
        int k = 2;
        Assertions.assertEquals("bacd", reverseStr.reverseStr(s, k));
    }


    @Test
    public void test3() {
        String s = "abcdefg";
        int k = 8;
        Assertions.assertEquals("gfedcba", reverseStr.reverseStr(s, k));
    }

    @Test
    public void test4() {
        String s = "hyzqyljrnigxvdtneasepfahmtyhlohwxmkqcdfehybknvdmfrfvtbsovjbdhevlfxpdaovjgunjqlimjkfnqcqnajmebeddqsgl";
        int k = 39;
        Assertions.assertEquals("fdcqkmxwholhytmhafpesaentdvxginrjlyqzyhehybknvdmfrfvtbsovjbdhevlfxpdaovjgunjqllgsqddebemjanqcqnfkjmi", reverseStr.reverseStr(s, k));
    }

    @Test
    public void test5() {
        String s = "krmyfshbspcgtesxnnljhfursyissjnsocgdhgfxubewllxzqhpasguvlrxtkgatzfybprfmmfithphckksnvjkcvnsqgsgosfxc";
        int k = 20;
        Assertions.assertEquals("jlnnxsetgcpsbhsfymrkhfursyissjnsocgdhgfxtxrlvugsaphqzxllwebukgatzfybprfmmfithphccxfsogsgqsnvckjvnskk", reverseStr.reverseStr(s, k));
    }

}
