import java.util.*;

public class topologicalSort {
      public static void dfs_topo(int src, ArrayList<Edge>[] graph, boolean[] vis, ArrayList<Integer> topo) {
            vis[src] = true;

            for (Edge e : graph[src]) {
                  if (!vis[e.nbr]) {
                        dfs_topo(e.nbr, graph, vis, topo);
                  }
            }

            topo.add(src);
      }

      public static void topological_order(ArrayList<Edge>[] graph) {
            int V = graph.length;

            boolean[] vis = new boolean[V];
            ArrayList<Integer> topo = new ArrayList<>();
            for (int i = 0; i < V; i++) {
                  if (!vis[i]) {
                        dfs_topo(i, graph, vis, topo);
                  }
            }

            for (int i = topo.size() - 1; i >= 0; i--) {
                  System.out.println(topo.get(i));
            }
      }

      public static void addedge(ArrayList<Edge>[] graph, int u, int v, int w) {
            graph[u].add(new Edge(u, v, w));
      }

      public static void display(ArrayList<Edge>[] graph) {
            int N = graph.length;
            for (int i = 0; i < N; i++) {
                  System.out.print(i + "-> ");
                  for (Edge e : graph[i]) {
                        System.out.print("( " + e.nbr + " @ " + e.wt + " )");
                  }
                  System.out.println();
            }
      }

      public static void construction() {
            int N = 7;
            ArrayList<Edge>[] graph = new ArrayList[N];
            for (int i = 0; i < N; i++) {
                  graph[i] = new ArrayList<>();
            }
            addedge(graph, 0, 1, 10);
            addedge(graph, 0, 3, 20);
            addedge(graph, 1, 2, 30);
            addedge(graph, 2, 3, 40);
            addedge(graph, 4, 3, 50);
            addedge(graph, 4, 5, 60);
            addedge(graph, 4, 6, 70);
            //-----------
            // display(graph);
            topological_order(graph);
      }

      public static void main(String[] args) {
            construction();
      }

}
