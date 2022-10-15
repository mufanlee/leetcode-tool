package daily.d202209.dd20220914;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.text.DecimalFormat;
import java.util.Arrays;

class Solution {
    public double trimMean(int[] arr) {
        int n = arr.length;
        Arrays.sort(arr);
        int sum = 0;
        for (int i = n / 20; i < 19 * n / 20; i++) {
            sum += arr[i];
        }
        return sum / (0.9 * n);
    }
}
/*[1,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,3]
[6,2,7,5,1,2,0,3,10,2,5,0,5,5,0,8,7,6,8,0]
[6,0,7,0,7,5,7,8,3,4,0,7,8,1,6,8,1,1,2,4,8,1,9,5,4,3,8,5,10,8,6,6,1,0,6,10,8,2,3,4]*/

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
            int[] arr = stringToIntegerArray(line);
            
            double ret = new Solution().trimMean(arr);
            
            String out = doubleToString(ret);
            
            System.out.print(out);
        }
    }
}