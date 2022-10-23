package daily.d202210.dd20221020;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

class Solution {
    public int kthGrammar(int n, int k) {
        if (n == 1) return 0;
        return (k & 1) ^ 1 ^ kthGrammar(n - 1, (k + 1) / 2);
    }
}
/*1
1
2
1
2
2*/

public class MainClass {
    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        String line;
        while ((line = in.readLine()) != null) {
            int n = Integer.parseInt(line);
            line = in.readLine();
            int k = Integer.parseInt(line);

            int ret = new Solution().kthGrammar(n, k);

            String out = String.valueOf(ret);

            System.out.print(out);
        }
    }
}