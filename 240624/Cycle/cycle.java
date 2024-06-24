import java.util.*;
import java.io.*;
public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int P = Integer.parseInt(st.nextToken());

        List<Integer> lst = new ArrayList<>();
        lst.add(N);
        int result = N;
        int cnt = 0;
        while (true) {
            result = (result * N) % P;
            cnt++;
            if (lst.contains(result)) break;
            lst.add(result);

        }

        for (int i = 0 ; i < lst.size() ; i++) {
            if (lst.get(i) == result) cnt = cnt - i;
        }
        System.out.println(cnt);
    }
}