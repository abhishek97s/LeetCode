class Solution:
  def goodDaysToRobBank(self, security: List[int], time: int) -> List[int]:
    n = len(security)

    dec = [0] * n  # dec[i] := continuous decreasings before i
    inc = [0] * n  # inc[i] := continuous increasings after i

    for i in range(1, n):
      if security[i - 1] >= security[i]:
        dec[i] = dec[i - 1] + 1

    for i in range(n - 2, -1, -1):
      if security[i] <= security[i + 1]:
        inc[i] = inc[i + 1] + 1

    return [i for i, (a, b) in enumerate(zip(dec, inc))
            if a >= time and b >= time]
