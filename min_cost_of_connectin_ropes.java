public static int minCost(List<Integer> ropes) {
    Queue<Integer> pq = new PriorityQueue<>(ropes);
    int totalCost = 0;
    while (pq.size() > 1) {
        int cost = pq.poll() + pq.poll();
        pq.add(cost);
        totalCost += cost;
    }
    return totalCost;
}   
