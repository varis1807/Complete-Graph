import java.util.*;
public class courseSchedule2 {
      // leet 210 ================================================ 

public boolean dfs(int[] vis, ArrayList<Integer>[] graph, int src,ArrayList<Integer> topo){
      vis[src]=1;
  
      for(int nbr:graph[src]){
          if(vis[nbr]==0){
              if(dfs(vis,graph,nbr,topo)) return true;
          } else if(vis[nbr]==1){ // cycle
              return true;
          }
      }
  
      topo.add(src);
      vis[src]=2;
  
      return false;
  }
  
  public int[] findOrder(int N, int[][] edges) {
      int[] vis=new int[N];
      ArrayList<Integer>[] graph=new ArrayList[N];
  
      for(int i=0; i<N; i++){
          graph[i]=new ArrayList<>();
      }
  
      for(int[] e:edges){
          int u=e[1];
          int v=e[0];
  
          graph[u].add(v);
      }
  
      ArrayList<Integer> order=new ArrayList<>();
      for(int i=0; i<N; i++){
          if(vis[i]==0){
              boolean cycle=dfs(vis,graph,i,order);
              if(cycle) return new int[]{};
          }
      }
  
      return order.toArray();
  }
  
}
