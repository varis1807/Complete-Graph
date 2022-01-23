import java.util.*;

public class minWeight {
    public static class pair {
        String psf;
        int wsf;

        public pair(String psf, int wsf) {
            this.psf = psf;
            this.wsf = wsf;
        }
    }

    // minimum weight path (which and with what weight)
    public static pair minWeightPath(int src, int des, ArrayList<Edge>[] graph, boolean[] vis) {
        if (src == des) {
            return new pair("" + des, 0);
        }

        vis[src] = true;

        pair myAns = new pair("", (int) (1e9));
        for (Edge e : graph[src]) {
            if (vis[e.nbr])
                continue;

            pair recAns = minWeightPath(e.nbr, des, graph, vis);

            if (recAns.wsf != (int) (1e9) && recAns.wsf + e.wt < myAns.wsf) {
                myAns.wsf = recAns.wsf + e.wt;
                myAns.psf = src + recAns.psf;
            }
        }
        vis[src] = false;
        return myAns;
    }

    public static void lightestPath(ArrayList<Edge>[] graph, int src, int dest) {
        pair ans = minWeightPath(3, 6, graph, new boolean[7]);
        System.out.println(ans.psf + "->> " + ans.wsf);
    }

    public static void addEdge(ArrayList<Edge>[] graph, int u, int v, int w) {
        graph[u].add(new Edge(u, v, w));
        graph[v].add(new Edge(v, u, w));
    }

    public static void construction() {
        int N = 7;
        ArrayList<Edge>[] graph = new ArrayList[7];
        for (int i = 0; i < N; i++)
            graph[i] = new ArrayList<>();
        addEdge(graph, 0, 1, 10);
        addEdge(graph, 0, 3, 10);
        addEdge(graph, 1, 2, 10);
        addEdge(graph, 2, 3, 40);
        addEdge(graph, 3, 4, 2);
        addEdge(graph, 4, 5, 2);
        addEdge(graph, 4, 6, 8);
        addEdge(graph, 5, 6, 3);
        lightestPath(graph, 3, 6);
    }

    public static void main(String[] args) {
        construction();
    }
}
