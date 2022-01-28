import java.util.*;
public class journeyToMoon {
      vis[src] = true;
      int size = 0;
      for(int nbr:graph.get(src)){
              if(!vis[nbr]){
                  size += dfsJourney(nbr, graph, vis);
              }
      }
      return size+1;
  }
  
  public static long journeyToMoon(int n, List<List<Integer>> astronaut) {
  // Write your code here
      List<List<Integer>> graph = new ArrayList<>();
      
      for(int i=0;i<n;i++){
          graph.add(new ArrayList<Integer>());
      }
      // making the graph according to the list given
      for(int i=0;i<astronaut.size();i++){
          List<Integer> ast = astronaut.get(i);
          graph.get(ast.get(0)).add(ast.get(1));
          graph.get(ast.get(1)).add(ast.get(0));
      }
      
      boolean[] vis = new boolean[n];
      long ans = 0, totalSize = 0, size=0;
      
      for(int i=0;i<n;i++){
          if(!vis[i]){
              size = dfsJourney(i,graph,vis);
              ans = ans + totalSize * size;
              totalSize += size;
          }
      }
      return ans;
  }

}
