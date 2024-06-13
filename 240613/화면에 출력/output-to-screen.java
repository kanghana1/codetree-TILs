import java.util.*;
import java.io.*;
public class Main {

    static int goal;
    static int copyNum;
    static Queue<int[]> queue = new LinkedList<>();


    public static void main(String[] args) throws IOException {
        // 여기에 코드를 작성해주세요.
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int goal = Integer.parseInt(br.readLine());
        System.out.println(bfs(1));

    }

    public static int bfs(int init) {
        queue.add(new int[] {init, 1}); // 값, cnt
        while(!queue.isEmpty()) {
            int[] now = queue.poll();
            if (now[0] == goal) return now[1];

            for (int i = 1 ; i <= 3 ; i++) {
                queue.add(copy(now[0], now[1]));
                queue.add(paste(now[0], now[1]));
                queue.add(delete(now[0], now[1]));
            }

        }
        return 0;

    }

    public static int[] copy(int n, int cnt) { // 값, cnt
        copyNum = n;
        return new int[] {n, cnt + 1};
    }
    public static int[] paste(int now, int cnt) {
        int[] arr = new int[2];
        arr[0] = now + copyNum;
        arr[1] = cnt + 1;
        return arr;
    }
    public static int[] delete(int now, int cnt) {
        int[] arr = new int[2];
        arr[0] = now - 1;
        arr[1] = cnt + 1;
        return arr;
    }

}