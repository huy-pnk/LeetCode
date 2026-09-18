package org.easy;

import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class PascalTriangleTest {
    private final PascalTriangle pascalTriangle = new PascalTriangle();

    @Test
    public void test1() {
        int numRows = 5;
        List<List<Integer>> expected = List.of(
                List.of(1),
                List.of(1, 1),
                List.of(1, 2, 1),
                List.of(1, 3, 3, 1),
                List.of(1, 4, 6, 4, 1)
        );
        assertEquals(expected, pascalTriangle.generate(numRows));
    }

    @Test
    public void test2() {
        int numRows = 1;
        List<List<Integer>> expected = List.of(List.of(1));
        assertEquals(expected, pascalTriangle.generate(numRows));
    }
}
