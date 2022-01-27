import java.util.*;
public class O_I_Matrix {
      public int[][] updateMatrix(int[][] mat) {
            LinkedList<Integer> q=new LinkedList<>();
        
            int n=mat.length;
            int m=mat[0].length;
        
            boolean[][] vis=new boolean[n][m];
        
            for(int i=0; i<n; i++){
                for(int j=0; j<m; j++){
                    if(mat[i][j]==0){
                        q.addLast(i*m+j);
                        vis[i][j]=true;
                    }
                }
            }        
        int[][]grid=new int[n][m];
            int[][] dirs={{0,1},{1,0},{0,-1},{-1,0}};
            int level=0;
            while(q.size()>0){
                int s=q.size();
                while(s-->0){
                    int idx=q.removeFirst();
        
                    int i=idx/m;
                    int j=idx%m;
        
                    for(int[] dir:dirs){
                        int x=i+dir[0];
                        int y=j+dir[1];
        
                        if(x>=0 && y>=0 && x<n && y<m && !vis[x][y]){
                            vis[x][y]=true;
                            grid[x][y]=level+1;
                            q.addLast(x*m+y);
                        }
                    }        
                }
                level++;
            }
        
            return grid;
        }  
}
