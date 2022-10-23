package daily.d202210.dd20221021;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

class StockSpanner {
    private Stack<Integer> stack;

    private List<Integer> arr;

    public StockSpanner() {
        stack = new Stack<>();
        arr = new ArrayList<>();
    }

    public int next(int price) {
        while (!stack.isEmpty() && arr.get(stack.peek()) <= price) {
            stack.pop();
        }

        int index = !stack.isEmpty() ? stack.peek() + 1 : 0;
        arr.add(price);
        stack.push(arr.size() - 1);
        return arr.size() - index;
    }
}

/**
 * Your StockSpanner object will be instantiated and called as such:
 * StockSpanner obj = new StockSpanner();
 * int param_1 = obj.next(price);
 */
/*["StockSpanner","next","next","next","next","next","next","next"]
[[],[100],[80],[60],[70],[60],[75],[85]]*/