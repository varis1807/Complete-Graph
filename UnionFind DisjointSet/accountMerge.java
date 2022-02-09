public class accountMerge {
      vector<int> par;
int findPar(int u){
    if(par[u]==u){
        return u;
    }

    return par[u]=findPar(par[u]);
}

vector<vector<string>> accountsMerge(vector<vector<string>>& accounts) {
    unordered_map<string,int> etuid; // email to unique id
    unordered_map<string,string> etn; // email to name
    int uid=0;

    par.resize(1001);
    for(int i=0; i<=1000; i++){
        par[i]=i;
    }

    for(auto &account:accounts){
        string name=account[0];
        for(int i=1; i<account.size(); i++){
            string email=account[i];

            if(etuid.find(email)==etuid.end()){
                etuid[email]=uid;
                uid++;
            }

            etn[email]=name;

            // parent of first email id in this account
            int p1=findPar(etuid[account[1]]);
            // parent of current email
            int p2=findPar(etuid[email]);

            if(p1!=p2){
                par[p2]=p1;
            }
        }
    }

    vector<vector<string>> ans;
    unordered_map<int,vector<string>> res; // par vs emails

    for(auto &kv:etuid){
        int id=kv.second;

        int p=findPar(id);
        if(res.find(p)==res.end()){
            res[p]={kv.first};
        } else {
            res[p].push_back(kv.first);
        }
    }

    for(auto &kv:res){
        vector<string> &emails=kv.second;

        sort(emails.begin(),emails.end());
        // inserting name in the front
        emails.insert(emails.begin(),etn[emails[0]]);

        ans.push_back(emails);
    }

    return;
}
}
