public int subarraysWithKDistinct(int[] A, int K) {
  int res = 0, prefix = 0;
  int[] m = new int[A.length + 1];
  for (int i = 0, j = 0, cnt = 0; i < A.length; ++i) {
    if (m[A[i]]++ == 0) ++cnt;
    if (cnt > K) {
      --m[A[j++]]; --cnt; prefix = 0; 
    }
    while (m[A[j]] > 1) {
      ++prefix; --m[A[j++]]; 
    }
    if (cnt == K) res += prefix + 1;
  }
  return res;
} 

https://leetcode.com/problems/subarrays-with-k-different-integers/discuss/235235/C%2B%2BJava-with-picture-prefixed-sliding-window
