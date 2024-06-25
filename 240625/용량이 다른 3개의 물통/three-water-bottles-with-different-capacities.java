import java.util.*;
import java.io.*;
public class Main {
    static List<Bottle> lst = new ArrayList<>();
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        for (int i = 0 ; i < 3 ; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            lst.add(new Bottle(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken())));
        }

        for (int i = 0 ; i < 100 ; i++) {
            moveWater(i % 3);
        }

        StringBuilder sb = new StringBuilder();
        sb.append(lst.get(0).rest).append("\n").append(lst.get(1).rest).append("\n").append(lst.get(2).rest);
        System.out.println(sb.toString());
    }

    public static void moveWater(int i) { // i = 0, 1, 2
        int bottle1 = lst.get(i).getRest();
        int bottle2 = lst.get((i + 1) % 3).getRest();

        if (lst.get((i + 1) % 3).getMaximum() >= bottle1 + bottle2) {
            lst.get((i + 1) % 3).setRest( bottle1 + bottle2);
            lst.get(i).setRest(0);
        }
        else {
            lst.get((i + 1) % 3).setRest(lst.get((i + 1) % 3).getMaximum());
            lst.get(i).setRest(bottle1 + bottle2 - lst.get((i + 1) % 3).getMaximum());
        }
    }

    static class Bottle {
        private int maximum;
        private int rest;
        public Bottle(int maximum, int rest) {
            this.maximum = maximum;
            this.rest = rest;
        }

        public void setRest(int rest) {
            this.rest = rest;
        }

        public int getMaximum() {
            return maximum;
        }

        public int getRest() {
            return rest;
        }
    }
}