public class surroundedRegion {
      public void dfs3(int i, int j, char[][] board){
            board[i][j]='B';
        
            int[][] dirs={{0,1},{1,0},{0,-1},{-1,0}};
            for(int[] dir:dirs){
                int r=i+dir[0];
                int c=j+dir[1];
        
                if(r>=0 && c>=0 && r<board.length && c<board[0].length && board[r][c]=='O'){
                    dfs3(r,c,board);
                }
            }
        }
        
        public void solve(char[][] board) {
            int n=board.length;
            int m=board[0].length;
        
            for(int i=0; i<n; i++){
                for(int j=0; j<m; j++){
                    // calling dfs from boundaries 
                    if(i==0 || j==0 || i==n-1 || j==m-1){
                        if(board[i][j]=='O')
                            dfs3(i,j,board);
                    }
                }
            }        
        
            for(int i=0; i<n; i++){
                for(int j=0; j<m; j++){
                    if(board[i][j]=='O'){
                        board[i][j]='X';
                    } else if(board[i][j]=='B'){
                        board[i][j]='O';
                    }
                }
            }
        }
        
}
