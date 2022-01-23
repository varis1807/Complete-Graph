import java.util.*;

public class maxWeight {
    public static class pathPair {
        String psf = "";
        int wsf = -1;
    }

    public static pathPair heaviestPath(ArrayList<Edge>[] graph, int src, int dest, boolean[] vis) {
        if (src == dest) {
            pathPair base = new pathPair();
            base.psf += src;
            base.wsf = 0;
            return base;
        }
        vis[src] = true;
        pathPair myAns = new pathPair();
        for (Edge e : graph[src]) {
            if (!vis[e.nbr]) {
                pathPair recAns = heaviestPath(graph, e.nbr, dest, vis);
                if (recAns.wsf != -1 && recAns.wsf + e.wt > myAns.wsf) {
                    myAns.psf = src + recAns.psf;
                    myAns.wsf = recAns.wsf + e.wt;
                }
            }
        }
        vis[src] = false;
        return myAns;
    }
    public static void heaviestPath(ArrayList<Edge>[] graph, int src, int dest) {
        boolean[] vis = new boolean[graph.length];
        pathPair ans = heaviestPath(graph, src, dest, vis);

        System.out.println("Heaviest Path: " + ans.psf + " of weight: " + ans.wsf);
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
        heaviestPath(graph, 3, 6);
    }

    public static void main(String[] args) {
        construction();
    }
}
