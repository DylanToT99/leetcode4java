package offer2;

/**
 * @author Dylan
 * @version 1.0
 * @date 2023/4/15 17:54
 * @description TODO
 **/
public class NumMatrix {

    int [][]matrix;
    public NumMatrix(int[][] matrix) {
        this.matrix=matrix;
    }

    public int sumRegion(int row1, int col1, int row2, int col2) {
        int sum=0;
        for (int i = row1; i <=row2 ; i++) {
            for (int j = col1; j <=col2 ; j++) {
                sum+=matrix[i][j];
            }
        }
        return sum;
    }
}
