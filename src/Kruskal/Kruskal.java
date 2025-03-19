package Kruskal;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;

public class Kruskal {
    public static void main(String[] args) {
        int vertices = 5;
        int x, y;

        int [] p = new int[vertices];

        // Initialize Parent Array
        Arrays.fill(p, -1);

        ArrayList<Edge> graph = new ArrayList<Edge>();
        ArrayList<Edge> mts = new ArrayList<Edge>();

        createGraph(graph);
        sortEdges(graph);

        for(int i = 0; i < vertices; i++) {
            x = compressedFind(graph.get(i).getSource(), p);
            y = compressedFind(graph.get(i).getDestination(), p);

            if(x != y){
                mts.add(graph.get(i));
                wightedUnion(x, y, p);
            }
        }

        for (Edge mt : mts) {
            System.out.println(mt.toString());
        }
    }

    public static void wightedUnion(int u, int v, int[] p) {
        if(p[u] > p[v]) {
            p[u] = p[u]+p[v];
            p[v] = u;
        } else {
            p[v] = p[u]+p[v];
            p[u] = v ;
        }
    }

    public static int compressedFind(int v, int[]p) {
        if(p[v] < 0)
            return v;

        p[v] = compressedFind(p[v], p);
        return p[v];
    }

    private static void createGraph(ArrayList<Edge> graph) {
        Edge edge1_2 = new Edge(1, 2, 9);
        Edge edge3_2 = new Edge(2, 3, 4);
        Edge edge4_3 = new Edge(4, 3, 7);
        Edge edge1_3 = new Edge(1, 3, 8);
        Edge edge1_4 = new Edge(1, 4, 3);

        graph.add(edge4_3);
        graph.add(edge1_4);
        graph.add(edge1_3);
        graph.add(edge1_2);
        graph.add(edge3_2);
    }

    private static void sortEdges(ArrayList<Edge> graph) {
        graph.sort(Comparator.comparingInt(edge -> edge.weight));
    }
}
