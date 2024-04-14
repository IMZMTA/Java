import java.util.*;

public class GraphImplemnt{

    static class Edge {
    
        int src, dest, wt;

        public Edge(int s, int d, int w){

            this.src = s;
            this.dest = d;
            this.wt = w;

        }
    }

    static void createGraph(ArrayList<Edge> graph[]){
        for(int i=0; i<graph.length; i++){
            graph[i] = new ArrayList<>();
        }

        graph[0].add(new Edge(0, 1, 1));
        graph[0].add(new Edge(0, 2, 1));

        graph[1].add(new Edge(1, 0, 1));
        graph[1].add(new Edge(1, 3, 1));

        graph[2].add(new Edge(2, 0, 1));
        graph[2].add(new Edge(2, 4, 1));

        graph[3].add(new Edge(3, 1, 1));
        graph[3].add(new Edge(3, 4, 1));
        graph[3].add(new Edge(3, 5, 1));

        graph[4].add(new Edge(4, 2, 1));
        graph[4].add(new Edge(4, 3, 1));
        graph[4].add(new Edge(4, 5, 1));

        graph[5].add(new Edge(5, 3, 1));
        graph[5].add(new Edge(5, 4, 1));
        graph[5].add(new Edge(5, 6, 1));

        graph[6].add(new Edge(6, 5, 1));
    }

    public static void bfs(ArrayList<Edge> graph[]){ //O(n) or O(V+E) - Adjancy list but for adjancy matrix O(v^2)
        Queue<Integer> q = new LinkedList<>();
        boolean vist[] = new boolean[graph.length];

        //source
        q.add(0);
        // loop for bfs travels
        while(!q.isEmpty()){
            int curr = q.remove();
            // visite curr first time
            if(!vist[curr]){ // visit contains 3 steps
                System.out.print(curr + " "); //print the vertex visited
                vist[curr] = true;  // make true for visit
                for(int i=0; i<graph[curr].size(); i++){
                    Edge e = graph[curr].get(i);
                    q.add(e.dest);
                }

            }
        }
    }

    public static void dfs(ArrayList<Edge> graph[], int curr, boolean vis[]){ //O(V+E)

        //visit
        System.out.print(curr + " ");
        vis[curr] = true;

        //neighbour
        for(int i =0; i<graph[curr].size(); i++){
            Edge e = graph[curr].get(i);
            if(!vis[e.dest]){
                dfs(graph, e.dest, vis);
            }
        }

    }

    public static boolean hasPath(ArrayList<Edge> graph[], int src, int dest, boolean vis[]){ //O(V+E)
        if(src == dest){
            return true;
        }

        vis[src] = true;

        //neighbour
        for(int i =0; i<graph[src].size(); i++){
            Edge e = graph[src].get(i);
            //e.dest = neighbour
            if(!vis[e.dest] && hasPath(graph, e.dest, dest, vis)){
                return true;
            }
        }
        return false;
    }

    public static void main(String[] args) {
        
        int v =5;
        ArrayList<Edge>[] graph = new ArrayList[v]; //Stored->Each have null value

        for(int i=0; i<v; i++){
            graph[i] = new ArrayList<>();
        }

        //0 - vertex
        graph[0].add(new Edge(0, 1, 5));
        //1 - vertex
        graph[1].add(new Edge(1, 0, 5));
        graph[1].add(new Edge(1, 2, 1));
        graph[1].add(new Edge(1, 3, 3));
        //2 - vertex
        graph[2].add(new Edge(2, 1, 1));
        graph[2].add(new Edge(2, 3, 1));
        graph[2].add(new Edge(2, 4, 2));
        //3 - Vertex
        graph[3].add(new Edge(3, 1, 3));
        graph[3].add(new Edge(3, 2, 1));
        //4 - Vertex
        graph[4].add(new Edge(4, 2, 2));

        // 2's neighbour
        for(int i=0; i<graph[2].size(); i++){
            Edge e = graph[2].get(i);
            System.out.print(e.dest + ", ");
        }

        //------------New Implement----------//
        System.out.println();
        int V=7;
        ArrayList<Edge> grap[] = new ArrayList[V];
        System.out.print("BFS ---- ");
        createGraph(grap);
        bfs(grap);
        
        System.out.println();
        System.out.print("DFS ---- ");
        dfs(grap, 0, new boolean[V]);

        System.out.println();
        System.out.println(hasPath(grap,0,5,new boolean[V]));
        System.out.println(hasPath(grap,0,7,new boolean[V]));
    }
}