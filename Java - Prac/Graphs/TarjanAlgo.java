import java.util.ArrayList;

public class TarjanAlgo {
    static class Edge {
        int src, dest;
        public Edge(int s, int d){
            this.src = s;
            this.dest = d;
        }
    }

    public static void createGraph(ArrayList<Edge> graph[]){
        for(int i=0; i<graph.length; i++){
            graph[i] = new ArrayList<Edge>();
        }

        graph[0].add(new Edge(0, 1));
        graph[0].add(new Edge(0, 2));
        graph[0].add(new Edge(0, 3));

        graph[1].add(new Edge(1, 0));
        graph[1].add(new Edge(1, 2));

        graph[2].add(new Edge(2, 0));
        graph[2].add(new Edge(2, 1));

        graph[3].add(new Edge(3, 0));
        graph[3].add(new Edge(3, 4));
        graph[3].add(new Edge(3, 5));

        graph[4].add(new Edge(4, 3));
        graph[4].add(new Edge(4, 5));

        graph[5].add(new Edge(5, 3));
        graph[5].add(new Edge(5, 4));
    }

    public static void dfs(ArrayList<Edge> graph[], int curr, int par, int dt[], int low[], boolean vis[], int time){

        vis[curr] = true;
        dt[curr] = low[curr] = ++time;

        for(int i=0; i<graph[curr].size(); i++){
            Edge e = graph[curr].get(i); //e.src -> e.dest;
            int neigh = e.dest;
            if(neigh == par){
                continue;
            }
            else if(!vis[neigh]){
                dfs(graph, neigh, curr, dt, low, vis, time);
                low[curr] = Math.min(low[curr], low[neigh]);
                if(dt[curr] < low[neigh]){
                    System.out.print("Bridge : " + curr + " --> " + neigh);
                }
            }else{
                low[curr] = Math.min(low[curr], dt[neigh]);
            }
        }
    }

    public static void tarjanBridge(ArrayList<Edge> graph[], int V){
        int dt[] = new int[V];
        int low[] = new int[V];
        int time = 0;
        boolean vis[] = new boolean[V];

        for(int i=0; i<V; i++){
            if(!vis[i]){
                dfs(graph,i,-1,dt,low,vis,time);
            }
        }
    }

    //Articulation Point A.P ->O(V+E) otherwise O(V*(V+E))

    public static void apdfs(ArrayList<Edge> graph[], int curr, int par, int adt[], int alow[], int time, boolean avis[], boolean apt[]){

        int children = 0;
        adt[curr] = alow[curr] = ++time;
        avis[curr] = true;

        for(int i=0; i<graph[curr].size(); i++){
            Edge e = graph[curr].get(i);
            int neigh = e.dest;
            if(neigh == par){
                continue;
            }else if(!avis[neigh]){
                apdfs(graph,neigh,curr,adt,alow,time,avis,apt);
                alow[curr] = Math.min(alow[curr], alow[neigh]);
                if(par!= -1 && adt[curr] <= alow[neigh]){
                    // System.out.println("Ap :" + curr);
                    apt[curr] = true;
                }
                children++;
            }else{
                alow[curr] = Math.min(alow[curr],adt[neigh]);
            }
        }
        if(par == -1 && children > 1){
            // System.out.println("Ap :" + curr);
            apt[curr] = true;
        }
    }

    public static void ap(ArrayList<Edge> graph[], int V){
        int adt[] = new int[V];
        int alow[] = new int[V];
        boolean avis[] = new boolean[V];
        int time = 0;

        boolean apt[] = new boolean[V];

        for(int i=0; i<V; i++){
            if(!avis[i]){
                apdfs(graph,i,-1,adt,alow,time,avis, apt);
            }
        }

        for(int i=0; i<V;i++){
            if(apt[i]){
                System.out.println("Ap :" + i);
            }
        }
    }

    public static void main(String[] args) {

        int V = 6;
        ArrayList<Edge> graph[] = new ArrayList[V];
        createGraph(graph);
        tarjanBridge(graph, V);

        System.out.println();
        ap(graph, V);
    }
}
