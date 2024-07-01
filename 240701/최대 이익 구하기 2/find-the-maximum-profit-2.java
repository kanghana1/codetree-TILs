import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        int[] dp = new int[n + 1];


        List<Job> jobs = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int t = Integer.parseInt(st.nextToken());
            int p = Integer.parseInt(st.nextToken());
            jobs.add(new Job(i + 1, t, p)); // 넣을 인덱스 지정
        }

        for (int i = 0; i < n; i++) {
        
            if (i < n) {
                dp[i + 1] = Math.max(dp[i + 1], dp[i]);
            }

            // 일이 끝나는 날짜 계산
            int endDay = i + jobs.get(i).time;
            if (endDay <= n) {
                dp[endDay] = Math.max(dp[endDay], dp[i] + jobs.get(i).pay);
            }
        }

        // 최대 이익 출력
        System.out.println(dp[n]);
    }
}

// 일(Job) 클래스 정의
class Job {
    int start; // 시작 날짜
    int time;  // 소요 기간
    int pay;   // 돈

    Job(int start, int time, int pay) {
        this.start = start;
        this.time = time;
        this.pay = pay;
    }
}