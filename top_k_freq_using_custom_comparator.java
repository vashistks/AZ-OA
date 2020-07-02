  class Solution {
    public List<String> topKFrequent(String[] words, int k) {
        List<String> res = new ArrayList<>();
        if (words == null || words.length == 0) {
            return res;
        }
        Map<String, Integer> map = new HashMap<>();
        for (String w : words) {
            map.put(w, map.getOrDefault(w, 0) + 1);
        }
        PriorityQueue<String> pq = new PriorityQueue<String>(new Comparator<String>() {
            @Override
            public int compare(String s1, String s2) {
                if (map.get(s1) == map.get(s2)) {
                    return s1.compareTo(s2);
                }
                return map.get(s2) - map.get(s1);
            }
        });
        pq.addAll(map.keySet());
        for (int i = 0; i < k; i++) {
            if (!pq.isEmpty()) {
                res.add(pq.poll());
            }
        }
        return res;
    }
}
