package 김솔민;
import java.io.*;
import java.util.*;
import java.io.*;

public class Main {
    static class Edge{
        int source, dest, weight;
        Edge(int... args){
            this.source = args[0];
            this.dest = args[1];
            this.weight = args[2];
        }
    }



    public static void main(String[] args) {
        // example graph
        Edge[] edges = {
            new Edge(0, 1, 2),
            new Edge(0, 3, 6),
            new Edge(1, 2, 3),
            new Edge(1, 3, 8),
            new Edge(1, 4, 5),
            new Edge(2, 4, 7),
            new Edge(3, 4, 9)
        };
        int n = 5;

        kruskalMST(edges, n);
    }

    private static void kruskalMST(Edge[] edges, int n) {
        Arrays.sort(edges, (e1, e2)->{
            return e1.weight-e2.weight;
        });

        int[] parent = new int[n];
        Arrays.fill(parent, -1);

        List<Edge> mst = new ArrayList<>();

        int count = 0;
        for(Edge edge : edges){
            int srcParent = find(parent, edge.source);
            int destParent = find(parent, edge.dest);

            if(srcParent!=destParent){
                mst.add(edge);
                union(parent, srcParent, destParent);
                count++;
            }

            if(count==n-1){
                break;
            }
        }

        System.out.println("Minimum Spanning Tree:");
        for (Edge edge : mst) {
            System.out.println(edge.source + " - " + edge.dest);
        }

    }
    static void union(int[] parent, int source, int dest){
        parent[source] = dest;
    }

    static int find(int[] parent, int v){
        if(parent[v]==-1){
            return v;
        }
        return find(parent, parent[v]);
    }


}