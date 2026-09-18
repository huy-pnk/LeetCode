package org.medium;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;

class SearchInRotatedSortedArrayTest {
    private final SearchInRotatedSortedArray searchInRotatedSortedArray  = new SearchInRotatedSortedArray();

    @Test
    void shouldReturnFour() {
        assertEquals(4, searchInRotatedSortedArray.search(new int[]{4,5,6,7,0,1,2}, 0));
    }
}
