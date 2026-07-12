class Solution {
    public List<Integer> spiralOrder(int[][] matrix) {
        List<Integer> ans = new ArrayList<>();
        int StartRow = 0;
        int StartCol = 0;
        int EndRow = matrix.length - 1;
        int EndCol = matrix[0].length - 1;
        while(StartRow <= EndRow && StartCol <= EndCol){
            // top
            for(int j = StartCol; j <= EndCol ; j++ ){
                ans.add(matrix[StartRow][j]);
            }
            // right
            for(int i = StartRow + 1 ; i <= EndRow; i++ ){
                ans.add(matrix[i][EndCol]);
            }
            // bottom
            for(int j = EndCol - 1 ; j >= StartCol ; j--){
                if(StartRow == EndRow ){
                    break;
                }
                ans.add(matrix[EndRow][j]);
            }
            // left
            for(int i = EndRow - 1 ; i >= StartRow+1 ; i--){
                if(StartCol == EndCol){
                    break;
                }
                ans.add(matrix[i][StartCol]);
            }
            StartCol++;
            StartRow++;
            EndCol--;
            EndRow--;
        } 
        return ans;
    }
}