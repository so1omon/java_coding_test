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
    String[] t = {
        "awfawe",
        "ewafawef"
    };
    String test = String.valueOf(t);

    public static void main(String[] args) {
        // example graph
        String[] t = {
            "awfawe",
            "ewafawef"
        };
        String test = String.join(" ",t);
        System.out.println(test);
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