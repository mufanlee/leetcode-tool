package daily.d202212.dd20221217;

import base.json.JsonArray;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

class Solution {
    public boolean canChoose(int[][] groups, int[] nums) {
        int i = 0, k = 0;
        while (k < groups.length) {
            while (i < nums.length && nums[i] != groups[k][0]) i++;
            if (i == nums.length || nums.length - i < groups[k].length){
                return false;
            }

            int j = i;
            for (int x : groups[k]) {
                if (nums[j] != x) break;
                j++;
            }
            if (j - i != groups[k].length) {
                i++;
            } else {
                i = j;
                k++;
            }
        }
        return true;
    }
}
/*[[1,-1,-1],[3,-2,0]]
[1,-1,0,1,-1,-1,3,-2,0]
[[10,-2],[1,2,3,4]]
[1,2,3,4,10,-2]
[[1,2,3],[3,4]]
[7,7,1,2,3,4,7,7]*/

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

    public static String booleanToString(boolean input) {
        return input ? "True" : "False";
    }

    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        String line;
        while ((line = in.readLine()) != null) {
            int[][] groups = stringToInt2dArray(line);
            line = in.readLine();
            int[] nums = stringToIntegerArray(line);

            boolean ret = new Solution().canChoose(groups, nums);

            String out = booleanToString(ret);

            System.out.print(out);
        }
    }
}