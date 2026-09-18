package org.hard;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class StoneGameIVTest {
    private final StoneGameIV stoneGameIV = new StoneGameIV();
    @Test
    public void test1() {
        Assertions.assertEquals(true, stoneGameIV.winnerSquareGame(1));
    }

    @Test
    public void test2() {
        Assertions.assertEquals(false, stoneGameIV.winnerSquareGame(2));
    }

    @Test
    public void test3() {
        Assertions.assertEquals(true, stoneGameIV.winnerSquareGame(4));
    }
}
