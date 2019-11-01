class Solution {
    private int time = 0; // current time of discovery

    public List<List<Integer>> criticalConnections(int n, List<List<Integer>> connections) {
        List<Integer>[] graph = new ArrayList[n];
        for (int i = 0; i < n; i++) {
            graph[i] = new ArrayList<>();
        }

        for (List<Integer> conn : connections) {
            int n1 = conn.get(0);
            int n2 = conn.get(1);
            graph[n1].add(n2);
            graph[n2].add(n1);
        }

        int[] disc = new int[n]; // discovery time of each node
        int[] low = new int[n]; // earliest discovered node reachable from this node in DFS
        boolean[] visited = new boolean[n]; // whether this node has been visited in DFS
        List<List<Integer>> out = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            if (!visited[i]) {
                dfs(i, -1, disc, low, visited, graph, out);
            }
        }

        return out;
    }

    // root = current node under consideration
    // parent = parent of current node
    private void dfs(int root, int parent, int[] disc, int[] low, boolean[] visited, List<Integer>[] graph, List<List<Integer>> out) {
        visited[root] = true;
        disc[root] = time++;
        low[root] = disc[root]; // we don't have to initialize low[] to inf because of this line

        for (Integer nei : graph[root]) {
            if (nei == parent) {
                continue;
            }

            if (!visited[nei]) {
                dfs(nei, root, disc, low, visited, graph, out);
                low[root] = Math.min(low[root], low[nei]);
                if (disc[root] < low[nei]) {
                    out.add(Arrays.asList(root, nei));
                }
            } else {
                low[root] = Math.min(low[root], disc[nei]);
            }
        }
    }
}

https://leetcode.com/discuss/interview-question/417213/
