package category.unionfind;

public class UnionFind2 {
    private final int[] parent;
    private final int[] size;
    private int count;

    public UnionFind2(int n) {
        count = n;
        parent = new int[n];
        size = new int[n];
        for (int i = 0; i < n; i++) {
            parent[i] = i;
            size[i] = 1;
        }
    }

    /*public int find(int x) {
        if (parent[x] == x) {
            return x;
        }

        return find(parent[x]);
    }*/

    /*public int find(int x) {
        while (parent[x] != x) {
            x = parent[x];
        }
        return x;
    }*/

    // 路径压缩
    public int find(int x) {
        if (parent[x] == x) {
            return x;
        }

        return parent[x] = find(parent[x]);
    }

    /*public int find(int x) {
        while (parent[x] != x) {
            parent[x] = parent[parent[x]];
            x = parent[x];
        }
        return x;
    }*/

    /*public void union(int x, int y) {
        int fx = find(x);
        int fy = find(y);

        if (fx == fy) {
            return;
        }

        parent[fx] = fy;
        count--;
    }*/

    // 按秩合并
    public void union(int x, int y) {
        int fx = find(x);
        int fy = find(y);

        if (fx == fy) {
            return;
        }

        if (size[fx] > size[fy]) {
            parent[fy] = fx;
            size[fx] += size[fy];
        } else {
            parent[fx] = fy;
            size[fy] += size[fx];
        }
        count--;
    }

    public int count() {
        return count;
    }

    public boolean connected(int x, int y) {
        return find(x) == find(y);
    }
}
