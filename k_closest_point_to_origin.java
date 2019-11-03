class Solution {
    public int[][] kClosest(int[][] points, int K) {
        Arrays.sort(points, (point1,point2) -> (point1[0]*point1[0] + point1[1]*point1[1]) - (point2[0]*point2[0] + point2[1]*point2[1])); 
        int[][] ans = new int[K][2];
        while(K>0){
            ans[--K]=points[K];
        
        }
        
        return ans;
    }
}
