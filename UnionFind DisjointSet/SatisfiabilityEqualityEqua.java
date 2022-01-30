import java.util.*;

public class SatisfiabilityEqualityEqua {
      // leet 990 =============================================
      static int[] par;

      public static int fp(int u) {
            if (par[u] == u)
                  return u;
            return par[u] = fp(par[u]);
      }

      public static boolean equationsPossible(String[] equations) {
            par = new int[26];

            for (int i = 0; i < 26; i++) {
                  par[i] = i;
            }

            for (String eq : equations) {
                  if (eq.charAt(1) == '=') {
                        int p1 = fp(eq.charAt(0) - 'a');
                        int p2 = fp(eq.charAt(3) - 'a');

                        if (p1 != p2) {
                              par[p1] = p2;
                        }
                  }
            }

            for (String eq : equations) {
                  if (eq.charAt(1) == '!') {
                        int p1 = fp(eq.charAt(0) - 'a');
                        int p2 = fp(eq.charAt(3) - 'a');

                        if (p1 == p2) {
                              return false;
                        }
                  }
            }

            return true;
      }
}
