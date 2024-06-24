import java.util.*;
import java.io.*;
public class Main {
    public static void main(String[] args) throws IOException {
        // 여기에 코드를 작성해주세요.
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int m1 = Integer.parseInt(st.nextToken());
        int d1 = Integer.parseInt(st.nextToken());
        int m2 = Integer.parseInt(st.nextToken());
        int d2 = Integer.parseInt(st.nextToken());
        
        int day = 0;
        for (int i = m1 ; i < m2 ; i++) {
            if (i == 2) day += 28;
            else if ((i % 2 == 0 && i <= 6) || (i % 2 == 1 && i >= 7)) day += 30;
            else day += 31; 
        }
        day -= d1;
        day += d2;
        System.out.print(day + 1);
        
    }
}