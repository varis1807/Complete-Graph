import java.util.*;
// https://www.lintcode.com/en/old/problem/number-of-islands-ii/#:~:text=Given%20a%20n%2Cm%20which%20means,two%20integer%20A%5Bi%5D.
public class noOfIsland2 {
      
// num of islands 2======================================

int[] par;
public int findPar(int u){
    if(par[u]==u) return u;

    return par[u]=findPar(par[u]);
}

public List<Integer> numIslands2(int n, int m, int[][] positions) {
    int[][] grid=new int[n][m];

    par=new int[n*m];
    for(int i=0; i<n*m; i++){
        par[i]=i;
    }

    int[][] dirs={{0,1},{1,0},{0,-1},{-1,0}};

    List<Integer> ans=new ArrayList<>();
    int count=0;
    for(int[] pos:positions){
        int x=pos[0];
        int y=pos[1];

        if(grid[x][y]==1){
            ans.add(count);
            continue;
        }

        grid[x][y]=1;
        count++;
        int p1=findPar(x*m+y);
        for(int[] dir:dirs){
            int i=x+dir[0];
            int j=y+dir[1];

            if(i>=0 && j>=0 && i<n && j<m && grid[i][j]==1){
                int p2=findPar(i*m+j);

                if(p1!=p2){
                    par[p2]=p1;
                    count--;
                }
            }
        }
        ans.add(count);
    }

    return ans;
}
}
