import java.io.*; 
import java.util.*; 
class DFS_second{ 

    private int V;    
    private static LinkedList<Integer> adj[];  
 
    DFS_second(int v){ 
        V = v; 
        adj = new LinkedList[v]; 
        for(int i=0; i<v; ++i) 
            adj[i] = new LinkedList(); 
    } 
    void addEdge(int v,int w){ 
        adj[v].add(w); 
        adj[w].add(v); 
    } 
    Boolean isCyclicUtil(int v, Boolean visited[], int parent){ 
        visited[v] = true; 
        Integer i; 
        Iterator<Integer> it =  
                adj[v].iterator(); 
        while (it.hasNext()){ 
            i = it.next(); 

            if (!visited[i]){ 
                if (isCyclicUtil(i, visited, v)) 
                    return true; 
            } 
            else if (i != parent) 
                return true; 
        } 
        return false; 
    } 

    Boolean isCyclic(){ 
        Boolean visited[] = new Boolean[V]; 
        for (int i = 0; i < V; i++) 
            visited[i] = false; 
        for (int u = 0; u < V; u++){   
            if (!visited[u])  
                if (isCyclicUtil(u, visited, -1)) 
                    return true; 
        } 
  
        return false; 
    } 
    public static void main(String args[]){ 
          
        DFS_second g = new DFS_second(7); 
        g.addEdge(0, 1); 
        g.addEdge(0, 2); 
        g.addEdge(0, 5); 
        g.addEdge(0, 6); 
        g.addEdge(1, 3);
        g.addEdge(2, 3); 
        g.addEdge(2, 4);
        g.addEdge(4, 5); 
        g.addEdge(4, 6); 


        if (g.isCyclic()) 
            for (int i = 0; i<adj.length; i++) {     
                System.out.println(g.adj[i]); 
            }
        else
            System.out.println("Graph  doesn't contains cycle"); 
    } 
}