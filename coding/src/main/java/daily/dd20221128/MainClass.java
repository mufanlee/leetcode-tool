package daily.dd20221128;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.text.DecimalFormat;

class Solution {
    public double largestSumOfAverages(int[] nums, int k) {
        int n = nums.length;
        double[][] dp = new double[n + 1][k + 1];
        double sum = 0;
        for (int i = 1; i <= n; i++) {
            sum += nums[i - 1];
            dp[i][1] = sum / i;
        }
        for (int j = 2; j <= k; j++) {
            for (int i = j; i <= n; i++) {
                sum = 0;
                for (int t = i; t >= j; t--) {
                    sum += nums[t - 1];
                    dp[i][j] = Math.max(dp[i][j], dp[t - 1][j - 1] + sum / (i - t + 1));
                }
            }
        }
        return dp[n][k];
    }
}
/*[9,1,2,3,9]
3
[1,2,3,4,5,6,7]
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
        for(int index = 0; index < parts.length; index++) {
            String part = parts[index].trim();
            output[index] = Integer.parseInt(part);
        }
        return output;
    }
    
    public static String doubleToString(double input) {
        return new DecimalFormat("0.00000").format(input);
    }
    
    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        String line;
        while ((line = in.readLine()) != null) {
            int[] nums = stringToIntegerArray(line);
            line = in.readLine();
            int k = Integer.parseInt(line);
            
            double ret = new Solution().largestSumOfAverages(nums, k);
            
            String out = doubleToString(ret);
            
            System.out.print(out);
        }
    }
}