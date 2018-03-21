package interview.airbnb;

/**
 * Created by tyh on 2017/9/11.
 */
public class UniquePathII {
    public static void main(String[] args) {
        int[][] obstacleGrid = new int[][]{{0,0,0}, {0,1,0}, {0,0,0}};
        System.out.println(uniquePathsWithObstacles(obstacleGrid));
    }
    public static int uniquePathsWithObstacles(int[][] obstacleGrid) {
        if(obstacleGrid.length == 0 || obstacleGrid[0].length == 0){
            return 0;
        }
        int row = obstacleGrid.length;
        int col = obstacleGrid[0].length;
        int[][] map = new int[row][col];
        //initial
        for(int i = 0; i < row; i++){
            if(obstacleGrid[i][0] == 1){
                break;
            }
            map[i][0] = 1;
        }
        if(map[0][0] != 0){
            for(int i = 1; i < col; i++){
                if(obstacleGrid[0][i] == 1){
                    break;
                }
                map[0][i] = 1;
            }
        }
        //dp
        for(int i = 1; i < row; i++){
            for(int j = 1; j < col; j++){
                if(obstacleGrid[i][j] == 1){
                    map[i][j] = 0;
                }else{
                    map[i][j] = map[i][j-1] + map[i-1][j];
                }
            }
        }
        return map[row-1][col-1];
    }
}
