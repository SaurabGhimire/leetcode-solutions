package neetcode150.mathAndGeometry;

public class SpiralMatrix {
    public List<Integer> spiralOrder(int[][] matrix) {
        int left = 0, top = 0;
        int right = matrix[0].length, bottom = matrix.length;
        List<Integer> list = new ArrayList<>();
        while(left<right && top<bottom){
            for(int j=left;j<right;j++){
                list.add(matrix[top][j]);
            }
            top++;
            for(int i=top;i<bottom;i++){
                list.add(matrix[i][right-1]);
            }
            right--;
            if(left>=right || top>=bottom) break;
            for(int j=right-1;j>=left;j--){
                list.add(matrix[bottom-1][j]);
            }
            bottom--;
            for(int i=bottom-1;i>=top;i--){
                list.add(matrix[i][left]);
            }
            left++;
        }
        return list;
    }
}