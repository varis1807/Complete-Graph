import java.util.*;
public class smallestEquivalentStr {
      static int[] par;
      static int[] size;
      string smallestEquivalentString(string s1, string s2, string baseStr) {
            par.resize(26);
        
            for(int i=0; i<26; i++){
                par[i]=i;
            }        
        
            for(int i=0; i<s1.size(); i++){
                int u=s1[i]-'a';
                int v=s2[i]-'a';
        
                int p1=findPar(u);
                int p2=findPar(v);
        
                if(p1!=p2){
                    par[p2]=min(p1,p2);
                    par[p1]=min(p1,p2);
                }
            }
        
            string ans="";
            for(int i=0; i<baseStr.size(); i++){
                int u=baseStr[i]-'a';
        
                int p=findPar(u);
                ans=ans+(char)('a'+p);
            }
        
            return ans;
        }
}
