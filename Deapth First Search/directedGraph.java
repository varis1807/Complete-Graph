import java.util.*;

public class directedGraph {
      public static void addedge(ArrayList<Edge>[] graph, int u, int v, int w) {
            graph[u].add(new Edge(u, v, w));
      }
}
