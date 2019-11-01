class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        if(matrix==null) return false;
        if(matrix.length==0 || matrix[0].length==0) return false;
        
        int row = 0;
        int col = matrix[0].length - 1;
        
        while(col>=0 && row<matrix.length){
            int currentValue = matrix[row][col];
            if(target==currentValue)
                return true;
            else if(target>currentValue)
                row++;
            else
                col--;
                
        }
        return false;
        
    }
}
