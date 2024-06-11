import java.util.*;
import java.io.*;

public class Main {

    static int[][] maze;
    static boolean[][] isVisit;
    static Queue<int[]> queue = new LinkedList<>();
    static int[] dx = {0, 1, 0, -1}; // 동 남 서 북
    static int[] dy = {1, 0, -1, 0};

    static int rNum;
    static int cNum;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        rNum = Integer.parseInt(st.nextToken());
        cNum = Integer.parseInt(st.nextToken());
        maze = new int[rNum][cNum];
        isVisit = new boolean[rNum][cNum];
        
        for (int i = 0 ; i < rNum ; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0 ; j < cNum ; j++) {
                maze[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        System.out.println(bfs(0, 0));
    }

    public static int bfs(int y, int x) {
        queue.add(new int[]{y, x});
        isVisit[y][x] = true;
        int[][] distance = new int[rNum][cNum];
        distance[y][x] = 1; // 시작점을 1로 초기화

        while (!queue.isEmpty()) {
            int[] current = queue.poll();
            int presentY = current[0];
            int presentX = current[1];

            // 도착지점에 도달하면 그 지점까지의 거리 반환
            if (presentX == cNum - 1 && presentY == rNum - 1) {
                return distance[presentY][presentX];
            }

            for (int i = 0 ; i < 4 ; i++) {
                int yIdx = presentY + dy[i];
                int xIdx = presentX + dx[i];
                if (isValid(yIdx, xIdx) && maze[yIdx][xIdx] == 1 && !isVisit[yIdx][xIdx]) {
                    queue.add(new int[]{yIdx, xIdx});
                    isVisit[yIdx][xIdx] = true;
                    distance[yIdx][xIdx] = distance[presentY][presentX] + 1;
                }
            }
        }
        return 0;
    }

    public static boolean isValid(int y, int x) {
        return y >= 0 && y < rNum && x >= 0 && x < cNum;
    }
}