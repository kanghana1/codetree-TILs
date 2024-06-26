import java.util.*;
import java.io.*;

public class Main {

    static int goal;
    static Queue<int[]> queue = new LinkedList<>();
    static boolean[][] isVisited;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        goal = Integer.parseInt(br.readLine());
        System.out.println(bfs());
    }

    public static int bfs() {
        queue.add(new int[] {1, 0, 0}); // 화면문자수, 클립보드문자수, 연산수
        isVisited = new boolean[1001][1001];
        isVisited[1][0] = true; // [화면문자수][클립보드 문자수]로 채워넣기

        while(!queue.isEmpty()) {
            int[] now = queue.poll();
            int screen = now[0];
            int clipboard = now[1];
            int count = now[2];

            if (screen == goal) return count;

            // 복사 연산
            if (screen > 0 && !isVisited[screen][screen]) { // 복사하면 화면문자수 == 클립보드 문자수
                isVisited[screen][screen] = true;
                queue.add(new int[] {screen, screen, count + 1});
            }

            // 붙여넣기 연산
            if (clipboard > 0 && screen + clipboard <= 1000 && !isVisited[screen + clipboard][clipboard]) {
                isVisited[screen + clipboard][clipboard] = true;
                queue.add(new int[] {screen + clipboard, clipboard, count + 1});
            }

            // 삭제 연산
            if (screen > 1 && !isVisited[screen - 1][clipboard]) {
                isVisited[screen - 1][clipboard] = true;
                queue.add(new int[] {screen - 1, clipboard, count + 1});
            }
        }
        return -1;
    }
}