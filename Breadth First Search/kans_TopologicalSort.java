import java.util.*;

public class kans_TopologicalSort {
      public static ArrayList<Integer> topoSort(ArrayList<Edge>[] graph) {
            int vrtx = graph.length;
            int[] inDgree = new int[vrtx];
            for (int i = 0; i < vrtx; i++) {
                  for (Edge e : graph[i])
                        inDgree[e.nbr]++;
            }
            LinkedList<Integer> que = new LinkedList<>();
            ArrayList<Integer> topo_order = new ArrayList<>();
            for (int i = 0; i < vrtx; i++) {
                  if (inDgree[i] == 0)
                        que.addLast(i);
            }

            while (que.size() > 0) {
                  int rvtx = que.removeFirst();
                  topo_order.add(rvtx);
                  for (Edge e : graph[rvtx]) {
                        inDgree[e.nbr]--;
                        if (inDgree[e.nbr] == 0)
                              que.addLast(e.nbr);
                  }
            }
            return topo_order;
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
            int N = 13;
            ArrayList<Edge>[] graph = new ArrayList[N];
            for (int i = 0; i < N; i++) {
                  graph[i] = new ArrayList<>();
            }
            addedge(graph, 5, 11, 10);
            addedge(graph, 7, 11, 20);
            addedge(graph, 7, 8, 10);
            addedge(graph, 3, 8, 40);
            addedge(graph, 3, 10, 50);
            addedge(graph, 11, 2, 60);
            addedge(graph, 11, 9, 70);
            addedge(graph, 11, 10, 70);
            addedge(graph, 8, 9, 70);
             display(graph);
            // topological_order(graph);
           // System.out.println(topoSort(graph));
      }

      public static void main(String[] args) {
            construction();
      }
}
