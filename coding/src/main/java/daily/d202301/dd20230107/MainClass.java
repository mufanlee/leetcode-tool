package daily.d202301.dd20230107;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

class Solution {
    public int minOperations(int[] nums, int x) {
        int n = nums.length, sum = 0;
        for (int a : nums) sum += a;
        if (sum < x) return -1;
        else if (sum == x) return n;

        int ans = Integer.MAX_VALUE, target = sum - x, i = 0, j = 0;
        sum = 0;
        while (j < n) {
            sum += nums[j++];
            while (sum > target) sum -= nums[i++];
            if (sum == target) ans = Math.min(ans, n - (j - i));
        }
        return ans == Integer.MAX_VALUE ? -1 : ans;
    }
}
/*[1,1,4,2,3]
5
[5,6,7,8,9]
4
[3,2,20,1,1,3]
10*/

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
            int x = Integer.parseInt(line);

            int ret = new Solution().minOperations(nums, x);

            String out = String.valueOf(ret);

            System.out.print(out);
        }
    }
}