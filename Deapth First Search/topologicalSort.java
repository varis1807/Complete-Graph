import java.util.*;
public class topologicalSort {
      public void dfs_topo(int src,ArrayList<Edge>[] graph,boolean[] vis,ArrayList<Integer> topo){
            vis[src]=true;
    
            for(Edge e:graph[src]){
                if(!vis[e.nbr]){
                    dfs_topo(e.nbr,graph,vis,topo);
                }
            }
    
            topo.add(src);
        }
    
        public void topological_order(ArrayList<Edge>[] graph){
            int V=graph.length;
    
            boolean[] vis=new boolean[V];
            ArrayList<Integer> topo=new ArrayList<>();
            for(int i=0; i<V; i++){
                if(!vis[i]){
                    dfs_topo(i,graph,vis,topo);
                }
            }
    
            for(int i=topo.size()-1; i>=0; i--){
                System.out.println(topo.get(i));
            }
        }
     
}
