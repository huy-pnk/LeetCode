package org.example;

import java.util.*;

public class ConnectedZeros {

    public static List<List<int[]>> findConnectedZeros(int[][] matrix) {
        int rows = matrix.length;
        int cols = matrix[0].length;
        boolean[][] visited = new boolean[rows][cols];
        List<List<int[]>> components = new ArrayList<>();

        // If you ONLY want up/down movement, use this:
        int[][] directions = {{-1, 0}, {1, 0}}; // up, down

        // If you want up/down/left/right (typical grid BFS), use this instead:
        // int[][] directions = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};

        for (int r = 0; r < rows; r++) {
            for (int c = 0; c < cols; c++) {
                if (matrix[r][c] == 0 && !visited[r][c]) {
                    List<int[]> component = new ArrayList<>();
                    bfs(matrix, visited, r, c, directions, component);
                    components.add(component);
                }
            }
        }
        return components;
    }

    private static void bfs(int[][] matrix, boolean[][] visited, int startR, int startC,
                            int[][] directions, List<int[]> component) {
        Queue<int[]> queue = new LinkedList<>();
        queue.offer(new int[]{startR, startC});
        visited[startR][startC] = true;

        while (!queue.isEmpty()) {
            int[] cur = queue.poll();
            component.add(cur);

            for (int[] d : directions) {
                int nr = cur[0] + d[0];
                int nc = cur[1] + d[1];

                if (isValid(matrix, visited, nr, nc)) {
                    visited[nr][nc] = true;
                    queue.offer(new int[]{nr, nc});
                }
            }
        }
    }

    private static boolean isValid(int[][] matrix, boolean[][] visited, int r, int c) {
        int rows = matrix.length;
        int cols = matrix[0].length;
        return r >= 0 && r < rows && c >= 0 && c < cols
                && matrix[r][c] == 0 && !visited[r][c];
    }

    public static void main(String[] args) {
        int[][] matrix = {
                {0, 0, 0},
                {0, 1, 0}
        };

        List<List<int[]>> components = findConnectedZeros(matrix);

        int i = 1;
        for (List<int[]> comp : components) {
            System.out.println("Component " + i++ + ":");
            for (int[] cell : comp) {
                System.out.println("  (" + cell[0] + ", " + cell[1] + ")");
            }
        }
    }
}