package exercises.leetcode1_200;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;

public class LRUCache {
    private final HashMap<Integer, Node> nodeMap;
    private final Node head;
    private final Node tail;
    private final int capacity;

    public LRUCache(int capacity) {
        this.nodeMap = new HashMap<>(capacity);
        this.head = new Node(-1, -1);
        this.tail = new Node(-1, -1);
        this.head.next = this.tail;
        this.tail.prev = this.head;
        this.capacity = capacity;
    }

    public int get(int key) {
        if (!nodeMap.containsKey(key)) {
            return -1;
        }

        Node node = nodeMap.get(key);
        moveToTail(node);
        return node.val;
    }

    public void put(int key, int value) {
        if (nodeMap.containsKey(key)) {
            Node node = nodeMap.get(key);
            node.val = value;
            moveToTail(node);
        } else {
            Node node = new Node(key, value);
            if (nodeMap.size() == this.capacity) {
                Node headNode = removehead();
                nodeMap.remove(headNode.key);
            }
            nodeMap.put(key, node);
            moveToTail(node);
        }
    }

    private Node removehead() {
        Node node = this.head.next;
        this.head.next = node.next;
        node.next.prev = this.head;
        return node;
    }

    private void moveToTail(Node node) {
        if (node.prev != null && node.next != null) {
            node.prev.next = node.next;
            node.next.prev = node.prev;
        }

        this.tail.prev.next = node;
        node.next = this.tail;
        node.prev = this.tail.prev;
        this.tail.prev = node;
    }

    public static class Node {
        private int val;
        private Node next;
        private Node prev;
        private final int key;

        public Node(int key, int val) {
            this.val = val;
            this.key = key;
        }
    }

    /*
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
    */

    //    private Map<Integer, Integer> map;

    /**
     * LinkedHashMap(int capacity, float fillRatio): It is used to initialize both the capacity and fill ratio for a LinkedHashMap.
     * A fillRatio also called as loadFactor is a metric that determines when to increase the size of the LinkedHashMap automatically.
     * By default, this value is 0.75 which means that the size of the map is increased when the map is 75% full.
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
/*九章
    // 单链表节点
    static class ListNode {
        public int key, val;
        public ListNode next;

        public ListNode(int key, int val) {
            this.key = key;
            this.val = val;
            this.next = null;
        }
    }

    // cache 的最大容量
    private int capacity;
    // cache 当前存储的容量
    private int size;
    // 单链表的 dummy 头
    private ListNode dummy;
    // 单链表尾
    private ListNode tail;
    // key => 数据节点之前的节点
    private Map<Integer, ListNode> keyToPrev;

    // 构造函数
    public LRUCache(int capacity) {
        this.capacity = capacity;
        this.keyToPrev = new HashMap<Integer, ListNode>();
        // dummy 点的 key 和 value 随意
        this.dummy = new ListNode(0, 0);
        this.tail = this.dummy;
    }

    // 将 key 节点移动到尾部
    private void moveToTail(int key) {
        ListNode prev = keyToPrev.get(key);
        ListNode curt = prev.next;
        // 如果 key 节点已经再尾部，无需移动
        if (tail == curt) {
            return;
        }
        // 从链表中删除 key 节点
        prev.next = prev.next.next;
        tail.next = curt;
        curt.next = null;
        // 分两种情况更新当前节点下一个节点对应的前导节点为 prev
        if (prev.next != null) {
            keyToPrev.put(prev.next.key, prev);
        }
        keyToPrev.put(curt.key, tail);
        tail = curt;
    }

    public int get(int key) {
        // 如果这个 key 根本不存在于缓存，返回 -1
        if (!keyToPrev.containsKey(key)) {
            return -1;
        }
        // 这个 key 刚刚被访问过，因此 key 节点应当被移动到链表尾部
        moveToTail(key);
        // key 节点被移动到链表尾部，返回尾部的节点值，即 tail.val
        return tail.val;
    }

    public void set(int key, int value) {
        // 如果 key 已经存在，更新 keyNode 的 value
        if (get(key) != -1) {
            ListNode prev = keyToPrev.get(key);
            prev.next.val = value;
            return;
        }
        // 如果 key 不存在于 cache 且 cache 未超上限
        // 再结尾存入新的节点
        if (size < capacity) {
            size++;
            ListNode curt = new ListNode(key, value);
            tail.next = curt;
            keyToPrev.put(key, tail);
            tail = curt;
            return;
        }
        // 如果超过上限，删除链表头，继续保存。此处可与上边合并
        ListNode first = dummy.next;
        keyToPrev.remove(first.key);
        first.key = key;
        first.val = value;
        keyToPrev.put(key, dummy);

        moveToTail(key);
    }*/

}
