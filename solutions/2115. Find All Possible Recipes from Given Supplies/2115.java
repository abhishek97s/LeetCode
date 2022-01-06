class Solution {
  public List<String> findAllRecipes(String[] recipes, List<List<String>> ingredients,
                                     String[] supplies) {
    List<String> ans = new ArrayList<>();
    Set<String> suppliesSet = new HashSet<>();
    for (final String supply : supplies)
      suppliesSet.add(supply);
    Map<String, List<String>> graph = new HashMap<>();
    Map<String, Integer> inDegrees = new HashMap<>();
    Queue<String> q = new LinkedList<>();

    // build graph
    for (int i = 0; i < recipes.length; ++i)
      for (final String ingredient : ingredients.get(i))
        if (!suppliesSet.contains(ingredient)) {
          graph.putIfAbsent(ingredient, new ArrayList<>());
          graph.get(ingredient).add(recipes[i]);
          inDegrees.merge(recipes[i], 1, Integer::sum);
        }

    // topology
    for (final String recipe : recipes)
      if (inDegrees.getOrDefault(recipe, 0) == 0)
        q.offer(recipe);

    while (!q.isEmpty()) {
      final String u = q.poll();
      ans.add(u);
      if (!graph.containsKey(u))
        continue;
      for (final String v : graph.get(u)) {
        inDegrees.merge(v, -1, Integer::sum);
        if (inDegrees.get(v) == 0)
          q.offer(v);
      }
    }

    return ans;
  }
}
