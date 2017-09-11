package airbnb;

/**
 * Created by tyh on 2017/9/11.
 */
public class UniquePath {
    public static void main(String[] args) {
        int m = 14;
        int n = 12;
        System.out.println(uniquePaths(m, n));
    }
    public static int uniquePaths(int m, int n) {
        if(m <= 0 || n <= 0){
            return 0;
        }
        int[][] map = new int[m][n];
        //initial
        for(int i = 0; i < m; i++){
            map[i][0] = 1;
        }
        for(int i = 1; i < n; i++){
            map[0][i] = 1;
        }
        for(int i = 1; i < m; i++){
            for(int j = 1; j < n; j++){
                map[i][j] = map[i-1][j] + map[i][j-1];
            }
        }
        return map[m-1][n-1];
    }
}
