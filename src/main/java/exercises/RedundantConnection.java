package exercises;

public class RedundantConnection {
    int[] root;

    public int[] findRedundantConnection(int[][] edges) {
        root = new int[edges.length + 1];
        for (int i = 0; i < edges.length + 1; i++) {
            root[i] = i;
        }

        for (final int[] edge : edges) {
            if (find(edge[0]) == find(edge[1]))
                return edge;
            else union(edge[0], edge[1]);
        }
        return null;
    }

    private int find(int node) {
        if (root[node] != node)
            return find(root[node]);

        return node;
    }

    private void union(int x, int y) {
        root[find(y)] = find(root[x]);
    }
}
//    int MAX_EDGE_VAL = 1000;
//
//    public int[] findRedundantConnection(int[][] edges) {
//        DSU dsu = new DSU(MAX_EDGE_VAL + 1);
//        for (int[] edge: edges) {
//            if (!dsu.union(edge[0], edge[1])) return edge;
//        }
//        throw new AssertionError();
//    }
//}

//    class DSU {
//        int[] parent;
//
//        public DSU(int size) {
//            parent = new int[size];
//            for (int i = 0; i < size; i++) parent[i] = i;
//        }
//
//        public int find(int x) {
//            if (parent[x] != x) parent[x] = find(parent[x]);
//            return parent[x];
//        }
//
//        public boolean union(int x, int y) {
//            int xr = find(x), yr = find(y);
//            if (xr == yr) {
//                return false;
//            } else {
//                parent[yr] = xr;
//            }
//            return true;
//        }
//    }
