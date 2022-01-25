import java.util.*;

public class islandPerimeter {
      public int islandPerimeter(int[][] grid) {
            if (grid == null)
                  return 0;
            for (int i = 0; i < grid.length; i++) {
                  for (int j = 0; j < grid[0].length; j++) {
                        if (grid[i][j] == 1) {
                              return getPerimeter(grid, i, j);
                        }
                  }
            }
            return 0;
      }

      public int getPerimeter(int[][] grid, int i, int j) {
            if (i < 0 || i >= grid.length || j < 0 || j >= grid[0].length) {
                  return 1;
            }
            if (grid[i][j] == 0) {
                  return 1;
            }
            if (grid[i][j] == -1)
                  return 0;

            int count = 0;
            grid[i][j] = -1;

            count += getPerimeter(grid, i - 1, j);
            count += getPerimeter(grid, i, j - 1);
            count += getPerimeter(grid, i, j + 1);
            count += getPerimeter(grid, i + 1, j);

            return count;
      }

      // 2--------------
      public int islandPerimeter1(int[][] grid) {
            int noOfOne = 0;
            int nbrCount = 0;
            int n = grid.length;
            int m = grid[0].length;

            int[][] dirs = { { 0, 1 }, { 1, 0 }, { -1, 0 }, { 0, -1 } };

            for (int i = 0; i < n; i++) {
                  for (int j = 0; j < m; j++) {
                        if (grid[i][j] == 1) {
                              noOfOne++;
                              for (int[] dir : dirs) {
                                    int r = i + dir[0];
                                    int c = j + dir[1];

                                    if (r >= 0 && c >= 0 && r < n && c < m && grid[r][c] == 1) {
                                          nbrCount++;
                                    }
                              }
                        }
                  }
            }
            return 4 * noOfOne - nbrCount;
      }
}
