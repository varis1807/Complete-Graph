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
      public static void display(ArrayList<Edge>[] graph,int N){
for(int i=0; i<N; i++){
      
}
      }
}