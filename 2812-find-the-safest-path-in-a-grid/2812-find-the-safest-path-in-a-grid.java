import java.util.*;

class Solution {

    public int maximumSafenessFactor(List<List<Integer>> grid) {

        int n = grid.size();
        int[][] dist = new int[n][n];

        for (int[] row : dist) {
            Arrays.fill(row, -1);
        }

        Queue<int[]> queue = new LinkedList<>();

        // Step 1: Multi-Source BFS (start from all thieves)
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (grid.get(i).get(j) == 1) {
                    dist[i][j] = 0;
                    queue.offer(new int[]{i, j});
                }
            }
        }

        int[] dr = {-1, 1, 0, 0};
        int[] dc = {0, 0, -1, 1};

        while (!queue.isEmpty()) {

            int[] cur = queue.poll();

            for (int k = 0; k < 4; k++) {

                int nr = cur[0] + dr[k];
                int nc = cur[1] + dc[k];

                if (nr >= 0 && nr < n &&
                    nc >= 0 && nc < n &&
                    dist[nr][nc] == -1) {

                    dist[nr][nc] = dist[cur[0]][cur[1]] + 1;
                    queue.offer(new int[]{nr, nc});
                }
            }
        }

        // Step 2: Binary Search
        int low = 0;
        int high = 0;

        for (int[] row : dist) {
            for (int val : row) {
                high = Math.max(high, val);
            }
        }

        int ans = 0;

        while (low <= high) {

            int mid = low + (high - low) / 2;

            if (canReach(dist, mid)) {
                ans = mid;
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }

        return ans;
    }

    private boolean canReach(int[][] dist, int safe) {

        int n = dist.length;

        if (dist[0][0] < safe || dist[n - 1][n - 1] < safe)
            return false;

        Queue<int[]> queue = new LinkedList<>();
        boolean[][] visited = new boolean[n][n];

        queue.offer(new int[]{0, 0});
        visited[0][0] = true;

        int[] dr = {-1, 1, 0, 0};
        int[] dc = {0, 0, -1, 1};

        while (!queue.isEmpty()) {

            int[] cur = queue.poll();

            int r = cur[0];
            int c = cur[1];

            if (r == n - 1 && c == n - 1)
                return true;

            for (int k = 0; k < 4; k++) {

                int nr = r + dr[k];
                int nc = c + dc[k];

                if (nr >= 0 && nr < n &&
                    nc >= 0 && nc < n &&
                    !visited[nr][nc] &&
                    dist[nr][nc] >= safe) {

                    visited[nr][nc] = true;
                    queue.offer(new int[]{nr, nc});
                }
            }
        }

        return false;
    }
}