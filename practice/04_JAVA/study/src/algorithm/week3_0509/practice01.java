package algorithm.week3_0509;

import java.util.LinkedList;
import java.util.Queue;

public class practice01 {

    static boolean[][] isVisited;
    static int[] dx = {-1, 1, 0, 0, -1, -1, 1, 1};
    static int[] dy = {0, 0, -1, 1, -1, 1, -1, 1};

    static int bfs(int[][] grid, int x, int y) {
        Queue<int[]> queue = new LinkedList<>();
        isVisited[x][y] = true;
        queue.offer(new int[] {x, y, 1});
        while (!queue.isEmpty()) {
            int[] p = queue.poll();
            if (p[0] == grid.length - 1 && p[1] == grid.length - 1) return p[2];
            for (int i = 0; i < 8; i++) {
                int cx = p[0] + dx[i];
                int cy = p[1] + dy[i];
                int dist = p[2];
                if (cx == grid.length - 1 && cy == grid.length - 1) return dist + 1;
                if (cx >= grid.length || cx < 0 || cy >= grid.length || cy < 0) continue;
                if (!isVisited[cx][cy] && grid[cx][cy] == 0) {
                    isVisited[cx][cy] = true;
                    queue.offer(new int[]{cx, cy, dist + 1});
                }
            }
        }
        return -1;
    }

    public static void main(String[] args) {
//        int[][] grid = {{0, 0, 0}, {1, 1, 0}, {1, 1, 1}};
        int[][] grid = {{0}};
        isVisited = new boolean[101][101];
        if (grid[0][0] == 1 || grid[grid.length - 1][grid.length - 1] == 1) {
            System.out.println(-1);
            return;
        }
        System.out.println(bfs(grid, 0, 0));
    }
}

/*

0 0 0
1 1 0
1 1 1
 */