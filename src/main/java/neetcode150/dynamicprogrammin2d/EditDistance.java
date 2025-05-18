package neetcode150.dynamicprogrammin2d;

public class EditDistance {
    public int minDistance(String word1, String word2) {
        int m = word1.length();
        int n = word2.length();
        int[][] memo = new int[m][n];
        for(int[] x: memo){
            Arrays.fill(x, -1);
        }
        return dfs(0, 0, word1, word2, memo);
    }

    public int dfs(int i, int j, String word1,String word2, int[][] memo){
        if(i>=word1.length() && j>=word2.length()) return 0;
        if(i>=word1.length()) return word2.length() - j;
        if(j>=word2.length()) return word1.length() - i;
        if(memo[i][j] != -1) return memo[i][j];
        if(word1.charAt(i) == word2.charAt(j)) {
            memo[i][j] = dfs(i+1, j+1, word1, word2, memo);
            return memo[i][j];
        }
        int insertCount = 0;
        int updateCount = 0;
        int deleteCount = 0;
        // insert
        insertCount = 1+ dfs(i, j+1, word1, word2, memo);
        // update
        updateCount = 1+ dfs(i+1, j+1, word1, word2, memo);
        // delete
        deleteCount = 1+dfs(i+1, j, word1, word2, memo);
        memo[i][j] = Math.min(Math.min(insertCount, updateCount), deleteCount);
        return memo[i][j];
    }
}