package daily.dd20221130;

import java.util.*;

class FreqStack1 {
    private Map<Integer, Integer> freq;

    private List<Deque<Integer>> stacks;

    public FreqStack1() {
        freq = new HashMap<>();
        stacks = new ArrayList<>();

    }
    
    public void push(int val) {
        int tmp = freq.getOrDefault(val, 0);
        if (tmp == stacks.size()) {
            stacks.add(new ArrayDeque<>());
        }
        stacks.get(tmp).push(val);
        freq.put(val, tmp + 1);
    }
    
    public int pop() {
        int tmp = stacks.size() - 1;
        int val = stacks.get(tmp).pop();
        if (stacks.get(tmp).isEmpty()) {
            stacks.remove(tmp);
        }
        freq.put(val, freq.get(val) - 1);
        return val;
    }
}

class FreqStack {
    private Map<Integer, Integer> freq;

    private Map<Integer, Deque<Integer>> stacks;

    private int maxFreq;

    public FreqStack() {
        freq = new HashMap<>();
        stacks = new HashMap<>();
        maxFreq = 0;
    }

    public void push(int val) {
        freq.put(val, freq.getOrDefault(val, 0) + 1);
        int cnt = freq.get(val);
        stacks.computeIfAbsent(cnt, k -> new ArrayDeque<>()).push(val);
        maxFreq = Math.max(maxFreq, cnt);
    }

    public int pop() {
        int val = stacks.get(maxFreq).pop();
        if (stacks.get(maxFreq).isEmpty()) {
            maxFreq--;
        }
        freq.put(val, freq.get(val) - 1);
        return val;
    }
}

/**
 * Your FreqStack object will be instantiated and called as such:
 * FreqStack obj = new FreqStack();
 * obj.push(val);
 * int param_2 = obj.pop();
 */
/*["FreqStack","push","push","push","push","push","push","pop","pop","pop","pop"]
[[],[5],[7],[5],[7],[4],[5],[],[],[],[]]*/