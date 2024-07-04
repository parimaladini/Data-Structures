import java.util.ArrayList;
import java.util.Queue;
import java.util.LinkedList;

public class AdjacencyList {
    static class Edge{
        int source;
        int dest;
        int weight;

        public Edge(int s, int d, int w){
            this.source = s;
            this.dest = d;
            this.weight = w;
        }
    }

    public static void buildGraph(ArrayList<Edge>[] graph, int v){

        for(int i=0; i<v; i++){
            graph[i] = new ArrayList<>();
        }

        graph[0].add(new Edge(0, 1, 5));

        graph[1].add(new Edge(1, 0, 5));
        graph[1].add(new Edge(1, 2, 1));
        graph[1].add(new Edge(1, 3, 3));

        graph[2].add(new Edge(2, 1, 1));
        graph[2].add(new Edge(2, 4, 2));
        graph[2].add(new Edge(2, 3, 1));

        graph[3].add(new Edge(3, 1, 3));
        graph[3].add(new Edge(3, 2, 1));

        graph[4].add(new Edge(4, 2, 2));

    }

    public static void bfs(ArrayList<Edge>[] graph){ // O(V+E)

        Queue<Integer> queue = new LinkedList<>();
        boolean[] vis = new boolean[graph.length];
        queue.add(0);

        while(!queue.isEmpty()){
            int value = queue.remove();

            if(!vis[value]){
                System.out.print(value+" ");
                vis[value] = true;

                for(int i=0; i<graph[value].size(); i++){
                    Edge e = graph[value].get(i);
                    queue.add(e.dest);
                }
            }
        }

    }

    public static void dfs(ArrayList<Edge>[] graph, int curr, boolean[] vis){  // O(V+E)
        System.out.print(curr + " ");
        vis[curr] = true;

        for(int i=0; i<graph[curr].size(); i++){
            Edge e = graph[curr].get(i);
            if(!vis[e.dest]){
                dfs(graph, e.dest, vis);
            }
        }
    }

    // Checks whether there exists a path between the source and the destination..
    public static boolean hasPath(ArrayList<Edge>[] graph, int src, int dest, boolean[] vis){
        if(src == dest)
            return true;

        vis[src] = true;
        for(int i=0; i<graph[src].size(); i++){
            Edge e = graph[src].get(i);

            if(!vis[e.dest] && hasPath(graph, e.dest, dest, vis))
                return true;
        }

        return false;
    }

    public static void main(String[] args) {

        int v = 5;
        ArrayList<Edge>[] graph = new ArrayList[v];

        buildGraph(graph, v);
        bfs(graph);
        System.out.println();
        dfs(graph, 0, new boolean[v]);
        System.out.println();
        boolean result = hasPath(graph, 0, 4, new boolean[v]);
        System.out.println(result);

    }

}
