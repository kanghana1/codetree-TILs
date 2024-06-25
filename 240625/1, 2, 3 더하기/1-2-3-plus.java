import java.util.*;
import java.io.*;
public class Main {
    static int n;
    static int cnt = 0;
    public static void main(String[] args) throws IOException {
        // 여기에 코드를 작성해주세요.
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        sum(0);
        System.out.println(cnt);
    }

    public static void sum(int sum) {
        if (sum == n) cnt++;

        if (sum + 1 <= n) {
            sum(sum + 1);
        }

        if (sum + 2 <= n) {
            sum(sum + 2);
        }

        if (sum + 3 <= n) {
            sum(sum + 3);
        }
    }
}