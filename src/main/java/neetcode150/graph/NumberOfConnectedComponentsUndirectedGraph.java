package neetcode150.graph;
    
public class NumberOfConnectedComponentsUndirectedGraph {

    public int countComponents(int n, int[][] edges) {
        Map<Integer, List<Integer>> map = new HashMap<>();
        for(int i=0;i<n;i++){
            map.put(i, new ArrayList<>());
        }
        for(int i=0;i<edges.length;i++){
            List<Integer> connected = map.get(edges[i][0]);
            connected.add(edges[i][1]);
            connected = map.get(edges[i][1]);
            connected.add(edges[i][0]);
        }
        Set<Integer> visited = new HashSet<>();
        int count = 0;
        for(int i=0;i<n;i++){
            if(!visited.contains(i)){
                dfs(i, map, visited);
                count++;
            }
        }
        return count;
    }

    public void dfs(int i, Map<Integer, List<Integer>> map, Set<Integer> visited){
        if(visited.contains(i)) return;
        visited.add(i);
        List<Integer> connected = map.get(i);
        for(Integer x: connected){
            if(!visited.contains(x)){
                dfs(x, map, visited);
            }
        }
    }
}
