package daily.d202212.dd20221216;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

class Solution {
    public int minElements(int[] nums, int limit, int goal) {
        long sum = 0;
        for (int x : nums) sum += x;
        long target = Math.abs(goal - sum);
        return (int) ((target + limit - 1) / limit);
    }
}
/*[1,-1,1]
3
-4
[1,-10,9,1]
100
0*/

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
            int limit = Integer.parseInt(line);
            line = in.readLine();
            int goal = Integer.parseInt(line);

            int ret = new Solution().minElements(nums, limit, goal);

            String out = String.valueOf(ret);

            System.out.print(out);
        }
    }
}