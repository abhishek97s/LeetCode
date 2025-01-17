class Solution:
  def findAllRecipes(self, recipes: List[str], ingredients: List[List[str]], supplies: List[str]) -> List[str]:
    ans = []
    supplies = set(supplies)
    graph = defaultdict(list)
    inDegrees = Counter()
    q = deque()

    # build graph
    for i, recipe in enumerate(recipes):
      for ingredient in ingredients[i]:
        if ingredient not in supplies:
          graph[ingredient].append(recipe)
          inDegrees[recipe] += 1

    # topology
    for recipe in recipes:
      if inDegrees[recipe] == 0:
        q.append(recipe)

    while q:
      u = q.popleft()
      ans.append(u)
      for v in graph[u]:
        inDegrees[v] -= 1
        if inDegrees[v] == 0:
          q.append(v)

    return ans
