import java.util.*;

public class postOrder {
      public static void postorder(ArrayList<Edge>[] graph, int src, boolean[] vis, int wsf, String psf) {
            vis[src] = true;
            for (Edge e : graph[src]) {
                  if (!vis[e.nbr])
                        postorder(graph, e.nbr, vis, wsf + e.wt, psf + src);
            }

            System.out.println(src + " -> " + psf+src + " @ " + wsf);
            vis[src] = false;
      }

      public static void addEdge(ArrayList<Edge>[] graph, int u, int v, int w) {
            graph[u].add(new Edge(u, v, w));
            graph[v].add(new Edge(v, u, w));
      }

      public static void construction() {
            int N = 4;
            ArrayList<Edge>[] graph = new ArrayList[4];
            for (int i = 0; i < N; i++)
                  graph[i] = new ArrayList<>();
            addEdge(graph, 0, 1, 10);
            addEdge(graph, 0, 3, 10);
            addEdge(graph, 1, 2, 10);
            addEdge(graph, 2, 3, 40);
            postorder(graph, 0, new boolean[4], 0, " ");
      }

      public static void main(String[] args) {
            construction();
      }
}
