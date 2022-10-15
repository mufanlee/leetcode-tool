package daily.d202210.dd20221006;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

class Solution {
    public int[] threeEqualParts(int[] arr) {
        int cnt = 0;
        for (int x : arr) {
            if (x == 1) {
                cnt++;
            }
        }

        if (cnt % 3 != 0) {
            return new int[]{-1, -1};
        }
        if (cnt == 0) {
            return new int[]{0, 2};
        }

        int i = findIdx(1, arr);
        int j = findIdx(cnt / 3 + 1, arr);
        int k = findIdx(cnt / 3 * 2 + 1, arr);
        while (k < arr.length && arr[i] == arr[j] && arr[j] == arr[k]) {
            i++;
            j++;
            k++;
        }
        return k == arr.length ? new int[]{i, j} : new int[]{-1, -1};
    }

    private int findIdx(int t, int[] arr) {
        int res = 0;
        for (int i = 0; i < arr.length; i++) {
            res += arr[i];
            if (res == t) {
                return i;
            }
        }
        return arr.length;
    }
}
/*[1,0,1,0,1]
[1,1,0,1,1]
[1,1,0,0,1]*/

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
            int[] arr = stringToIntegerArray(line);

            int[] ret = new Solution().threeEqualParts(arr);

            String out = integerArrayToString(ret);

            System.out.print(out);
        }
    }
}