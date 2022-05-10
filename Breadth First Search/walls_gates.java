public class walls_gates {
      public void wallsAndGates(int[][] rooms) {
            int n=rooms.length;
            int m=rooms[0].length;
            int[][] dir={{1,0},{-1,0},{0,1},{0,-1}};
            LinkedList<Integer> que=new LinkedList<>();
            for(int i=0; i<n; i++){
                for(int j=0; j<m; j++){
                    if(rooms[i][j]==0)
                    que.addFirst(i*m+j);
                }
            }
            while(que.size()!=0){
                int size=que.size();
                while(size-->0){
                    int idx=que.removeFirst();
                    int sr=idx/m, sc=idx%m;
                    for(int d=0; d<4; d++){
                        int r=sr+dir[d][0];
                        int c=sc+dir[d][1];
                        if(r>=0 && c>=0 && r<n && c<m && rooms[r][c]==2147483647){
                            rooms[r][c]=rooms[sr][sc]+1;
                            que.addLast(r*m+c);
                        }
                    }
                }
            }
         }
}
