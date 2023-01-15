package daily.dd20230115;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

class Solution {
    public int minMaxGame(int[] nums) {
        while (nums.length > 1) {
            int[] arr = new int[nums.length / 2];
            for (int i = 0; i < arr.length; i++) {
                if ((i & 1) == 0) {
                    arr[i] = Math.min(nums[2 * i], nums[2 * i + 1]);
                } else {
                    arr[i] = Math.max(nums[2 * i], nums[2 * i + 1]);
                }
            }
            nums = arr;
        }
        return nums[0];
    }
}
/*[1,3,5,2,4,8,2,2]
[3]*/

public class MainClass {
    public static int[] stringToIntegerArray(String input) {
        input = input.trim();
        input = input.substring(1, input.length() - 1);
        if (input.length() == 0) {
          return new int[0];
        }
    
        String[] parts = input.split(",");
        int[] output = new int[parts.length];
        for(int index = 0; index < parts.length; index++) {
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
            
            int ret = new Solution().minMaxGame(nums);
            
            String out = String.valueOf(ret);
            
            System.out.print(out);
        }
    }
}