public class kahnsAlgo_Level {
      // level wise topo ordering 
    ArrayList<ArrayList<Integer>> topological_order_bfs(ArrayList<Edge>[] graph){
      int V=graph.length;

      int[] indegree=new int[V];

      for(int i=0; i<V; i++){
          for(Edge e:graph[i]){
              indegree[e.v]++;
          }
      }

      LinkedList<Integer> que=new LinkedList<>();
      ArrayList<ArrayList<Integer>> topo_order=new ArrayList<>();

      for(int i=0; i<V; i++){
          if(indegree[i]==0){
              que.addLast(i);
          }
      }

      while(que.size()>0){
         int size=que.size();
         ArrayList<Integer> smallAns=new ArrayList<>();
         while(size-->0){
             int ele=que.removeFirst();
              smallAns.add(ele);

              for(Edge e:graph[ele]){
                  indegree[e.v]--;
                  if(indegree[e.v]==0){
                      que.addLast(e.v);
                  }
              }
         }
         topo_order.add(smallAns);
      }

      return topo_order;
  }
}
