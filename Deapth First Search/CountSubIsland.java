import java.util.*;
public class CountSubIsland {
      public boolean dfs4(int[][] grid1, int[][] grid2, int i, int j, int n, int m){
            boolean ans= (grid1[i][j]==grid2[i][j]);
        
            int[][] dirs={{0,1},{1,0},{0,-1},{-1,0}};
            grid2[i][j]=0;
            for(int[] dir:dirs){
                int r=i+dir[0];
                int c=j+dir[1];
        
                if(r>=0 && c>=0 && r<n && c<m && grid2[r][c]==1){
                    ans = dfs4(grid1,grid2,r,c,n,m) && ans;
                }
            }
        
            return ans;
        }
        
        public int countSubIslands(int[][] grid1, int[][] grid2) {
            int ans=0;
            int n=grid1.length;
            int m=grid1[0].length;
        
            for(int i=0; i<n; i++){
                for(int j=0; j<m; j++){
                    if(grid2[i][j]==1){
                        boolean isSub=dfs4(grid1,grid2,i,j,n,m);
                        if(isSub) ans++;
                    }
                }
            }        
        
            return ans;
        }
        
}
