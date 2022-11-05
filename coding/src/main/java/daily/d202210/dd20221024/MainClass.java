package daily.d202210.dd20221024;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

class Solution {
    public int partitionDisjoint(int[] nums) {
        int n = nums.length;
        int[] min = new int[n];
        for (int i = n - 1; i >= 0; i--) {
            min[i] = i == n - 1 ? nums[i] : Math.min(min[i + 1], nums[i]);
        }

        int max = 0;
        for (int i = 0; i < n - 1; i++) {
            max = Math.max(max, nums[i]);
            if (max <= min[i + 1]) {
                return i + 1;
            }
        }
        return n - 1;
    }
}
/*[5,0,3,8,6]
[1,1,1,0,6,12]*/

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

            int ret = new Solution().partitionDisjoint(nums);

            String out = String.valueOf(ret);

            System.out.print(out);
        }
    }
}