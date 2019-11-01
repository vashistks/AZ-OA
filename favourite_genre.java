class Solution {
   public Map<String, List<String>> favoritegenre(Map<String, List<String>> userMap, Map<String, List<String>> genreMap) {
   	Map<String, List<String>> res = new HashMap<>();
   	Map<String, String> songstogenre = new HashMap<>();
   	
   	for(String genre : genreMap.keySet()) {
   		List<String> songs = genreMap.get(genre);
   		for(String song : songs) {
   			songstogenre.put(song, genre);
   		}
   	}
       Map<String, Integer> count = new HashMap();
   	int max = 0;
   	for(String user : userMap.keySet()) {
           count = new HashMap();
           max = 0;
           res.put(user, new ArrayList());
   		List<String> songs = userMap.get(user);
   		for(String song : songs) {
   			String genre = songstogenre.get(song);
   			int c = count.getOrDefault(genre, 0) + 1;
   			count.put(genre, c);
               max = Math.max(c, max);
   		}
           for (String key : count.keySet()) {
               if (count.get(key) == max) {
                   res.get(user).add(key);
               }
           }
   	}
   	return res;
   }
}
