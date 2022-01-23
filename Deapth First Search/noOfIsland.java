import java.util.*;

public class noOfIsland {
      public static void dfs(char[][] grid, int[][] dir, int sr, int sc) {
            grid[sr][sc] = '0';
            for (int d = 0; d < 4; d++) {
                  int r = sr + dir[d][0];
                  int c = sc + dir[d][1];

                  if (r >= 0 && c >= 0 && c < grid[0].length && r < grid.length) {
                        if (grid[r][c] == '1')
                              dfs(grid, dir, r, c);
                  }
            }
      }

      public int numIslands(char[][] grid) {
            int n = grid.length;
            int m = grid[0].length;
            int compo_count = 0;
            int[][] dir = { { 1, 0 }, { -1, 0 }, { 0, 1 }, { 0, -1 } };
            for (int i = 0; i < n; i++) {
                  for (int j = 0; j < m; j++) {
                        if (grid[i][j] == '1') {
                              dfs(grid, dir, i, j);
                              compo_count++;
                        }
                  }
            }
            return compo_count;
      }
}
