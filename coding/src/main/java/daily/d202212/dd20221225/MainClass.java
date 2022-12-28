package daily.d202212.dd20221225;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

class Solution {
    public int minimumBoxes(int n) {
        int level = 1, num = 0;
        while (num + (level + 1) * level / 2 <= n) {
            num += (level + 1) * level / 2;
            level++;
        }
        level--;

        int ans = (level + 1) * level / 2;

        int up = 0;
        while (num < n) {
            ans++;
            num += up + 1;
            up++;
        }
        return ans;
    }
}
/*3
4
10*/

public class MainClass {
    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        String line;
        while ((line = in.readLine()) != null) {
            int n = Integer.parseInt(line);

            int ret = new Solution().minimumBoxes(n);

            String out = String.valueOf(ret);

            System.out.print(out);
        }
    }
}