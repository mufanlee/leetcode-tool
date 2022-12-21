package daily.dd20221221;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

class Solution {
    public int maximumScore(int a, int b, int c) {
        int sum = a + b + c;
        int max = Math.max(a, Math.max(b, c));
        return sum - max <= max ? sum - max : sum / 2;
    }
}
/*2
4
6
4
4
6
1
8
8*/

public class MainClass {
    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        String line;
        while ((line = in.readLine()) != null) {
            int a = Integer.parseInt(line);
            line = in.readLine();
            int b = Integer.parseInt(line);
            line = in.readLine();
            int c = Integer.parseInt(line);

            int ret = new Solution().maximumScore(a, b, c);

            String out = String.valueOf(ret);

            System.out.print(out);
        }
    }
}