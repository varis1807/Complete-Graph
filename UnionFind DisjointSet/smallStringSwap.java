import java.util.*;
public class smallStringSwap {
      string smallestStringWithSwaps(string s, vector<vector<int>>& pairs) {
            int n=s.size();
        
            par.resize(n);
        
            for(int i=0; i<n; i++){
                par[i]=i;
            }        
        
            for(auto &p:pairs){
                int p1=findPar(p[0]);
                int p2=findPar(p[1]);
        
                if(p1!=p2){
                    par[p1]=p2;
                }
            }
        
            unordered_map<int,string> m; // parent vs group characaters
        
            for(int i=0; i<n; i++){
                int p=findPar(i);
                m[p]=m[p]+s[i];
            }
        
            for(auto &kv:m){
                sort(kv.second.begin(),kv.second.end());
                reverse(kv.second.begin(),kv.second.end());
            }
        
            string ans="";
            for(int i=0; i<n; i++){
                int p=findPar(i);
        
                string &s=m[p];
                ans+=s[s.size()-1];
        
                s.pop_back();
            }
        
            return ans;
        }
}
