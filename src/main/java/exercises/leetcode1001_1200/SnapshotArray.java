package exercises.leetcode1001_1200;

import java.util.TreeMap;

public class SnapshotArray {
    private TreeMap<Integer, Integer>[] snapshotMap;
    private int snapId;

    public SnapshotArray(int length) {
        this.snapshotMap = new TreeMap[length];
        this.snapId = 0;
        for (int i = 0; i < length; i++) {
            snapshotMap[i] = new TreeMap<>();
            snapshotMap[i].put(0, 0);
        }
    }

    public void set(int index, int val) {
        this.snapshotMap[index].put(snapId, val);
    }

    public int snap() {
        return this.snapId++;
    }

    public int get(int index, int snap_id) {
        return this.snapshotMap[index].floorEntry(snap_id).getValue();
    }
}
