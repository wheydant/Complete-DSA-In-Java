package KunalKushwaha.Assignments.Recursion;

public class WordSearch {
    boolean foundWord(int i, int j, int charAt, char[][] board, String word, int n, int m, boolean[][] vis){
        if(charAt == word.length()) return true;
        if(i < 0 || j < 0 || i >= n || j >= m) return false;

        boolean up, down, right, left;
        if(board[i][j] == word.charAt(charAt) && !vis[i][j]){
            vis[i][j] = true;
            //up
            up = foundWord(i - 1, j, charAt + 1, board, word, n, m, vis);

            //down
            down = foundWord(i + 1, j, charAt + 1, board, word, n, m, vis);

            //right
            right = foundWord(i, j + 1, charAt + 1, board, word, n, m, vis);

            //left
            left = foundWord(i, j - 1, charAt + 1, board, word, n, m, vis);

            vis[i][j] = false;
        }else return false;

        return up || down || right || left;
    }
    public boolean exist(char[][] board, String word) {
        int n = board.length;
        int m = board[0].length;
        boolean[][] vis = new boolean[n][m];
        for(int i = 0; i < n; i++){
            for(int j = 0; j < m; j++){
                if(foundWord(i, j, 0, board, word, n, m, vis))
                    return true;
            }
        }

        return false;
    }
    public static void main(String[] args) {
        System.out.println(new WordSearch().exist(new char[][]{
            {'A','B','C','E'},
            {'S','F','C','S'},
            {'A','D','E','E'}
        }, "ABCB"));
    }
}
