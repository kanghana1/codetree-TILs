import java.util.*;
import java.io.*;

public class Main {
    static int n;
    static int cnt = 0;
    static ArrayList<Integer>[] arr;
    static boolean[] isVisit;

    public static void main(String[] args) throws IOException {
        // 여기에 코드를 작성해주세요.
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        arr = new ArrayList[n];

        for (int i = 0 ; i < n ; i++) { // 배열에 리스트 생성
            arr[i] = new ArrayList<>();
        }
        
        for (int i = 0 ; i < m ; i++) { // 리스트에 값 넣기
            st = new StringTokenizer(br.readLine());
            int idx = Integer.parseInt(st.nextToken());
            int val = Integer.parseInt(st.nextToken());
            arr[idx - 1].add(val);
        }
        int[][] answer = new int[n][2]; // 노드마다 연결된 노드개수 담는 배열 생성
        for (int i = 0 ; i < n ; i++) {
            isVisit = new boolean[n];
            cnt = 0;
            int a = dfs(i + 1);
            answer[i][0] = i + 1;
            answer[i][1] = a;
        }

        Arrays.sort(answer, new Comparator<int[]>() { // cnt 내림차순, 값 오름차순
            @Override
            public int compare(int[] o1, int[] o2) {
                if (o1[1] == o2[1]) {
                    return o1[0] - o2[0];
                } else {
                    return o2[1] - o1[1];
                }
            }
        });
        int max = answer[0][1];
        StringBuilder sb = new StringBuilder();
        for (int i = 0 ; i < n ; i++) {
            if (max == answer[i][1]) {
                sb.append(answer[i][0] + " ");
            }
        }

        System.out.println(sb.toString());

    }
    public static int dfs(int start) {
        isVisit[start - 1] = true;
        cnt++;
        for (int i = 0 ; i < arr[start - 1].size() ; i++) {
            if (!isVisit[arr[start - 1].get(i) - 1]) {
                dfs(arr[start - 1].get(i));
            }
        }
        return cnt;
    }
}