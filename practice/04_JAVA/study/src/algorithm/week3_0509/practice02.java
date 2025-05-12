package algorithm.week3_0509;

import java.util.LinkedList;
import java.util.Queue;

public class practice02 {

    static int sx;
    static int sy;
    static int ex;
    static int ey;
    static boolean isL;

    static int[] dx = {-1, 1, 0, 0};
    static int[] dy = {0, 0, -1, 1};

    public static int bfs(char[][] map, int x, int y) {
        Queue<int[]> queue = new LinkedList<>();
        queue.offer(new int[]{x, y, 1});
        while (!queue.isEmpty()) {
            int[] p = queue.poll();
            if (p[0] == ex && p[1] == ey && isL) return p[2];
            for (int i = 0; i < 4; i++) {
                int nx = p[0] + dx[i];
                int ny = p[1] + dy[i];
                int dist = p[2];
                if (nx == ex && ny == ey && isL) return dist;
                if (nx >= map.length || nx < 0 || ny >= map[0].length || ny < 0 || map[nx][ny] == 'X') continue;
                if (map[nx][ny] == 'L') isL = true;
                queue.offer(new int[] {nx, ny, dist + 1});
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        String[] maps = {"SOOOL","XXXXO","OOOOO","OXXXX","OOOOE"};
//        String[] maps = {"LOOXS","OOOOX","OOOOO","OOOOO","EOOOO"};
        char[][] charMaps = new char[maps.length][maps[0].length()];

        for (int i = 0; i < maps.length; i++) {
            for (int j = 0; j < maps[i].length(); j++) {
                System.out.println(maps[i].length());
                charMaps[i][j] = maps[i].charAt(j);
                if (charMaps[i][j] == 'S') {
                    sx = i;
                    sy = j;
                }
                else if (charMaps[i][j] == 'E') {
                    ex = i;
                    ey = j;
                }
            }
        }
        System.out.println(bfs(charMaps, sx, sy));
    }
}
