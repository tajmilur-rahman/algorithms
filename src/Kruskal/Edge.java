package Kruskal;

public class Edge {
    int source;
    int destination;
    int weight;

    public Edge(int source, int destination, int weight) {
        this.source = source;
        this.destination = destination;
        this.weight = weight;
    }

    public int getDestination() {return destination;}

    public int getSource() {return source;}

    @Override
    public String toString() {
        return "(" + source + "," + destination + ")" + " Weight: " + weight ;
    }
}
