import java.util.*;
import java.io.*;
public class Main {

    static int[][] arr;
    static boolean[] isVisit;
    static int ans = -1;
    static boolean isStart = false;

    public static void main(String[] args) throws IOException{
        // 여기에 코드를 작성해주세요.
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        arr = new int[n + 1][n + 1];
        isVisit = new boolean[n + 1];

        
        for (int i = 1 ; i <= m ; i++) {
            int cnt = 1;
            st = new StringTokenizer(br.readLine());
            int idx = Integer.parseInt(st.nextToken());
            int val = Integer.parseInt(st.nextToken());

            while(arr[idx][cnt] != 0) {
                cnt++;
            }
            arr[idx][cnt] = val;
            if (val != idx) {
                cnt = 1;
                while(arr[val][cnt] != 0) {
                    cnt++;
                }
                arr[val][cnt] = idx;
            }
        }
        dfs(1);
        System.out.print(ans);

    }

    public static void dfs(int a) {
        isVisit[a] = true;
        ans++;
        for (int i = 1 ; i < arr[a].length ; i++) {
            if (arr[a][i] != 0 && !isVisit[arr[a][i]]) {
                dfs(arr[a][i]);
            }
        }

    }
}