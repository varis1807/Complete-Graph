import java.util.*;

public class implementation {
      static int[] parent;// leader
      static int[] size;

      public static int findParent(int u) {
            if (parent[u] == u)
                  return u;

            return parent[u] = findParent(parent[u]);
      }

      public static void merge(int p1, int p2) {
            if (size[p1] <= size[p2]) {
                  parent[p1] = p2;
                  size[p2] += size[p1];
            } else {
                  parent[p2] = p1;
                  size[p1] += size[p2];
            }
      }

      public static int unionFind(int n, ArrayList<ArrayList<Integer>> edges) {
            parent = new int[n];
            size = new int[n];
            for (int i = 0; i < n; i++) {
                  parent[i] = i;
                  size[i] = 1;
            }
            for (ArrayList<Integer> e : edges) {
                  int u = edges(0);
                  int v = edges(1);
                  int p1 = findParent(u);
                  int p2 = findParent(v);
                  if (p1 != p2)
                        merge(p1, p2);
            }
            int number_component = 0;
            for (int i = 0; i < n; i++) {
                  int p = findParent(i);
                  if (i == p) {
                        number_component++;
                  }
            }
            return number_component;
      }

      public static void main(String[] args) {

      }
}
