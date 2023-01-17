package daily.dd20230117;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;

class Solution {
    public int countNicePairs(int[] nums) {
        final int mod = 1000000007;
        int ans = 0;
        Map<Integer, Integer> map = new HashMap<>();
        for (int x : nums) {
            int val = x - reverse(x);
            ans = (ans + map.getOrDefault(val, 0)) % mod;
            map.put(val, map.getOrDefault(val, 0) + 1);
        }
        return ans;
    }

    private int reverse(int x) {
        int res = 0;
        while (x > 0) {
            res = res * 10 + x % 10;
            x /= 10;
        }
        return res;
    }
}
/*[42,11,1,97]
[13,10,35,24,76]*/

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

            int ret = new Solution().countNicePairs(nums);

            String out = String.valueOf(ret);

            System.out.print(out);
        }
    }
}