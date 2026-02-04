public class Demo1 {
    private int key;
    private int m,n;
    private int ret;
    private boolean[][] visit;
    public int[][] floodFill(int[][] image, int sr, int sc, int color) {
        key = image[sr][sc];ret = color;
        m = image.length;n = image[0].length;
        visit = new boolean[m][n];
        visit[sr][sc] = true;
        dfs(image,sr,sc);
        return image;
    }
    int[] dx = {1,-1,0,0};
    int[] dy = {0,0,1,-1};
    public void dfs(int[][] image,int i,int j){
        image[i][j] = ret;
        for(int k = 0;k < 4;k++){
            int x = dx[k] + i;
            int y = dy[k] + j;
            //周围有连通块
            if(x >= 0&& x < m && y >=0 && y < n && !visit[x][y] && image[x][y] == key){
                image[x][y] = ret;
                visit[x][y] = true;
                dfs(image,x,y);
            }
        }
    }
}
