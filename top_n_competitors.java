// "static void main" must be defined in a public class.

public class Main {
    public static void main(String[] args) {
        int numCompetitors = 6;
        int topNCompetitors = 2;
        String[] competitors = {"newshop", "shopnow", "afshion", "fashionbeats", "mymarket", "tcellular"};
        int numReviews = 6;
        String[] reviews = {"newshop is afshion providing good services in the city; everyone should use newshop", "best services by newshop", "fashionbeats has great services in the city", "i am proud to have fashionbeats", "mymarket has awesome services", "Thanks Newshop for the quick delivery"};

        
        List<String> result = getTopCompetitors(numCompetitors, topNCompetitors, competitors, numReviews,reviews);
        
        System.out.println(result);
    }
    
   public static List<String> getTopCompetitors(int numCompetitors,int topNCompetitors, String[] competitors,int numReviews, String[] reviews) {
       
       Map<String,Integer> count = new HashMap<String,Integer>();
       Set<String> competition = new HashSet<String>();
       for(String comp : competitors){
           competition.add(comp);
       }
       
       for(String review: reviews){
           String[] str = review.split(" ");
           Set<String> Usedset = new HashSet<String>();
           for(String word: str){
               if(competition.contains(word.toLowerCase()) && Usedset.add(word.toLowerCase())){
                   count.put(word.toLowerCase(),count.getOrDefault(word.toLowerCase(),0)+1);
               }
           }       
       }   
       PriorityQueue<String> pq = new PriorityQueue<String>((a,b) -> count.get(a)-count.get(b));
       for(String comp: count.keySet()){
           System.out.println(comp+" = "+count.get(comp));
           pq.add(comp);
           if(pq.size()>topNCompetitors){
               pq.poll();
           }
       }
       List<String> result = new ArrayList();
       while(pq.size()>0){
           result.add(0,pq.poll());
       }
       return result;
   } 
}
