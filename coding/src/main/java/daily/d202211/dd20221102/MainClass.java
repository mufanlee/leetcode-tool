package daily.d202211.dd20221102;

import base.json.JsonArray;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

class Solution {
    public int[] bestCoordinate(int[][] towers, int radius) {
        int[] ans = new int[2];
        int max = 0;
        for (int i = 0; i <= 50; i++) {
            for (int j = 0; j <= 50; j++) {
                int q = 0;
                for (int[] tower : towers) {
                    int d = (i - tower[0]) * (i - tower[0]) + (j - tower[1]) * (j - tower[1]);
                    if (d <= radius * radius) {
                        q += (int) Math.floor(tower[2] / (1 + Math.sqrt(d)));
                    }
                }
                if (q > max) {
                    ans = new int[]{i, j};
                    max = q;
                }
            }
        }
        return ans;
    }
}
/*[[1,2,5],[2,1,7],[3,1,9]]
2
[[23,11,21]]
9
[[1,2,13],[2,1,7],[0,1,9]]
2*/

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

    public static int[][] stringToInt2dArray(String input) {
        JsonArray jsonArray = JsonArray.readFrom(input);
        if (jsonArray.size() == 0) {
            return new int[0][0];
        }

        int[][] arr = new int[jsonArray.size()][];
        for (int i = 0; i < arr.length; i++) {
            JsonArray cols = jsonArray.get(i).asArray();
            arr[i] = stringToIntegerArray(cols.toString());
        }
        return arr;
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
            int[][] towers = stringToInt2dArray(line);
            line = in.readLine();
            int radius = Integer.parseInt(line);

            int[] ret = new Solution().bestCoordinate(towers, radius);

            String out = integerArrayToString(ret);

            System.out.print(out);
        }
    }
}