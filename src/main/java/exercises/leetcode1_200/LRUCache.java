package exercises.leetcode1_200;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;

public class LRUCache {
    private HashMap<Integer, DoubleLinkedList> cache;
    private DoubleLinkedList head, tail;
    private int capacity;

    public class DoubleLinkedList {
        int key;
        int value;
        DoubleLinkedList pre;
        DoubleLinkedList post;

        public DoubleLinkedList() {}

        public DoubleLinkedList(int key, int value) {
            this.key = key;
            this.value = value;
        }

        public void moveToTail(DoubleLinkedList node) {
            node.pre.post = node.post;
            node.post.pre = node.pre;

            tail.pre.post = node;
            node.pre = tail.pre;
            node.post = tail;
            tail.pre = node;
        }

        public int popHead() {
            DoubleLinkedList keyToRemove = head.post;
            head.post = keyToRemove.post;
            keyToRemove.post.pre = head;

            return keyToRemove.key;
        }

        public void addNewNode(DoubleLinkedList node) {
            node.pre = tail.pre;
            node.post = tail;
            tail.pre.post = node;
            tail.pre = node;
        }
    }

    public LRUCache(int capacity) {
        this.head = new DoubleLinkedList();
        this.tail = new DoubleLinkedList();
        head.pre = null;
        tail.post = null;
        head.post = tail;
        tail.pre = head;
        this.cache = new HashMap<>();
        this.capacity = capacity;
    }

    public int get(int key) {
        if (!cache.containsKey(key))
            return -1;

        DoubleLinkedList node = cache.get(key);
        tail.moveToTail(node);
        return node.value;
    }

    public void put(int key, int value) {
        if (cache.containsKey(key)) {
            DoubleLinkedList node = cache.get(key);
            node.value = value;
            tail.moveToTail(node);
        } else {
            if (cache.size() == capacity) {
                int keyToRemove = head.popHead();
                cache.remove(keyToRemove);
            }
            DoubleLinkedList node = new DoubleLinkedList(key, value);
            cache.put(key, node);
            tail.addNewNode(node);
        }
    }

//    private Map<Integer, Integer> map;

    /**
     *  LinkedHashMap(int capacity, float fillRatio): It is used to initialize both the capacity and fill ratio for a LinkedHashMap.
     *  A fillRatio also called as loadFactor is a metric that determines when to increase the size of the LinkedHashMap automatically.
     *  By default, this value is 0.75 which means that the size of the map is increased when the map is 75% full.
     * @param capacity
     */
//    public LRUCache(int capacity) {
//        map = new LinkedHashMap<>(16, 0.75f, true) {
//            protected boolean removeEldestEntry(Map.Entry eldest) {
//                return size() > capacity;
//            }
//        };
//    }
//
//    public int get(int key) {
//        return map.getOrDefault(key, -1);
//    }
//
//    public void put(int key, int value) {
//        map.put(key,value);
//    }
}
