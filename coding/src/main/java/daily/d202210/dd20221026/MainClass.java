package daily.d202210.dd20221026;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Deque;

class Solution {
    public int shortestSubarray(int[] nums, int k) {
        int n = nums.length;
        long[] sum = new long[n + 1];
        for (int i = 0; i < n; i++) {
            sum[i + 1] = sum[i] + nums[i];
        }

        int ans = n + 1;
        Deque<Integer> deque = new ArrayDeque<>();
        for (int i = 0; i <= n; i++) {
            while (!deque.isEmpty() && sum[i] - sum[deque.getFirst()] >= k) {
                ans = Math.min(ans, i - deque.pollFirst());
            }
            while (!deque.isEmpty() && sum[i] <= sum[deque.getLast()]) {
                deque.pollLast();
            }
            deque.offerLast(i);
        }
        return ans < n + 1 ? ans : -1;
    }
}
/*[1]
1
[1,2]
4
[2,-1,2]
3*/

public class MainClass {
    public static int[] stringToIntegerArray(String input) {
        input = input.trim();
        input = input.substring(1, input.length() - 1);
        if (input.length() == 0) {
            return new int[0];
        }

        String[] parts = input.split(",");
        int[] output = new int[parts.length];
        for (int index = 0; index < parts.length; index++) {
            String part = parts[index].trim();
            output[index] = Integer.parseInt(part);
        }
        return output;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        String line;
        while ((line = in.readLine()) != null) {
            int[] nums = stringToIntegerArray(line);
            line = in.readLine();
            int k = Integer.parseInt(line);

            int ret = new Solution().shortestSubarray(nums, k);

            String out = String.valueOf(ret);

            System.out.print(out);
        }
    }
}