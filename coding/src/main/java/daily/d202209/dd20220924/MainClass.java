package daily.d202209.dd20220924;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

class Solution {
    public int[] decrypt(int[] code, int k) {
        int n = code.length;
        int[] ans = new int[n];
        if (k == 0) return ans;
        int[] sum = new int[n * 2 + 10];
        for (int i = 1; i <= 2 * n; i++) sum[i] += sum[i - 1] + code[(i - 1) % n];
        for (int i = 1; i <= n; i++) {
            if (k < 0) ans[i - 1] = sum[i + n - 1] - sum[i + n + k - 1];
            else ans[i - 1] = sum[i + k] - sum[i];
        }
        return ans;
    }
}
/*[5,7,1,4]
3
[1,2,3,4]
0
[2,4,9,3]
-2*/

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

    public static String integerArrayToString(int[] nums, int length) {
        if (length == 0) {
            return "[]";
        }

        String result = "";
        for (int index = 0; index < length; index++) {
            int number = nums[index];
            result += Integer.toString(number) + ", ";
        }
        return "[" + result.substring(0, result.length() - 2) + "]";
    }

    public static String integerArrayToString(int[] nums) {
        return integerArrayToString(nums, nums.length);
    }

    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        String line;
        while ((line = in.readLine()) != null) {
            int[] code = stringToIntegerArray(line);
            line = in.readLine();
            int k = Integer.parseInt(line);

            int[] ret = new Solution().decrypt(code, k);

            String out = integerArrayToString(ret);

            System.out.print(out);
        }
    }
}