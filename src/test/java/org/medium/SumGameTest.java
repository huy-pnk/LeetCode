package org.medium;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class SumGameTest {
    private SumGame sumGame = new SumGame();

    @Test
    public void test1() {
        String num = "5023";
        Assertions.assertFalse(sumGame.sumGame(num));
    }

    @Test
    public void test2() {
        String num = "25??";
        Assertions.assertTrue(sumGame.sumGame(num));
    }

    @Test
    public void test3() {
        String num = "?3295???";
        Assertions.assertFalse(sumGame.sumGame(num));
    }

    @Test
    public void test4() {
        String num = "419?2?8314";
        Assertions.assertFalse(sumGame.sumGame(num));
    }

    @Test
    public void test5() {
        String num = "9?";
        Assertions.assertTrue(sumGame.sumGame(num));
    }

    @Test
    public void test6() {
        String num = "??????";
        Assertions.assertFalse(sumGame.sumGame(num));
    }

    @Test
    public void test7() {
        String num = "?0?3105????1834??7382?997?3?????7?63116?566?701?065?13?3??38?7?488?????9";
        Assertions.assertFalse(sumGame.sumGame(num));
    }

    @Test
    public void test8() {
        String num = "?0?91172275656701?361205452?62??99?9??4478?7967373994600735??4?079246???5827572?81087461?089";
        Assertions.assertTrue(sumGame.sumGame(num));
    }




}
