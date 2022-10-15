package daily.d202209.dd20220928;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.PriorityQueue;
import java.util.Set;

class Solution {
    public int getKthMagicNumber(int k) {
        final int[] factors = {3, 5, 7};
        PriorityQueue<Long> queue = new PriorityQueue<>();
        Set<Long> set = new HashSet<>();
        queue.offer(1L);
        set.add(1L);
        while (k > 0) {
            Long x = queue.poll();
            for (int y : factors) {
                long nx = x * y;
                if (set.add(nx)) {
                    queue.offer(nx);
                }
            }
            k--;
        }
        return queue.poll().intValue();
    }
}
/**/

public class MainClass {
    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        String line;
        while ((line = in.readLine()) != null) {
            int k = Integer.parseInt(line);

            int ret = new Solution().getKthMagicNumber(k);

            String out = String.valueOf(ret);

            System.out.print(out);
        }
    }
}