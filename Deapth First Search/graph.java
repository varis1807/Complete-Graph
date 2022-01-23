import java.util.*;

class Edge {
      int src;
      int nbr;
      int wt;

      Edge(int src, int nbr, int wt) {
            this.src = src;
            this.nbr = nbr;
            this.wt = wt;
      }

}

public class graph {
      public static void addEdge(ArrayList<Edge>[] graph, int u, int v, int w) {
            graph[u].add(new Edge(u, v, w));
            graph[v].add(new Edge(v, u, w));
      }

      public static void display(ArrayList<Edge>[] graph, int N) {
            for (int i = 0; i < N; i++) {
                  System.out.print(i + " -> ");
                  for (Edge e : graph[i])
                        System.out.print(" [" + e.nbr + "@" + e.wt + "]");
                  System.out.println();
            }
      }

      public static void construction() {
            int N = 11;
            ArrayList<Edge>[] graph = new ArrayList[11];
            for (int i = 0; i < N; i++)
                  graph[i] = new ArrayList<>();
            addEdge(graph, 0, 1, 10);
            addEdge(graph, 1, 3, 10);
            addEdge(graph, 1, 2, 10);
            addEdge(graph, 3, 4, 40);
            addEdge(graph, 6, 5, 2);
            addEdge(graph, 6, 7, 2);
            addEdge(graph, 5, 7, 8);
            addEdge(graph, 9, 10, 3);
            addEdge(graph, 8, 8, 5);
            display(graph, N);
      }

      public static void main(String[] args) {
            construction();
      }
}
