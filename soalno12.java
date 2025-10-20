import java.util.*;

public class soalno12 {
    public static void main(String[] args) {
        int[][] grid = {
            {5, 3, 2, 1},
            {1, 2, 10, 2},
            {4, 3, 1, 3},
            {2, 1, 2, 20}
        };
        Result res = findMaxEnergyPath(grid);
        System.out.println("Jalur terbaik: " + formatPath(res.path));
        System.out.println("Total Energi Maksimum: " + res.totalEnergy);
    }

    static class Result {
        List<int[]> path; int totalEnergy;
        Result(List<int[]> p, int t) { path = p; totalEnergy = t; }
    }

    public static Result findMaxEnergyPath(int[][] g) {
        if (g == null || g.length == 0) return new Result(new ArrayList<>(), 0);
        int n = g.length, m = g[0].length;
        int[][] dp = new int[n][m];
        char[][] from = new char[n][m]; // 'S','U','L'

        dp[0][0] = g[0][0]; from[0][0] = 'S';
        for (int j = 1; j < m; j++) { dp[0][j] = dp[0][j-1] + g[0][j]; from[0][j] = 'L'; }
        for (int i = 1; i < n; i++) { dp[i][0] = dp[i-1][0] + g[i][0]; from[i][0] = 'U'; }

        for (int i = 1; i < n; i++) for (int j = 1; j < m; j++) {
            if (dp[i-1][j] >= dp[i][j-1]) { dp[i][j] = dp[i-1][j] + g[i][j]; from[i][j] = 'U'; }
            else { dp[i][j] = dp[i][j-1] + g[i][j]; from[i][j] = 'L'; }
        }

        List<int[]> rev = new ArrayList<>();
        int i = n-1, j = m-1;
        while (!(i==0 && j==0)) {
            rev.add(new int[]{i,j});
            if (from[i][j] == 'U') i--; else j--;
        }
        rev.add(new int[]{0,0});
        Collections.reverse(rev);
        return new Result(rev, dp[n-1][m-1]);
    }

    private static String formatPath(List<int[]> path) {
        StringBuilder sb = new StringBuilder();
        for (int k = 0; k < path.size(); k++) {
            int[] p = path.get(k);
            sb.append("(").append(p[0]).append(",").append(p[1]).append(")");
            if (k < path.size()-1) sb.append(" -> ");
        }
        return sb.toString();
    }
}
