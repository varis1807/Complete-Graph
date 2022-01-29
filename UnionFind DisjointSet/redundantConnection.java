import java.util.*;

public class redundantConnection {
      static int[] parent;// leader
      static int[] size;

      public int findParent(int u) {
            if (parent[u] == u)
                  return u;

            return parent[u] = findParent(parent[u]);
      }

      public void merge(int p1, int p2) {
            if (size[p1] <= size[p2]) {
                  parent[p1] = p2;
                  size[p2] += size[p1];
            } else {
                  parent[p2] = p1;
                  size[p1] += size[p2];
            }
      }

      public int[] findRedundantConnection(int[][] edges) {
            int n = edges.length;
            parent = new int[n + 1];
            size = new int[n + 1];
            for (int i = 0; i < n; i++) {
                  parent[i] = i;
                  size[i] = 1;
            }

            for (int[] e : edges) {
                  int u = e[0];
                  int v = e[1];

                  int p1 = findParent(u);
                  int p2 = findParent(v);

                  if (p1 == p2)
                        return e;
                  merge(p1, p2);
            }
            return new int[] {};
      }
}
