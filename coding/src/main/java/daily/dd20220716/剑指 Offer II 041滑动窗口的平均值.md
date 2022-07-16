# [剑指 Offer II 041. 滑动窗口的平均值](https://leetcode.cn/problems/qIsx9U/)

### 题目（简单）

给定一个整数数据流和一个窗口大小，根据该滑动窗口的大小，计算滑动窗口里所有数字的平均值。

实现 `MovingAverage` 类：

* `MovingAverage(int size)` 用窗口大小 `size` 初始化对象。
* `double next(int val)` 成员函数 `next` 每次调用的时候都会往滑动窗口增加一个整数，请计算并返回数据流中最后 `size` 个值的移动平均值，即滑动窗口里所有数字的平均值。

**示例：**

```
输入：
inputs = ["MovingAverage", "next", "next", "next", "next"]
inputs = [[3], [1], [10], [3], [5]]
输出：
[null, 1.0, 5.5, 4.66667, 6.0]

解释：
MovingAverage movingAverage = new MovingAverage(3);
movingAverage.next(1); // 返回 1.0 = 1 / 1
movingAverage.next(10); // 返回 5.5 = (1 + 10) / 2
movingAverage.next(3); // 返回 4.66667 = (1 + 10 + 3) / 3
movingAverage.next(5); // 返回 6.0 = (10 + 3 + 5) / 3
```

**提示：**

* `1 <= size <= 1000`
* `-10`^5^` <= val <= 10`^5^
* 最多调用 `next` 方法 `10`^4^ 次

注意：本题与主站 346 题相同： <https://leetcode-cn.com/problems/moving-average-from-data-stream/>

### 解题思路

#### 方法：队列

直接使用队列模拟滑动窗口。

##### 复杂度分析

- 时间复杂度：初始化和每次调用 $next$ 的时间复杂度都是 $O(1)$。
- 空间复杂度：$O(size)$。

### 代码

```java
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
```

```go
type MovingAverage struct {
	queue []int
	size  int
	sum   int
}

/** Initialize your data structure here. */
func Constructor(size int) MovingAverage {
	return MovingAverage{size: size}
}

func (this *MovingAverage) Next(val int) float64 {
	if len(this.queue) == this.size {
		this.sum -= this.queue[0]
		this.queue = this.queue[1:]
	}

	this.queue = append(this.queue, val)
	this.sum += val
	return float64(this.sum) / float64(len(this.queue))
}

/**
 * Your MovingAverage object will be instantiated and called as such:
 * obj := Constructor(size);
 * param_1 := obj.Next(val);
 */
```

```typescript
class MovingAverage {
    private queue: number[];
    private size: number;
    private sum: number;

    constructor(size: number) {
        this.queue = [];
        this.size = size;
        this.sum = 0;
    }

    next(val: number): number {
        if (this.queue.length === this.size) {
            this.sum -= this.queue[0];
            this.queue = this.queue.slice(1);
        }

        this.queue.push(val);
        this.sum += val;
        return this.sum / this.queue.length;
    }
}

/**
 * Your MovingAverage object will be instantiated and called as such:
 * var obj = new MovingAverage(size)
 * var param_1 = obj.next(val)
 */
```
