class Solution:
  def permuteUnique(self, nums: List[int]) -> List[List[int]]:
    ans = []
    used = [False] * len(nums)

    def dfs(path: List[int]) -> None:
      if len(path) == len(nums):
        ans.append(path)
        return

      for i, num in enumerate(nums):
        if used[i]:
          continue
        if i > 0 and nums[i] == nums[i - 1] and not used[i - 1]:
          continue
        used[i] = True
        dfs(path + [num])
        used[i] = False

    nums.sort()
    dfs([])

    return ans
