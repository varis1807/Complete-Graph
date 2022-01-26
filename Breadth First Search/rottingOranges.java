import java.yutil.*;

public class rottingOranges {
      // leet 994 ==========================================

      public int orangesRotting(int[][] grid) {
            int n = grid.length;
            int m = grid[0].length;

            LinkedList<Integer> q = new LinkedList<>();
            int freshOranges = 0;

            for (int i = 0; i < n; i++) {
                  for (int j = 0; j < m; j++) {
                        if (grid[i][j] == 1) {
                              freshOranges++;
                        } else if (grid[i][j] == 2) {
                              q.addLast(i * m + j);
                        }
                  }
            }

            if (freshOranges == 0)
                  return 0;

            int[][] dirs = { { 0, 1 }, { -1, 0 }, { 0, -1 }, { 1, 0 } };
            int level = 0;
            while (q.size() > 0) {
                  int s = q.size();

                  while (s-- > 0) {
                        int idx = q.peekFirst();
                        q.removeFirst();
                        int i = idx / m;
                        int j = idx % m;

                        for (int[] dir : dirs) {
                              int r = i + dir[0];
                              int c = j + dir[1];

                              if (r >= 0 && c >= 0 && r < n && c < m && grid[r][c] == 1) {
                                    grid[r][c] = 2;
                                    q.addLast(r * m + c);
                                    freshOranges--;

                                    if (freshOranges == 0)
                                          return level + 1;
                              }
                        }

                  }
                  level++;
            }

            return -1;
      }
}
