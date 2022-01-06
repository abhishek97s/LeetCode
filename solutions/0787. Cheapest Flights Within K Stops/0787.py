class Solution:
  def findCheapestPrice(self, n: int, flights: List[List[int]], src: int, dst: int, k: int) -> int:
    # (w, v, stops): min-heap sorted by w
    pq = []
    graph = [[] for _ in range(n)]

    for u, v, price in flights:
      graph[u].append((v, price))

    heapq.heappush(pq, (0, src, k + 1))

    while pq:
      dist, u, stops = heapq.heappop(pq)
      if u == dst:
        return dist
      if stops > 0:
        for v, w in graph[u]:
          heapq.heappush(pq, (dist + w, v, stops - 1))

    return -1
