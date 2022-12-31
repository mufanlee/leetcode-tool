package daily.dd20221230;

import java.util.TreeSet;

class ExamRoom {
    private final TreeSet<Integer> set;

    private final int n;

    public ExamRoom(int n) {
        this.set = new TreeSet<>();
        this.n = n;
    }

    public int seat() {
        if (set.isEmpty()) {
            this.set.add(0);
            return 0;
        }

        int l = set.first(), d = set.first(), id = 0;
        for (int r : set) {
            if (d < (r - l) / 2) {
                d = (r - l) / 2;
                id = (l + r) / 2;
            }
            l = r;
        }

        int t = n - 1 - set.last();
        if (t > d) {
            id = n - 1;
        }
        set.add(id);
        return id;
    }

    public void leave(int p) {
        set.remove(p);
    }
}

/**
 * Your ExamRoom object will be instantiated and called as such:
 * ExamRoom obj = new ExamRoom(n);
 * int param_1 = obj.seat();
 * obj.leave(p);
 */
/*["ExamRoom","seat","seat","seat","seat","leave","seat"]
[[10],[],[],[],[],[4],[]]*/