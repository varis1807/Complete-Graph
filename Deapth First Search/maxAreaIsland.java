import java.util.*;
public class maxAreaIsland {
      // leet 695 ================================
      public int dfs(int i, int j, int[][] grid) {
            int[][] dirs = { { 0, 1 }, { 1, 0 }, { 0, -1 }, { -1, 0 } };
            int size = 0;
            grid[i][j] = 0;

            for (int[] dir : dirs) {
                  int r = i + dir[0];
                  int c = j + dir[1];

                  if (r >= 0 && c >= 0 && r < grid.length && c < grid[0].length && grid[r][c] == 1) {
                        size += dfs(r, c, grid);
                  }
            }

            return size + 1;
      }

      public int maxAreaOfIsland(int[][] grid) {
            int max_area = 0;

            for (int i = 0; i < grid.length; i++) {
                  for (int j = 0; j < grid[i].length; j++) {
                        if (grid[i][j] == 1) {
                              int size = dfs(i, j, grid);
                              max_area = Math.max(max_area, size);
                        }
                  }
            }
            return max_area;
      }
}
