package neetcode150.graph;
    
public class NumberOfConnectedComponentsUndirectedGraphUnionFind {

    public int countComponents(int n, int[][] edges) {
        int[] parent = IntStream.rangeClosed(0, n).toArray();
        int[] rank = new int[n];
        int res = n;
        for(int i=0;i<edges.length;i++){
            int[] edge = edges[i];
            res -= union(edge[0], edge[1], rank, parent);
        }
        return res;
    }

    public int find(int i, int[] parent){
        int foundParent = i;
        while(foundParent != parent[foundParent]){
            foundParent = parent[foundParent];
        }
        return foundParent;
    }

    public int union(int x, int y, int[] rank, int[] parent){
        int p1 = find(x, parent);
        int p2 = find(y, parent);
        if(p1 == p2) return 0;
        if(rank[p1] > rank[p2]){
            parent[p2] = p1;
            rank[p1] += rank[p2];
        } else{
            parent[p1] = p2;
            rank[p2] += rank[p1];
        }
        return 1;
    }
}
