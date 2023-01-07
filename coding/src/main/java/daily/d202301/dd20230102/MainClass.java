package daily.d202301.dd20230102;

import base.json.JsonArray;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;

class Solution {
    public int getNumberOfBacklogOrders(int[][] orders) {
        final int MOD = 1000000000 + 7;
        PriorityQueue<int[]> buyQueue = new PriorityQueue<>((a, b) -> b[0] - a[0]);
        PriorityQueue<int[]> sellQueue = new PriorityQueue<>((a, b) -> a[0] - b[0]);
        for (int[] order : orders) {
            if (order[2] == 0) { // buy
                int[] sell = sellQueue.peek();
                while (sell != null && sell[0] <= order[0] && order[1] > 0) {
                    if (order[1] == sell[1]) {
                        sellQueue.poll();
                        order[1] = 0;
                    } else if (order[1] > sell[1]) {
                        sellQueue.poll();
                        order[1] -= sell[1];
                    } else {
                        sell[1] -= order[1];
                        order[1] = 0;
                    }
                    sell = sellQueue.peek();
                }

                if (order[1] > 0) {
                    buyQueue.offer(order);
                }
            } else { // sell
                int[] buy = buyQueue.peek();
                while (buy != null && buy[0] >= order[0] && order[1] > 0) {
                    if (buy[1] == order[1]) {
                        buyQueue.poll();
                        order[1] = 0;
                    } else if (order[1] > buy[1]) {
                        buyQueue.poll();
                        order[1] -= buy[1];
                    } else {
                        buy[1] -= order[1];
                        order[1] = 0;
                    }
                    buy = buyQueue.peek();
                }
                if (order[1] > 0) {
                    sellQueue.offer(order);
                }
            }
        }

        int ans = 0;
        while (!buyQueue.isEmpty()) {
            int[] buy = buyQueue.poll();
            ans = (ans + buy[1]) % MOD;
        }
        while (!sellQueue.isEmpty()) {
            int[] sell = sellQueue.poll();
            ans = (ans + sell[1]) % MOD;
        }
        return ans;
    }
}
/*[[10,5,0],[15,2,1],[25,1,1],[30,4,0]]
[[7,1000000000,1],[15,3,0],[5,999999995,0],[5,1,1]]*/

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

    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        String line;
        while ((line = in.readLine()) != null) {
            int[][] orders = stringToInt2dArray(line);

            int ret = new Solution().getNumberOfBacklogOrders(orders);

            String out = String.valueOf(ret);

            System.out.print(out);
        }
    }
}