import java.util.*;
import java.io.*;
public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[] input = new int[n];
        int[] dp = new int[n + 1];
        StringTokenizer st = new StringTokenizer(br.readLine());

        for (int i = 0 ; i < n ; i++) {
            input[i] = Integer.parseInt(st.nextToken());
        }

        for (int i = 1 ; i < n ; i++) {
            if (input[i] > input[i - 1]) dp[i] = dp[i - 1] + 1;
            else dp[i] = dp[i - 1];
        }
        System.out.println(dp[n - 1] + 1);
    }
}