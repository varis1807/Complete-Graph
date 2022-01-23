import java.util.*;

public class printAllPath {
      public static int printallpath(ArrayList<Edge>[] graph, int src, int dest, boolean[] vis, String psf) {
            if (src == dest) {
                  System.out.println(psf + dest);
                  return 1;
            }
            int count = 0;
            vis[src] = true;
            for (Edge e : graph[src]) {
                  if (!vis[e.nbr])
                        count += printallpath(graph, e.nbr, dest, vis, psf + src);
            }
            vis[src] = false;
            return count;

      }

      public static void addEdge(ArrayList<Edge>[] graph, int u, int v, int w) {
            graph[u].add(new Edge(u, v, w));
            graph[v].add(new Edge(v, u, w));
      }

      public static void construction() {
            int N = 7;
            ArrayList<Edge>[] graph = new ArrayList[7];
            for (int i = 0; i < N; i++)
                  graph[i] = new ArrayList<>();
            addEdge(graph, 0, 1, 10);
            addEdge(graph, 0, 3, 10);
            addEdge(graph, 1, 2, 10);
            addEdge(graph, 2, 3, 40);
            addEdge(graph, 3, 4, 2);
            addEdge(graph, 4, 5, 2);
            addEdge(graph, 4, 6, 8);
            addEdge(graph, 5, 6, 3);
            boolean[] vis = new boolean[N];
            System.out.println(printallpath(graph, 3, 6, vis, ""));
      }

      public static void main(String[] args) {
            construction();
      }
}
