package daily.dd20220716;

import java.util.ArrayDeque;
import java.util.Queue;

class MovingAverage {
    private final Queue<Integer> queue;
    private final int size;

    private int sum;

    /**
     * Initialize your data structure here.
     */
    public MovingAverage(int size) {
        this.queue = new ArrayDeque<>(size);
        this.size = size;
        this.sum = 0;
    }

    public double next(int val) {
        if (queue.size() == size) {
            sum -= queue.poll();
        }

        queue.offer(val);
        sum += val;
        return sum * 1.0 / queue.size();
    }
}

/**
 * Your MovingAverage object will be instantiated and called as such:
 * MovingAverage obj = new MovingAverage(size);
 * double param_1 = obj.next(val);
 */
/*["MovingAverage","next","next","next","next"]
[[3],[1],[10],[3],[5]]*/