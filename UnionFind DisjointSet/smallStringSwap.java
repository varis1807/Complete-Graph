import java.util.*;

public class smallStringSwap {
    public static int[] par;

    public static int findPar(int u) {
        if (par[u] == u)
            return u;
        return par[u] = findPar(par[u]);
    }

    public static  String smallestStringWithSwaps(String s, List<List<Integer>> pairs) {
            int n=s.length();
        
            par=new int[n];
        
            for(int i=0; i<n; i++){
                par[i]=i;
            }        
        
            for(List<Integer> p:pairs){
                int p1=findPar(p.get(0));
                int p2=findPar(p.get(1));
        
                if(p1!=p2){
                    par[p1]=p2;
                }
            }
        
             // parent vs group characaters
            HashMap<Integer,String> m=new HashMap<>();
        
            for(int i=0; i<n; i++){
                int p=findPar(i);
                m(p)=m[p]+s[i];
            }
        
            for(auto &kv:m){
                sort(kv.second.begin(),kv.second.end());
                reverse(kv.second.begin(),kv.second.end());
            }
        
            String ans="";
            for(int i=0; i<n; i++){
                int p=findPar(i);
        
                String s=m[p];
                ans+=s[s.size()-1];
        
                s.pop_back();
            }
        
            return ans;
        }
}
