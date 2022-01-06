class T {
  public int u;
  public int dist;
  public int stops;
  public T(int u, int dist, int stops) {
    this.u = u;
    this.dist = dist;
    this.stops = stops;
  }
}

class Solution {
  public int findCheapestPrice(int n, int[][] flights, int src, int dst, int k) {
    List<int[]>[] graph = new List[n];
    // {v, w}: min-heap sorted by w
    PriorityQueue<T> pq = new PriorityQueue<>((a, b) -> a.dist - b.dist);
    pq.offer(new T(src, 0, k + 1)); // start with node src with dist == 0

    for (int i = 0; i < graph.length; ++i)
      graph[i] = new ArrayList<>();

    for (int[] f : flights)
      graph[f[0]].add(new int[] {f[1], f[2]});

    while (!pq.isEmpty()) {
      final int u = pq.peek().u;
      final int dist = pq.peek().dist;
      final int stops = pq.poll().stops;
      if (u == dst)
        return dist;
      if (stops > 0)
        for (int[] nodes : graph[u]) {
          final int v = nodes[0];
          final int w = nodes[1];
          pq.offer(new T(v, dist + w, stops - 1));
        }
    }

    return -1;
  }
}
