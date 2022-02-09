import java.util.*;
/// https://nados.io/question/optimize-water-distribution
public class OptimizeWaterDistribution {
      

// leet 1168 ====================================================
vector<int> par;
int fp(int u){
    return par[u] == u ? u : par[u]=fp(par[u]);
}

int minCostToSupplyWater(int n, vector<int>& wells, vector<vector<int>>& pipes) {
    par.resize(n+1);

    for(int i=0; i<=n; i++) par[i]=i;

    for(int i=0; i<wells.size(); i++){
        vector<int> pipe={0,i+1,wells[i]};
        pipes.push_back(pipe);
    }

    sort(pipes.begin(),pipes.end(),[](vector<int>& a, vector<int>& b){
        return a[2] < b[2];
    });


    int final_cost=0;
    for(int i=0; i<pipes.size(); i++){
        int u=pipes[i][0];
        int v=pipes[i][1];
        int c=pipes[i][2];

        int p1=fp(u);
        int p2=fp(v);

        if(p1!=p2){
            par[p2]=p1;
            final_cost+=c;
        }
    }

    return final_cost;
}


}
