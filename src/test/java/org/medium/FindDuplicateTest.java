package org.medium;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

class FindDuplicateTest {

    private final FindDuplicate findDuplicate = new FindDuplicate();

    @Test
    void shouldFindDuplicateTwo() {
        assertEquals(2, findDuplicate.findDuplicate(new int[]{1, 3, 4, 2, 2}));
    }

    @Test
    void shouldFindDuplicateThree() {
        assertEquals(3, findDuplicate.findDuplicate(new int[]{3, 1, 3, 4, 2}));
    }

    @Test
    void shouldFindDuplicateSix() {
        assertEquals(9, findDuplicate.findDuplicate(new int[]{2, 5, 9, 6, 9, 3, 4, 8, 7, 1}));
    }

    @Test
    void shouldFindDuplicateWhenPhase1MeetsInsideCycle() {
        assertEquals(3, findDuplicate.findDuplicate(new int[]{6, 3, 2, 1, 3, 4, 5}));
    }

    @Test
    void shouldFindDuplicateWhenAllSame() {
        assertEquals(3, findDuplicate.findDuplicate(new int[]{3, 3, 3, 3, 3}));
    }

    @Test
    void shouldThrowWhenValueOutOfRange() {
        assertThrows(IllegalArgumentException.class,
                () -> findDuplicate.findDuplicate(new int[]{1, 3, 7, 2, 2}));
    }

    @Test
    void shouldThrowWhenArrayIsNull() {
        assertThrows(IllegalArgumentException.class,
                () -> findDuplicate.findDuplicate(null));
    }

    @Test
    void shouldThrowWhenArrayTooSmall() {
        assertThrows(IllegalArgumentException.class,
                () -> findDuplicate.findDuplicate(new int[]{1}));
    }
}
