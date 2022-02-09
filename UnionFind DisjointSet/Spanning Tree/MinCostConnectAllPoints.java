import java.util.*;
public class MinCostConnectAllPoints {
      
// leet 1584 ============================================================ 
vector<int> par;
vector<int> size;
int fp(int u){
    return par[u] == u ? u : par[u]=fp(par[u]);
}

void merge(int p1, int p2){
    if(size[p2]<=size[p1]){
        par[p2]=p1;
        size[p1]+=size[p2];
    } else {
        par[p1]=p2;
        size[p2]+=size[p1];
    }
}

int getDis(vector<int>& c1, vector<int>& c2){
    return abs(c1[0]-c2[0]) + abs(c1[1]-c2[1]);
}
int minCostConnectPoints(vector<vector<int>>& points) {
    vector<vector<int>> edges;

    int n=points.size();

    par.resize(n);
    size.resize(n,1);

    for(int i=0; i<n; i++) par[i]=i;

    for(int i=0; i<n; i++){
        for(int j=i+1; j<n; j++){
            int dis=getDis(points[i],points[j]);

            edges.push_back({i,j,dis});
        }
    }        

    sort(edges.begin(),edges.end(),[](vector<int>& a, vector<int>& b){
        return a[2] < b[2];
    });

    int cost=0;
    for(int i=0; i<edges.size(); i++){
        int u=edges[i][0];
        int v=edges[i][1];
        int w=edges[i][2];

        int p1=fp(u);
        int p2=fp(v);

        if(p1!=p2){
            par[p2]=p1;
            cost+=w;
        }
    }

    return cost;
}

}
