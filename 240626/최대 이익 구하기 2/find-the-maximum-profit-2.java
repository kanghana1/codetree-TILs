import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException{
        // 여기에 코드를 작성해주세요.
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        List<C> lst = new ArrayList<>();
        int n = Integer.parseInt(br.readLine());
        int[] dp = new int[n + 1];

        for (int i = 1 ; i <= n ; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int gap = Integer.parseInt(st.nextToken());
            int price = Integer.parseInt(st.nextToken());
            if (i + gap - 1 <= n) {
                lst.add(new C(i, i + gap - 1, gap, price));
            }
        }

        for (int i = 1; i <= n; i++) {
            // 이전까지의 최대 이익을 현재 dp에 반영
            dp[i] = Math.max(dp[i], dp[i - 1]);
            
            // 일을 하는 경우
            if (i + lst.get(i - 1).getGap() - 1 <= n) {
                dp[i + lst.get(i - 1).getGap() - 1] = Math.max(dp[i + lst.get(i - 1).getGap() - 1], dp[i - 1] + lst.get(i - 1).getPrice());
            }
        }
        
        // 최대 이익 도출
        System.out.println(dp[n]);
        
    } 

    static class C {
        private int start;
        private int end;
        private int gap;
        private int price;

        public C(int s, int e, int g, int p) {
            this.start = s;
            this.end = e;
            this.gap = g;
            this.price = p;
        } 

        public int getEnd() {
            return this.end;
        }

        public int getPrice() {
            return this.price;
        }
        public int getGap() {
            return this.gap;
        }
    }
}