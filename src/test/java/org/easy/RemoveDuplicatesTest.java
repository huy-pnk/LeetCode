package org.easy;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

/**
 * 26. Remove Duplicates from Sorted Array
 * https://leetcode.com/problems/remove-duplicates-from-sorted-array/description/
 */
public class RemoveDuplicatesTest {
    private final RemoveDuplicates removeDuplicates = new RemoveDuplicates();

    /** Asserts k is correct and that the first k slots hold the unique values in order. */
    private void assertResult(int[] nums, int[] expectedUnique) {
        int k = removeDuplicates.removeDuplicates(nums);
        Assertions.assertEquals(expectedUnique.length, k, "returned length k");
        for (int i = 0; i < expectedUnique.length; i++) {
            Assertions.assertEquals(expectedUnique[i], nums[i], "mismatch at index " + i);
        }
    }

    @Test
    public void officialExample1() {
        assertResult(new int[] {1, 1, 2}, new int[] {1, 2});
    }

    @Test
    public void officialExample2() {
        assertResult(new int[] {0, 0, 1, 1, 1, 2, 2, 3, 3, 4}, new int[] {0, 1, 2, 3, 4});
    }

    @Test
    public void singleElementArray() {
        assertResult(new int[] {5}, new int[] {5});
    }

    @Test
    public void allElementsDuplicate() {
        assertResult(new int[] {2, 2, 2, 2}, new int[] {2});
    }

    @Test
    public void noDuplicates() {
        assertResult(new int[] {1, 2, 3, 4, 5}, new int[] {1, 2, 3, 4, 5});
    }

    @Test
    public void twoElementsDuplicate() {
        assertResult(new int[] {1, 1}, new int[] {1});
    }

    @Test
    public void twoElementsDistinct() {
        assertResult(new int[] {1, 2}, new int[] {1, 2});
    }

    @Test
    public void duplicateOnlyAtTheEnd() {
        assertResult(new int[] {1, 2, 3, 3}, new int[] {1, 2, 3});
    }

    @Test
    public void negativeAndPositiveValues() {
        assertResult(new int[] {-3, -1, -1, 0, 0, 0, 3, 3}, new int[] {-3, -1, 0, 3});
    }
}
