package org.medium;

import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class SubsetsTest {
    Subsets subsets = new Subsets();

    private List<List<Integer>> normalize(List<List<Integer>> result) {
        result.forEach(Collections::sort);
        result.sort((a, b) -> {
            if (a.size() != b.size()) return a.size() - b.size();
            for (int i = 0; i < a.size(); i++) {
                int cmp = a.get(i).compareTo(b.get(i));
                if (cmp != 0) return cmp;
            }
            return 0;
        });
        return result;
    }

    @Test
    void shouldReturnAllSubsetsForThreeElements() {
        List<List<Integer>> expected = Arrays.asList(
            Collections.emptyList(),
            Arrays.asList(1),
            Arrays.asList(2),
            Arrays.asList(3),
            Arrays.asList(1, 2),
            Arrays.asList(1, 3),
            Arrays.asList(2, 3),
            Arrays.asList(1, 2, 3)
        );
        assertEquals(normalize(expected), normalize(subsets.subsets(new int[]{1, 2, 3})));
    }

    @Test
    void shouldReturnEmptyAndSingleForOneElement() {
        List<List<Integer>> expected = Arrays.asList(
            Collections.emptyList(),
            Arrays.asList(0)
        );
        assertEquals(normalize(expected), normalize(subsets.subsets(new int[]{0})));
    }

    @Test
    void shouldReturnOnlyEmptySetForEmptyInput() {
        List<List<Integer>> expected = Arrays.asList(Collections.emptyList());
        assertEquals(normalize(expected), normalize(subsets.subsets(new int[]{})));
    }

    @Test
    void shouldHandleNegativeNumbers() {
        List<List<Integer>> expected = Arrays.asList(
            Collections.emptyList(),
            Arrays.asList(-1),
            Arrays.asList(1),
            Arrays.asList(-1, 1)
        );
        assertEquals(normalize(expected), normalize(subsets.subsets(new int[]{-1, 1})));
    }
}
