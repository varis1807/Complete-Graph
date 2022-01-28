import java.util.*;

public class bfs {
      public static void BFS(int src, ArrayList<Edge>[] graph) {
            LinkedList<Integer> que = new LinkedList<>();

            int V = graph.length;

            boolean[] vis = new boolean[V];

            que.addLast(src);
            int level = 0;
            boolean isCycle = false;

            while (que.size() > 0) {
                  int size = que.size();

                  while (size-- > 0) {
                        int ele = que.removeFirst();

                        if (vis[ele]) {
                              isCycle = true;
                              continue;
                        }

                        vis[ele] = true;
                        for (Edge e : graph[ele]) {
                              if (!vis[e.nbr]) {
                                    que.addLast(e.nbr);
                              }
                        }
                  }

                  level++;
            }

            if (isCycle) {
                  System.out.println("Cycle exists");
            }
      }

      public static void BFS2(int src, ArrayList<Edge>[] graph) {
            LinkedList<Integer> que = new LinkedList<>();

            int V = graph.length;

            boolean[] vis = new boolean[V];

            que.addLast(src);
            vis[src] = true;
            int level = 0;
            // boolean isCycle=false;

            while (que.size() > 0) {
                  int size = que.size();

                  while (size-- > 0) {
                        int ele = que.removeFirst();

                        for (Edge e : graph[ele]) {
                              if (!vis[e.nbr]) {
                                    vis[e.nbr] = true;
                                    que.addLast(e.nbr);
                              }
                        }
                  }

                  level++;
            }

            // if(isCycle){
            // System.out.println("Cycle exists");
            // }
      }
}
