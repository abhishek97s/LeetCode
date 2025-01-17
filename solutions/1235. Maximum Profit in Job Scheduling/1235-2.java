class Job {
  public int startTime;
  public int endTime;
  public int profit;
  public Job(int startTime, int endTime, int profit) {
    this.startTime = startTime;
    this.endTime = endTime;
    this.profit = profit;
  }
}

class Solution {
  public int jobScheduling(int[] startTime, int[] endTime, int[] profit) {
    final int n = startTime.length;

    // dp[i] := max profit to schedule jobs[i:]
    int[] dp = new int[n + 1];
    Job[] jobs = new Job[n];

    for (int i = 0; i < n; ++i)
      jobs[i] = new Job(startTime[i], endTime[i], profit[i]);

    Arrays.sort(jobs, (a, b) -> a.startTime - b.startTime);

    // will use binary search to find the first available startTime
    for (int i = 0; i < n; ++i)
      startTime[i] = jobs[i].startTime;

    for (int i = n - 1; i >= 0; --i) {
      final int j = firstGreaterEqual(startTime, i + 1, jobs[i].endTime);
      final int choose = jobs[i].profit + dp[j];
      final int skip = dp[i + 1];
      dp[i] = Math.max(choose, skip);
    }

    return dp[0];
  }

  private int firstGreaterEqual(int[] A, int startFrom, int target) {
    int l = startFrom;
    int r = A.length;
    while (l < r) {
      final int m = l + (r - l) / 2;
      if (A[m] >= target)
        r = m;
      else
        l = m + 1;
    }
    return l;
  }
}
