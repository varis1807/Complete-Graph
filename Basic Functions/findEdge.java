import java.util.*;

public class findEdge {
      public static int find(ArrayList<Edge>[] graph, int u, int v) {
            ArrayList<Edge> list = graph[u];
            for (int i = 0; i < list.size(); i++) {
                  Edge e = list.get(i);
                  if (e.nbr == v)
                        return i;
            }
            return -1;
      }

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
            display(graph, N);
            System.out.println(find(graph, 3, 4));
      }

      public static void main(String[] args) {
            construction();
      }
}
