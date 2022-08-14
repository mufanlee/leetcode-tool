package daily.dd20220809;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

class Solution {
    public int minStartValue(int[] nums) {
        int min = 0;
        int sum = 0;
        for (int x : nums) {
            sum += x;
            min = Math.min(min, sum);
        }
        return -min + 1;
    }
}
/*[-3,2,-3,4,2]
[1,2]
[1,-2,-3]*/

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
            
            int ret = new Solution().minStartValue(nums);
            
            String out = String.valueOf(ret);
            
            System.out.print(out);
        }
    }
}