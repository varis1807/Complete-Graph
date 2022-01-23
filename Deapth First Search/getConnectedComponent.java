import java.util.*;

public class getConnectedComponent {
      public static void DFS_getconnect(ArrayList<Edge>[] graph, int src, boolean[] vis, ArrayList<Integer> curr) {
            vis[src] = true;
            curr.add(src);
            for (Edge e : graph[src]) {
                  if (!vis[e.nbr])
                        DFS_getconnect(graph, e.nbr, vis, curr);
            }
      }

      public static ArrayList<ArrayList<Integer>> getconnect(ArrayList<Edge>[] graph,
                  ArrayList<ArrayList<Integer>> ans) {
            int N = graph.length;
            int component = 0;
            boolean[] vis = new boolean[11];
            for (int i = 0; i < N; i++) {
                  if (!vis[i]) {
                        ArrayList<Integer> res = new ArrayList<>();
                        DFS_getconnect(graph, i, vis, res);
                        component++;
                        ans.add(res);
                  }
            }  
            System.out.println(component);
            return ans;
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
            // display(graph, N);
            ArrayList<ArrayList<Integer>> ans = new ArrayList<>();
            System.out.println(getconnect(graph, ans));
      }

      public static void main(String[] args) {
            construction();
      }
}
