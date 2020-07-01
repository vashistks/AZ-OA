class Solution {
    public List<Integer> partitionLabels(String S) {
        if(S==null || S.length() == 0) return null;
        List<Integer> partition = new ArrayList<Integer>();
        int[] last = new int[26];

        for(int i=0;i<S.length();i++){
            last[S.charAt(i)-'a'] = i;
        }
        int start = 0;
        int end = 0;
        for(int i=0;i<S.length();i++){
            int lastPosition = last[S.charAt(i)-'a'];
            end = Math.max(end,lastPosition);

            if(i==end){
                partition.add(end-start+1);
                start = i+1;
            }

        }
        return partition;
    }
}

O(N) and space O(1)
