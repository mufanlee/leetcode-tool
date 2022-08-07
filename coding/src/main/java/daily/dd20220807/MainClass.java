package daily.dd20220807;

import base.json.JsonArray;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;

class Solution {
    public int[] exclusiveTime(int n, List<String> logs) {
        int[] ans = new int[n];
        Deque<Integer> stack = new ArrayDeque<>();
        int t = 0;
        for (String log : logs) {
            String[] ss = log.split(":");
            int id = Integer.parseInt(ss[0]);
            String flag = ss[1];
            int timestamp = Integer.parseInt(ss[2]);
            if ("start".equals(flag)) {
                if (!stack.isEmpty()) {
                    int peek = stack.peek();
                    ans[peek] += timestamp - t;
                }
                stack.push(id);
                t = timestamp;
            } else {
                int pop = stack.pop();
                ans[pop] += timestamp - t + 1;
                t = timestamp + 1;
            }
        }
        return ans;
    }
}
/*2
["0:start:0","1:start:2","1:end:5","0:end:6"]
1
["0:start:0","0:start:2","0:end:5","0:start:6","0:end:6","0:end:7"]
2
["0:start:0","0:start:2","0:end:5","1:start:6","1:end:6","0:end:7"]*/

public class MainClass {
    public static List<String> stringToStringList(String line) {
        JsonArray jsonArray = JsonArray.readFrom(line);
        List<String> list = new ArrayList<>(jsonArray.size());
        for (int i = 0; i < jsonArray.size(); i++) {
            list.add(jsonArray.get(i).asString());
        }
        return list;
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
            int n = Integer.parseInt(line);
            line = in.readLine();
            List<String> logs = stringToStringList(line);

            int[] ret = new Solution().exclusiveTime(n, logs);

            String out = integerArrayToString(ret);

            System.out.print(out);
        }
    }
}