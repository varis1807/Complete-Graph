import java.util.*;
public class maxAreaOfIsland {
      static int[] par;
      static int[] size;
     public static int maxAreaOfIsland(int[][] grid) {
            int n=grid.length;
            if(n==0) return 0;
        
            int m=grid[0].length;
        
            par=new int[n*m];
            size=new int[n*m];
        
            for(int i=0; i<n*m; i++){
                par[i]=i;
                size[i]=1;
            }
        
            vector<vector<int>> dirs={{0,1},{1,0},{0,-1},{-1,0}};
        
            for(int i=0; i<n; i++){
                for(int j=0; j<m; j++){
                    if(grid[i][j]==1){
                        int p1=findPar(i*m+j);
        
                        for(auto const& dir:dirs){
                            int x=i+dir[0];
                            int y=j+dir[1];
        
                            if(x>=0 && y>=0 && x<n && y<m && grid[x][y]==1){
                               
                                int p2=findPar(x*m+y);
                                
                                if(p1!=p2){
                                    // merge(p1,p2);
                                    par[p2]=p1;
                                    size[p1]+=size[p2];
                                }
                            }
                        }
                    }
                }
            }
        
            int maxArea=0;
            for(int i=0; i<n; i++){
                for(int j=0; j<m; j++){
                    if(grid[i][j]==1){
                        int p=findPar(i*m+j);
                        if(p==i*m+j){
                            maxArea=max(maxArea,size[i*m+j]);
                        }
                    }
                }
            }
        
            return maxArea;    
        }
         
}
