package neetcode150.backTracking;

public class WordSearch {
    public boolean exist(char[][] board, String word) {
        boolean[][] used = new boolean[board.length][board[0].length];
        for(int i=0;i<board.length;i++){
            for(int j=0;j<board[0].length;j++){
                if(backTrack(i, j, board, word, 0, used)) return true;
            }
        }
        return false;
    }

    public boolean backTrack(int x, int y, char[][] board, String word, int i, boolean[][] used){
        // base case
        if(i >= word.length()) return true;
        if(x >= board.length || y>=board[0].length || x<0 || y<0 ) return false;
        if(used[x][y] || board[x][y] != word.charAt(i)){
            return false;
        }
        used[x][y] = true;
        var res=  backTrack(x-1, y, board, word, i+1, used) ||
                backTrack(x+1, y, board, word, i+1, used) ||
                backTrack(x, y-1, board, word, i+1, used) ||
                backTrack(x, y+1, board, word, i+1, used);
        used[x][y] = false;
        return res;
    }
}

