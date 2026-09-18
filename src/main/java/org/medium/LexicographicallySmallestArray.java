package org.medium;

import java.util.*;

/**
 * 2948. Make Lexicographically Smallest Array by Swapping Elements
 * https://leetcode.com/problems/make-lexicographically-smallest-array-by-swapping-elements/description/
 */
public class LexicographicallySmallestArray {
    public int[] lexicographicallySmallestArray(int[] nums, int limit) {
        int n = nums.length;
        Integer[] sortedIdx = new Integer[n];
        for (int i = 0; i < n; i++) sortedIdx[i] = i;

        Arrays.sort(sortedIdx, (a, b) -> nums[a] - nums[b]);

        DisjointUnionSets dsu = new DisjointUnionSets(n);
        for (int k = 1; k < n; k++) {
            int prevIdx = sortedIdx[k - 1];
            int currIdx = sortedIdx[k];
            if (nums[currIdx] - nums[prevIdx] <= limit) { // đã sort nên currIdx luôn >= prevIdx về giá trị
                dsu.union(prevIdx, currIdx);
            }
        }
        Map<Integer, Deque<Integer>> groups = new HashMap<>();
        for (int i = 0; i < n; i++) {
            int root = dsu.find(i);
            groups.computeIfAbsent(root, k -> new ArrayDeque<>()).add(i);
        }

        int[] result = new int[n];
        for (int idx : sortedIdx) {
            int root = dsu.find(idx);
            int targetPos = groups.get(root).poll(); // lấy index nhỏ nhất còn lại
            result[targetPos] = nums[idx];
        }

        return result;
    }

    private void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
}


class DisjointUnionSets {
    int[] rank, parent;
    int n;

    // Constructor
    public DisjointUnionSets(int n)
    {
        rank = new int[n];
        parent = new int[n];
        this.n = n;
        for (int i = 0; i < n; i++) {
            // Initially, all elements are in
            // their own set.
            parent[i] = i;
        }
    }

    // Returns representative of x's set
    public int find(int i) {

        int root = parent[i];

        // Path Compression
        if (parent[root] != root) {
            return parent[i] = find(root);
        }

        return root;
    }

    // Unites the set that includes x and the set
    // that includes x
    void union(int x, int y)
    {
        // Find representatives of two sets
        int xRoot = find(x), yRoot = find(y);

        // Elements are in the same set, no need
        // to unite anything.
        if (xRoot == yRoot)
            return;

        // If x's rank is less than y's rank
        if (rank[xRoot] < rank[yRoot])

            // Then move x under y  so that depth
            // of tree remains less
            parent[xRoot] = yRoot;

            // Else if y's rank is less than x's rank
        else if (rank[yRoot] < rank[xRoot])

            // Then move y under x so that depth of
            // tree remains less
            parent[yRoot] = xRoot;

        else // if ranks are the same
        {
            // Then move y under x (doesn't matter
            // which one goes where)
            parent[yRoot] = xRoot;

            // And increment the result tree's
            // rank by 1
            rank[xRoot] = rank[xRoot] + 1;
        }
    }
}
