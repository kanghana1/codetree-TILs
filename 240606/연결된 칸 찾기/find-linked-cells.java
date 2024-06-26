import java.util.*;
import java.io.*;

public class Main {

    static int n;
    static int cnt;
    static int[][] mainArr;
    static boolean[][] isVisit;

    public static void main(String[] args) throws IOException {
        // 여기에 코드를 작성해주세요.
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());

        StringTokenizer st;
        mainArr = new int[n][n];
        isVisit = new boolean[n][n];
        
        for (int i = 0 ; i < n ; i++) { // 배열에 값 넣기
            st = new StringTokenizer(br.readLine());
            for (int j = 0 ; j < n ; j++) {
                mainArr[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        List<Integer> lst = new ArrayList<>();
        for (int i = 0 ; i < n ; i++) {
            for (int j = 0 ; j < n ; j++) {
                cnt = 0;
                if (!isVisit[i][j] && mainArr[i][j] == 1) {
                    int count = dfs(i, j);
                    lst.add(count);
                }
            }
        }        
        Collections.sort(lst);
        StringBuilder sb = new StringBuilder();
        sb.append(lst.size()).append("\n");

        for (int i = 0 ; i < lst.size() ; i++) {
            sb.append(lst.get(i)).append("\n");
        }

        System.out.println(sb.toString());
    }

    public static int dfs(int r, int c) {
        isVisit[r][c] = true;
        cnt++;

        if (r != 0 && (!isVisit[r - 1][c]) && mainArr[r - 1][c] == 1) { // 위
            dfs(r - 1, c);
        } 
        if (r != n - 1 && (!isVisit[r + 1][c]) && mainArr[r + 1][c] == 1) { // 아래
            dfs(r + 1, c);
        } 
        if (c != 0 && (!isVisit[r][c - 1]) && mainArr[r][c - 1] == 1) { // 왼
            dfs(r, c - 1);
        } 
        if (c != n - 1 && (!isVisit[r][c + 1]) && mainArr[r][c + 1] == 1) { // 오
            dfs(r, c + 1);
        } 

        return cnt;

    }
}