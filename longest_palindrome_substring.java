class Solution {
    public String longestPalindrome(String s) {
      if(s==null || s.equals("")) return "";
      
        int start = 0;
        int end = 0;
        
        for(int i=0;i<s.length();i++){
            int mid1 = expand(s,i,i);
            int mid2 = expand(s,i,i+1);
            int maxMid = Math.max(mid1,mid2);
            //int currentMax = end-start;
            if(maxMid> end-start){
                start = i - (maxMid-1)/2;
                end = i + maxMid/2;
            }
        }
        
        return s.substring(start,end+1);
    }
    
    public int expand(String s, int left,int right){
        while(left>=0 && right<=s.length()-1 && s.charAt(left)==s.charAt(right)){
            left--;
            right++;
        }
        return right-left-1; // This is so that once the right and left are same , a left-- and right ++ is done. So it needs to reduce by 
        //by one when it fails in the while loop
    }
}

