package exercises.leetcode401_600;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.PriorityQueue;

/**
 * 642. Design Search Autocomplete System
 */

public class AutocompleteSystem {
    static class TrieNode implements Comparable<TrieNode> {
        TrieNode[] children;
        String s;
        int times;
        List<TrieNode> hot;

        public TrieNode() {
            children = new TrieNode[128];
            s = null;
            times = 0;
            hot = new ArrayList<>();
        }

        public int compareTo(TrieNode o) {
            if (this.times == o.times) {
                return this.s.compareTo(o.s);
            }

            return o.times - this.times;
        }

        public void update(TrieNode node) {
            if (!this.hot.contains(node)) {
                this.hot.add(node);
            }

            Collections.sort(hot);

            if (hot.size() > 3) {
                hot.remove(hot.size() - 1);
            }
        }
    }

    TrieNode root;
    TrieNode cur;
    StringBuilder sb;

    public AutocompleteSystem(String[] sentences, int[] times) {
        root = new TrieNode();
        cur = root;
        sb = new StringBuilder();

        for (int i = 0; i < times.length; i++) {
            add(sentences[i], times[i]);
        }
    }

    public void add(String sentence, int t) {
        TrieNode tmp = root;

        List<TrieNode> visited = new ArrayList<>();
        for (char c : sentence.toCharArray()) {
            if (tmp.children[c] == null) {
                tmp.children[c] = new TrieNode();
            }

            tmp = tmp.children[c];
            visited.add(tmp);
        }

        tmp.s = sentence;
        tmp.times += t;

        for (TrieNode node : visited) {
            node.update(tmp);
        }
    }

    public List<String> input(char c) {
        List<String> res = new ArrayList<>();
        if (c == '#') {
            add(sb.toString(), 1);
            sb = new StringBuilder();
            cur = root;
            return res;
        }

        sb.append(c);
        if (cur != null) {
            cur = cur.children[c];
        }

        if (cur == null) return res;

        for (TrieNode node : cur.hot) {
            res.add(node.s);
        }

        return res;
    }
}
//public class AutocompleteSystem {
//    TrieNode root;
//    TrieNode current;
//    StringBuilder sb;
//    static Map<Integer, Integer> occ;
//    static List<String> sentenceList;
//
//    public AutocompleteSystem(String[] sentences, int[] times) {
//        this.root = new TrieNode('/');
//        this.current = this.root;
//        this.sb = new StringBuilder();
//        occ = new HashMap<>();
//        sentenceList = new ArrayList<>();
//
//        for (int i = 0; i < sentences.length; i++) {
//            String sentence = sentences[i];
//            int time = times[i];
//            sentenceList.add(sentence);
//            register(sentence, time, sentenceList.size() - 1);
//        }
//    }
//
//    public List<String> input(char c) {
//        if (c == '#') {
//            String newSentence = sb.toString();
//            if (!sentenceList.contains(newSentence)) {
//                sentenceList.add(newSentence);
//            }
//            register(newSentence, 1, sentenceList.indexOf(newSentence));
//            this.current = this.root;
//            this.sb = new StringBuilder();
//            return new ArrayList<>();
//        }
//
//        sb.append(c);
//        if (this.current.children.containsKey(c)) {
//            this.current = this.current.children.get(c);
//            List<String> result = new ArrayList<>();
//            List<Integer> tmp = new ArrayList<>();
//            while (!this.current.top3Stack.isEmpty()) {
//                Integer index = this.current.top3Stack.poll();
//                result.add(sentenceList.get(index));
//                tmp.add(index);
//            }
//            Collections.reverse(result);
//            this.current.top3Stack.addAll(tmp);
//            return result;
//        }
//
//        return new ArrayList<>();
//    }
//
//    public void register(String sentence, int time, int index) {
//        TrieNode pt = root;
//        int times = occ.getOrDefault(index, 0) + time;
//        occ.put(index, times);
//        for (int j = 0; j < sentence.length(); j++) {
//            pt = pt.insert(sentence.charAt(j), sentence, times, index);
//        }
//    }
//
//    static class TrieNode {
//        char val;
//        Map<Character, TrieNode> children;
//        PriorityQueue<Integer> top3Stack;
//
//        public TrieNode(char val) {
//            this.val = val;
//            this.children = new HashMap<>();
//            this.top3Stack = new PriorityQueue<>(4,
//                                                 (a, b) -> occ.get(a).equals(occ.get(b))
//                                                           ? sentenceList.get(a)
//                                                                         .compareTo(sentenceList.get(b))
//                                                           : occ.get(a) - occ.get(b));
//        }
//
//        private TrieNode insert(char c, String sentence, int time, int index) {
//            TrieNode node = this.children.getOrDefault(c, new TrieNode(c));
//
//            if (node.top3Stack.contains(index)) {
//                node.top3Stack.poll();
//            }
//            node.top3Stack.offer((index));
//            if (node.top3Stack.size() > 3) {
//                node.top3Stack.poll();
//            }
//
//            this.children.put(c, node);
//            return node;
//        }
//    }
//}
