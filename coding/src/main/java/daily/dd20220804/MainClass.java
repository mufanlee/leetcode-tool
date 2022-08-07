package daily.dd20220804;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

class Solution {
    public List<Integer> minSubsequence(int[] nums) {
        Arrays.sort(nums);
        List<Integer> ans = new ArrayList<>();
        int total = Arrays.stream(nums).sum();
        int sum = 0;
        for (int i = nums.length - 1; i >= 0; i--) {
            sum += nums[i];
            ans.add(nums[i]);
            if (sum > total - sum) {
                break;
            }
        }
        return ans;
    }
}
/*[4,3,10,9,8]
[4,4,7,6,7]
[6]*/

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

    public static String integerArrayListToString(List<Integer> nums, int length) {
        if (length == 0) {
            return "[]";
        }

        String result = "";
        for (int index = 0; index < length; index++) {
            Integer number = nums.get(index);
            result += Integer.toString(number) + ", ";
        }
        return "[" + result.substring(0, result.length() - 2) + "]";
    }

    public static String integerArrayListToString(List<Integer> nums) {
        return integerArrayListToString(nums, nums.size());
    }

    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        String line;
        while ((line = in.readLine()) != null) {
            int[] nums = stringToIntegerArray(line);

            List<Integer> ret = new Solution().minSubsequence(nums);

            String out = integerArrayListToString(ret);

            System.out.print(out);
        }
    }
}