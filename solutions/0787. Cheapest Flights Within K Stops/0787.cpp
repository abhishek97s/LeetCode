struct T {
  int u;
  int dist;
  int stops;
  T(int u, int dist, int stops) : u(u), dist(dist), stops(stops) {}
};

class Solution {
 public:
  int findCheapestPrice(int n, vector<vector<int>>& flights, int src, int dst,
                        int k) {
    vector<vector<pair<int, int>>> graph(n);
    auto compare = [](const T& a, const T& b) { return a.dist > b.dist; };
    // (u, w, stops): min-heap sorted by w
    priority_queue<T, vector<T>, decltype(compare)> pq(compare);
    pq.emplace(src, 0, k + 1);  // start with node src with dist == 0

    for (const auto& f : flights)
      graph[f[0]].emplace_back(f[1], f[2]);

    while (!pq.empty()) {
      const auto [u, dist, stops] = pq.top();
      pq.pop();
      if (u == dst)
        return dist;
      if (stops > 0)
        for (const auto& [v, w] : graph[u])
          pq.emplace(v, dist + w, stops - 1);
    }

    return -1;
  }
};
