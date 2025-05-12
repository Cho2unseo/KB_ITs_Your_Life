package algorithm.week3_0509;

import java.util.LinkedList;
import java.util.Queue;

public class example02 {
    static boolean[][] isVisited;
    static int[][] distance;
    static int[] dx = {-1, 1, 0, 0, -1, -1, 1, 1};
    static int[] dy = {0, 0, -1, 1, -1, 1, -1, 1};

    static int bfs(int[][] city, int x, int y) {
        Queue<int[]> queue = new LinkedList<>();
        isVisited[x][y] = true;
        queue.offer(new int[] {x, y, 0});
        while (!queue.isEmpty()) {
            int[] p = queue.poll();
            int cx = p[0];
            int cy = p[1];
            if (cx == city.length - 1 && cy == city[0].length - 1) {
                return p[2];
            }
            for (int i = 0; i < 8; i++) {
                int nx = cx + dx[i];
                int ny = cy + dy[i];
                if (nx >= city.length || nx < 0 || ny >= city[0].length || ny < 0) continue;
//                if (!isVisited[nx][ny] && )
            }
        }
        return -1;
    }

    public int solution(int[][] city) {
        isVisited = new boolean[301][301];
        distance = new int[301][301];
        int answer = -1;
        return answer;
    }
}
