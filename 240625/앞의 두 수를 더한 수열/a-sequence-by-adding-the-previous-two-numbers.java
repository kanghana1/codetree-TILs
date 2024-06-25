import java.util.*;
import java.io.*;
public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        System.out.println(sum(n + 1));
    }

    public static int sum(int n) {
        if (n == 1) return 0;
        if (n == 2) return 1;

        return sum(n - 1) + sum(n - 2);
    }
}