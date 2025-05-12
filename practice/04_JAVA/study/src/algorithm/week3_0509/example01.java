package algorithm.week3_0509;

import java.awt.*;
import java.util.LinkedList;
import java.util.Queue;

public class example01 {
    static boolean[][] isVisited;
    static int[] dx = {-1, 1, 0, 0};
    static int[] dy = {0, 0, -1, 1};
    static int cnt;

    public static void bfs(int[][] grid, int x, int y) {
        Queue<Point> queue = new LinkedList<>();
        isVisited[x][y] = true;
        queue.offer(new Point(x, y));
        while (!queue.isEmpty()) {
            Point p = queue.poll();
            for (int i = 0; i < 4; i++) {
                int nx = p.x + dx[i];
                int ny = p.y + dy[i];
                if (nx >= grid.length || nx < 0 || ny >= grid[i].length || ny < 0) continue;
                if (!isVisited[nx][ny] && grid[nx][ny] == 1) {
                    isVisited[nx][ny] = true;
                    queue.offer(new Point(nx, ny));
                }
            }
        }
    }

    public static void main(String[] args) {
//        char[][] grid = {
//                {'1', '1', '0', '0', '0'},
//                {'1', '1', '0', '0', '0'},
//                {'0', '0', '1', '0', '0'},
//                {'0', '0', '0', '1', '1'}};
//        char[][] grid = {{'1','1','1','1','0'}, {'1','1','0','1','0'},{'1','1','0','0','0'},{'0','0','0','0','0'}};
        char[][] grid = {{'1'}};
        isVisited = new boolean[301][301];
        int[][] intGrid = new int[301][301];
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[i].length; j++) {
                intGrid[i][j] = grid[i][j] - '0';
            }
        }
        for (int i = 0; i < intGrid.length; i++) {
            for (int j = 0; j < intGrid[i].length; j++) {
                if (!isVisited[i][j] && intGrid[i][j] == 1) {
                    bfs(intGrid, i, j);
                    cnt++;
                }
            }
        }
        System.out.println(cnt);
    }

}
