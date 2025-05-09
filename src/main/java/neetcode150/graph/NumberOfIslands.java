package neetcode150.graph;

public class NumberOfIslands {

    public int numIslands(char[][] grid) {
        int count = 0;
        boolean[][] used = new boolean[grid.length][grid[0].length];
        for(int i=0;i<grid.length;i++){
            for(int j=0;j<grid[0].length;j++){
                if(grid[i][j] == '0') continue;
                if(grid[i][j] == '1' && !used[i][j]){
                    count++;
                    dfs(i, j, grid, used);
                }
            }
        }
        return count;
    }

    public void dfs(int x, int y, char[][] grid, boolean[][] used){
        if(x<0 || y<0 || x>=grid.length || y>= grid[0].length) return;
        if(used[x][y]) return;
        if(grid[x][y] == '1'){
            used[x][y] = true;
            dfs(x-1, y, grid, used);
            dfs(x+1, y, grid, used);
            dfs(x, y+1, grid, used);
            dfs(x, y-1, grid, used);
        }
    }
}
