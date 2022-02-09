import java.util.*;
public class similarStringGrp{
      unordered_map<string,string> par;

      string findPar(string& u){
          if(par[u]==u) return u;
      
          return par[u]=findPar(par[u]);
      }
      
      bool isSimilar(string& a, string& b){
          int diff=0;
          for(int i=0; i<a.size(); i++){
              if(a[i]!=b[i]) diff++;
              if(diff>2) return false;
          }
      
          if(diff==0) return true;
      
          return diff==2;
      }
      
      int numSimilarGroups(vector<string>& strs) {
          for(string s:strs){
              par[s]=s;
          }
      
          int comps=strs.size();
      
      
          for(int i=0; i<strs.size(); i++){
              string p1=findPar(strs[i]);
              for(int j=i+1; j<strs.size(); j++){
                  if(isSimilar(strs[i],strs[j])){
                      string p2=findPar(strs[j]);
      
                      if(p1!=p2){
                          par[p2]=p1;
                          comps--;
                      }
                  }
              }
          }
      
          
      
          return comps;
      }
}