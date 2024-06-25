import java.util.*;
import java.io.*;
public class Main {
    static List<PC> lst = new ArrayList<>();
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int minStart = 1000;
        int maxEnd = 0;
        for (int i = 0 ; i < N ; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());
            int num = Integer.parseInt(st.nextToken());

            if (start < minStart) minStart = start;
            if (end > maxEnd) maxEnd = end;

            lst.add(new PC(start, end, num));
        }

        int[] arr = new int[maxEnd - minStart + 1];

        for (int i = 0 ; i < N ; i++) {
            for (int j = lst.get(i).start ; j <= lst.get(i).end ; j++) {
                arr[j - minStart] += lst.get(i).numOfPc;
            }
        }

        System.out.println(Arrays.stream(arr).max().getAsInt());
    }

    static class PC {
        private int start;
        private int end;
        private int numOfPc;

        public PC(int start, int end, int numOfPc) {
            this.start = start;
            this.end = end;
            this.numOfPc = numOfPc;
        }
    }
}