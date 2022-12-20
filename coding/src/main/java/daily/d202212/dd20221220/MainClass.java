package daily.d202212.dd20221220;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

class Solution {
    public int minimumSize(int[] nums, int maxOperations) {
        int l = 1, r = nums[0];
        for (int x : nums) r = Math.max(r, x);
        while (l < r) {
            int mid = l + r >> 1;
            if (check(mid, nums, maxOperations)) {
                r = mid;
            } else {
                l = mid + 1;
            }
        }
        return l;
    }

    private boolean check(int mid, int[] nums, int maxOperations) {
        int cnt = 0;
        for (int x : nums) {
            if (x <= mid) continue;
            cnt += (x - 1) / mid;
        }
        return cnt <= maxOperations;
    }
}
/*[9]
2
[2,4,8,2]
4*/

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
            int maxOperations = Integer.parseInt(line);

            int ret = new Solution().minimumSize(nums, maxOperations);

            String out = String.valueOf(ret);

            System.out.print(out);
        }
    }
}