import java.util.*;
public class MinNoNetworkConnected {
      static int[] parent;
      static int[] size;
      public int findParent(int u){
          if(parent[u]==u)
              return u;
          return parent[u]=findParent(parent[u]);
      }
      public void merge(int p1,int p2){
          if(size[p1]>=size[p2]){
              parent[p1]=p2;
              size[p1]+=size[p2];
          }else{
              parent[p2]=p1;
              size[p2]+=size[p1];
          }
      }
      public int makeConnected(int n, int[][] connections) {
          parent=new int[n];
          size=new int[n];
          if(connections.length<n-1) return -1;
             for (int i = 0; i < n; i++) {
                    parent[i] = i;
                    size[i] = 1;
              }
              for (int[] e : connections) {
                    int u = e[0];
                    int v = e[1];
                    int p1 = findParent(u);
                    int p2 = findParent(v);
                    if (p1 != p2)
                          merge(p1, p2);
              }
              int number_component = 0;
              for (int i = 0; i < n; i++) {
                    int p = findParent(i);
                    if (i == p) {
                          number_component++;
                    }
              }
              return number_component-1;
      }
}
