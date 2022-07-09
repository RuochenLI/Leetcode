package exercises.leetcode401_600;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

public class DesignInMemoryFileSystem {
    Node root = new Node();

    public DesignInMemoryFileSystem() {
    }

    public List<String> ls(String path) {
        String[] dirs = path.split("/");
        Node node = root;
        for (String dir : dirs) {
            if ("".equals(dir)) {
                continue;
            }
            node = node.fileList.get(dir);
        }
        return new ArrayList<>(node.fileList.keySet());
    }

    public void mkdir(String path) {
        String[] dirs = path.split("/");
        Node node = root;
        for (String dir : dirs) {
            if ("".equals(dir)) {
                continue;
            }
            Node child = node.fileList.get(dir);
            if (child == null) {
                child = new Node();
                node.fileList.put(dir, child);
            }
            node = child;
        }
    }

    public void addContentToFile(String filePath, String content) {
        String[] dirs = filePath.split("/");
        Node node = root;
        for (int i = 0; i < dirs.length; i++) {
            String dir = dirs[i];
            if ("".equals(dir)) {
                continue;
            }
            Node child = node.fileList.get(dir);
            if (child == null) {
                child = new Node();
                node.fileList.put(dir, child);
            }
            if (i == dirs.length - 1) {
                child.text.append(content);
                child.fileList.put(dir, null);
            }
            node = child;
        }
    }

    public String readContentFromFile(String filePath) {
        String[] dirs = filePath.split("/");
        Node node = root;
        for (String dir : dirs) {
            if ("".equals(dir)) {
                continue;
            }
            node = node.fileList.get(dir);
        }
        return node.text.toString();
    }

    static class Node {
        // 该目录下的所有子目录和文件
        // key是子目录或者文件名称，key为子目录或文件的节点对象
        Map<String, Node> fileList = new TreeMap<>();
        // 如果当前目录是文件，记录文件内容
        StringBuilder text = new StringBuilder();
    }
}
