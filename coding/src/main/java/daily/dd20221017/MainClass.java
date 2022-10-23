package daily.dd20221017;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;

class Solution {
    public int totalFruit(int[] fruits) {
        int ans = 0, n = fruits.length;
        Map<Integer, Integer> map = new HashMap<>();
        for (int r = 0, l = 0; r < n; r++) {
            while (l < n && map.size() == 2 && !map.containsKey(fruits[r])) {
                map.put(fruits[l], map.get(fruits[l]) - 1);
                if (map.get(fruits[l]) == 0) map.remove(fruits[l]);
                l++;
            }

            map.put(fruits[r], map.getOrDefault(fruits[r], 0) + 1);
            ans = Math.max(ans, r - l + 1);
        }
        return ans;
    }
}
/*[1,2,1]
[0,1,2,2]
[1,2,3,2,2]*/

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
            int[] fruits = stringToIntegerArray(line);

            int ret = new Solution().totalFruit(fruits);

            String out = String.valueOf(ret);

            System.out.print(out);
        }
    }
}