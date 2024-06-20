import java.util.*;
import java.io.*;

public class Main {

    static int rNum;
    static int cNum;
    static int[][] maze;
    static boolean[][] isVisit;

    static int[] initLeftTop;
    static int[] goal;

    static int[] dx = {0, 1, 0, -1}; // 북 동 남 서
    static int[] dy = {-1, 0, 1, 0};

    static int h;
    static int w;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        rNum = Integer.parseInt(st.nextToken());
        cNum = Integer.parseInt(st.nextToken());
        maze = new int[rNum][cNum];
        isVisit = new boolean[rNum][cNum];

        for (int i = 0; i < rNum; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < cNum; j++) {
                maze[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        st = new StringTokenizer(br.readLine());
        h = Integer.parseInt(st.nextToken());
        w = Integer.parseInt(st.nextToken());
        initLeftTop = new int[] {Integer.parseInt(st.nextToken()) - 1, Integer.parseInt(st.nextToken()) - 1};
        goal = new int[] {Integer.parseInt(st.nextToken()) - 1, Integer.parseInt(st.nextToken()) - 1};

        int result = bfs();
        System.out.print(result);
    }

    public static int bfs() {
        Queue<int[]> queue = new LinkedList<>();
        queue.add(new int[]{initLeftTop[0], initLeftTop[1], 0}); // {y, x, count}
        isVisit[initLeftTop[0]][initLeftTop[1]] = true;

        while (!queue.isEmpty()) {
            int[] current = queue.poll();
            int cy = current[0];
            int cx = current[1];
            int count = current[2];

            if (cy == goal[0] && cx == goal[1]) {
                return count;
            }

            for (int i = 0; i < 4; i++) { // 북 동 남 서
                int ny = cy + dy[i];
                int nx = cx + dx[i];

                if (canMove(ny, nx, i)) {
                    isVisit[ny][nx] = true;
                    queue.add(new int[]{ny, nx, count + 1});
                }
            }
        }

        return -1; // 이동할 수 없는 경우
    }

    public static boolean canMove(int y, int x, int idx) {
        if (y < 0 || y + h > rNum || x < 0 || x + w > cNum) {
            return false;
        }
        if (isVisit[y][x]) {
            return false;
        }


        if (idx == 0) { // 북
            for (int i = x ; i < x + w ; i++) {
                if (maze[y][i] == 1) return false;
            }
        } 
        else if (idx == 1) { // 서
            for (int i = y ; i < y + h ; i++) {
                if (maze[i][x + w - 1] == 1) return false;
            }
        } 
        else if (idx == 2) { // 남
            for (int i = x ; i < x + w ; i++) {
                if (maze[y + h - 1][i] == 1) return false;
            }    
        } 
        else if (idx == 3) {   // 동 
            for (int i = y ; i < y + h ; i++) {
                if (maze[i][x] == 1) return false;
            }
        }

        return true;
    }
}