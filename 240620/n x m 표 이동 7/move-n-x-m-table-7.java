import java.util.*;
import java.io.*;
public class Main {

    static int rNum;
    static int cNum;
    static int[][] maze;
    static boolean[][] isVisit;

    static int[] initLeftTop;
    static int[] goal;

    static int[] dx = {0, 1, 0 , -1}; // 북 동 남 서
    static int[] dy = {-1, 0, 1, 0};

    static int count = 0;
    static int h;
    static int w;

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
                int input = Integer.parseInt(st.nextToken());
                maze[i][j] = input;
                if (input == 1) {
                    isVisit[i][j] = true;
                }
            }
        }
        
        st = new StringTokenizer(br.readLine());
        h = Integer.parseInt(st.nextToken());
        w = Integer.parseInt(st.nextToken());
        initLeftTop = new int[] {Integer.parseInt(st.nextToken()) - 1, Integer.parseInt(st.nextToken()) - 1};
        goal = new int[] {Integer.parseInt(st.nextToken()) - 1, Integer.parseInt(st.nextToken()) - 1};

        bfs();
        System.out.print(count);
    }

    public static void bfs() {
        // 기준은 initLeftTop
        Queue<int[]> queue = new LinkedList<>();
        queue.add(initLeftTop);
        isVisit[initLeftTop[0]][initLeftTop[1]] = true;

        int y = 0;
        int x = 0;

        while (!queue.isEmpty() || (y == goal[0] && x == goal[1])) {
            int[] current = queue.poll();
            int rightBotY = current[0] + h - 1;
            int rightBotX = current[1] + w - 1;

            for (int i = 0 ; i < 4 ; i++) { // 북 동 남 서
                y = current[0] + dy[i];
                x = current[1] + dx[i];

                boolean isWall = false;
                if (canGo(y, x)) {
                    if (i == 0 || i == 2) {
                        for (int j = x ; j <= x + w - 1 ; j++) {
                            if (maze[y][j] == 1) {
                                isWall = true;
                                break;
                            }
                        }
                    }
                    else if (i == 1 || i == 3) {
                        for (int j = y ; j <= y + h - 1 ; j++) {
                            if (maze[i][x] == 1) {
                                isWall = true;
                                break;
                            }
                        }
                    }

                    if (!isWall) {
                        queue.add(new int[] {y, x});
                        isVisit[y][x] = true;
                        count++;
                    }
                }

            }
        }
    }

    public static boolean canGo(int yIdx, int xIdx) {
        return yIdx >= 0 && yIdx < rNum && xIdx >= 0 && xIdx < cNum && !isVisit[yIdx][xIdx];
    }
}