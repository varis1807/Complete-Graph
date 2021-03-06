import java.util.*;
// link====?>> https://www.codingninjas.com/codestudio/problems/smallest-equivalent-string_1381859?leftPanelTab=0
public class smallestEquivalentStr {
      static int[] par;
      static int[] size;

      public static int findPar(int u) {
            if (par[u] == u)
                  return u;
            return par[u] = findPar(par[u]);
      }
      public static String smallestEquivalentString(String s1, String s2, String baseStr) {
            par = new int[26];

            for (int i = 0; i < 26; i++) {
                  par[i] = i;
            }

            for (int i = 0; i < s1.length(); i++) {
                  int u = s1.charAt(i) - 'a';
                  int v = s2.charAt(i) - 'a';

                  int p1 = findPar(u);
                  int p2 = findPar(v);

                  if (p1 != p2) {
                        par[p2] = Math.min(p1, p2);
                        par[p1] = Math.min(p1, p2);
                  }
            }

            String ans = "";
            for (int i = 0; i < baseStr.length(); i++) {
                  int u = baseStr.charAt(i) - 'a';

                  int p = findPar(u);
                  ans = ans + (char) ('a' + p);
            }
            return ans;
      }
}
