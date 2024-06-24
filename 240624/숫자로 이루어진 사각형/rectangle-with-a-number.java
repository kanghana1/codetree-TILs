import java.util.*;
import java.io.*;
public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        prints(n);
    }
    public static void prints(int n) {
        int number = 1;
        for (int i = 0 ; i < n ; i++) {
            for (int j = 0 ; j < n ; j++) {
                System.out.print(number + " ");
                number++;
                if (number == 10) number = 1;
            }
            System.out.println();
        }
    }
}