package daily.dd20221201;

import base.json.JsonArray;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

class Solution {
    public int nearestValidPoint(int x, int y, int[][] points) {
        int d = Integer.MAX_VALUE;
        int ans = -1;
        for (int i = 0; i < points.length; i++) {
            if (points[i][0] == x || points[i][1] == y) {
                int tmp = dis(x, y, points[i][0], points[i][1]);
                if (tmp < d) {
                    ans = i;
                    d = tmp;
                }
            }
        }
        return ans;
    }

    private int dis(int x1, int y1, int x2, int y2) {
        return Math.abs(x1 - x2) + Math.abs(y1 - y2);
    }
}
/*3
4
[[1,2],[3,1],[2,4],[2,3],[4,4]]
3
4
[[3,4]]
3
4
[[2,3]]*/

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
    
    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        String line;
        while ((line = in.readLine()) != null) {
            int x = Integer.parseInt(line);
            line = in.readLine();
            int y = Integer.parseInt(line);
            line = in.readLine();
            int[][] points = stringToInt2dArray(line);
            
            int ret = new Solution().nearestValidPoint(x, y, points);
            
            String out = String.valueOf(ret);
            
            System.out.print(out);
        }
    }
}