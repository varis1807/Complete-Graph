import java.util.*;

public class directedGraph {
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
            }
      }
}
