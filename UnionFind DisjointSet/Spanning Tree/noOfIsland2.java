import java.util.*;
// https://www.lintcode.com/en/old/problem/number-of-islands-ii/#:~:text=Given%20a%20n%2Cm%20which%20means,two%20integer%20A%5Bi%5D.
public class noOfIsland2 {
      
// num of islands 2======================================

vector<int> par;
int findPar(int u){
    if(par[u]==u) return u;

    return par[u]=findPar(par[u]);
}

vector<int> numIslands2(int n, int m, vector<vector<int>>& positions) {
    vector<vector<int>> grid(n,vector<int>(m,0));

    par.resize(n*m);
    for(int i=0; i<n*m; i++){
        par[i]=i;
    }

    int count=0;
    vector<int> ans;

    vector<vector<int>> dirs={{0,1},{1,0},{0,-1},{-1,0}};

    for(int i=0; i<positions.size(); i++){
        int px=positions[i][0];
        int py=positions[i][1];

        if(grid[px][py]==1){
            ans.push_back(count);
            continue;
        }

        grid[px][py]=1;
        count++;
        int p1=findPar(px*m+py);
        for(auto &dir:dirs){
            int i=px+dir[0];
            int j=py+dir[1];

            if(i>=0 && j>=0 && i<n && j<m && grid[i][j]==1){
                int p2=findPar(i*m+j);

                if(p1!=p2){
                    par[p2]=p1;
                    count--;
                }
            }
        }
        ans.push_back(count);
    }

    return ans;
}

// num of islands 2 ===========================================================
vector<int> par;
int findPar(int u){
    return par[u]==u ? u : par[u]=findPar(par[u]);
}

vector<int> numIslands2(int n, int m, vector<vector<int>>& positions) {
    par.resize(n*m,-1); // -1 -> water

    int count=0;
    vector<int> ans;

    vector<vector<int>> dirs={{0,1},{1,0},{0,-1},{-1,0}};

    for(vector<int>& pos:positions){
        int px=pos[0];
        int py=pos[1];

        if(par[px*m+py]!=-1){
            ans.push_back(count);
            continue;
        }

        par[px*m+py]=px*m+py;
        count++;
        int p1=findPar(px*m+py);

        for(auto &dir:dirs){
            int i=px+dir[0];
            int j=py+dir[1];

            if(i>=0 && j>=0 && i<n && j<m && par[i*m+j]!=-1){
                int p2=findPar(i*m+j);

                if(p1!=p2){
                    par[p2]=p1;
                    count--;
                }
            }
        }
        ans.push_back(count);
    }
    return ans;    
}
}
