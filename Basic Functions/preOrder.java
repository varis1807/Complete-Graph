import java.util.*;

public class preOrder {
      public static void Preorder(ArrayList<Edge>[] graph, int src, boolean[] vis, int wsf, String psf) {
            System.out.println(src + " -> " + (psf + src) + " @ " + wsf);
            vis[src] = true;
            for (Edge e : graph[src]) {
                  if (!vis[e.nbr])
                        Preorder(graph, e.nbr, vis, wsf + e.wt, psf + src);
            }

            vis[src] = false;
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
            Preorder(graph, 0, new boolean[N], 0, " ");
      }
      public static void main(String[] args) {
            construction();
      }
}
