import java.util.*;
import java.io.*;
public class Main {
    static List<PC> lst = new ArrayList<>();
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        for (int i = 0 ; i < N ; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            lst.add(new PC(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken())));
        }


        int cnt = lst.get(0).numOfPc;
        boolean overlap = true;
        for (int i = 1 ; i < N ; i++) {
            overlap = true;
            for (int j = 0 ; j < i ; j++) {
                if (lst.get(i).start > lst.get(j).end || lst.get(i).end < lst.get(j).start) { // 안 겹침
                    overlap = false;
                    if (lst.get(j).numOfPc < lst.get(i).numOfPc) {
                        cnt = cnt - lst.get(j).numOfPc + lst.get(i).numOfPc;
                    }

                } 
            }
            if (overlap) {
                cnt += lst.get(i).numOfPc;
            }
        }
        System.out.println(cnt);
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