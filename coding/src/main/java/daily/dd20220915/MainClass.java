package daily.dd20220915;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

class Solution {
    public int flipLights(int n, int presses) {
        if (presses == 0) return 1;
        if (n == 1) return 2;
        else if (n == 2) return presses == 1 ? 3 : 4;
        else return presses == 1 ? 4 : presses == 2 ? 7 : 8;
    }
}
/*1
1
2
1
3
1*/

public class MainClass {
    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        String line;
        while ((line = in.readLine()) != null) {
            int n = Integer.parseInt(line);
            line = in.readLine();
            int presses = Integer.parseInt(line);

            int ret = new Solution().flipLights(n, presses);

            String out = String.valueOf(ret);

            System.out.print(out);
        }
    }
}