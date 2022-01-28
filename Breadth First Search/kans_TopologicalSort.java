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
            int N = 7;
            ArrayList<Edge>[] graph = new ArrayList[7];
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
            // display(graph);
            // topological_order(graph);
            System.out.println(topoSort(graph));
      }

      public static void main(String[] args) {
            construction();
      }
}
