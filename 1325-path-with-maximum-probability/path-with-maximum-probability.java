class Solution {

    class Pair implements Comparable<Pair> {
        int node;
        double prob;

        Pair(int node, double prob){
            this.node = node;
            this.prob = prob;
        }

        // Max-heap comparator (higher prob = higher priority)
        public int compareTo(Pair p){
            return Double.compare(this.prob, p.prob);
        }
    }

    public double maxProbability(int n, int[][] edges, double[] succProb, int start, int end) {

        // adjacency list
        List<List<Pair>> adj = new ArrayList<>();
        for(int i = 0; i < n; i++){
            adj.add(new ArrayList<>());
        }

        // build graph
        for(int i = 0; i < edges.length; i++){
            int u = edges[i][0], v = edges[i][1];
            double prob = succProb[i];
            adj.get(u).add(new Pair(v, prob));
            adj.get(v).add(new Pair(u, prob));
        }

        // max probability array
        double[] best = new double[n];
        best[start] = 1.0;

        // max-heap priority queue
        PriorityQueue<Pair> pq = new PriorityQueue<>(Collections.reverseOrder());
        pq.add(new Pair(start, 1.0));

        while(!pq.isEmpty()){

            Pair top = pq.poll();
            int node = top.node;
            double prob = top.prob;

            if(prob < best[node]) continue;

            for(Pair p : adj.get(node)){
                double newProb = prob * p.prob;
                if(newProb > best[p.node]){
                    best[p.node] = newProb;
                    pq.add(new Pair(p.node, newProb));
                }
            }
        }

        return best[end];
    }
}