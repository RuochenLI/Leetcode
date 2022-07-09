package interviews.hopper;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.OptionalInt;
import java.util.Set;

public class ConversationTree {

    public static final String HOPPER_MESSAGE_PREFIX = "Hopper: ";
    public static final String USER_MESSAGE_PREFIX = "User: ";
    public static final String CONCLUSION_MESSAGE_PREFIX = "Conclusion: ";
    private static final String NOT_RIGHT_NOW = "Not right now";
    private static final String NO = "No";
    private static final String YES = "Yes";
    private static final String YES_UPGRADE = "Yes, please upgrade";

    public static void main(String[] args) throws Exception {
        new ConversationTree()
          .printConversation(List.of(new IndentationAndInputObject(0, new Output("Output 0 1"))),
                             Arrays.asList(NO, NOT_RIGHT_NOW));
        System.out.println();
        new ConversationTree()
          .printConversation(
            Arrays.asList(
              new IndentationAndInputObject(0, new Output("Output 0 1")),
              new IndentationAndInputObject(0, new Output("Output 0 2"))),
            Arrays.asList(NO, NOT_RIGHT_NOW));
        System.out.println();
        new ConversationTree()
          .printConversation(
            Arrays.asList(
              new IndentationAndInputObject(0, new Output("Output 0 1")),
              new IndentationAndInputObject(0, new Output("Output 0 2")),
              new IndentationAndInputObject(1, new Answer(NO)),
              new IndentationAndInputObject(2, new Output("Output 2 1")),
              new IndentationAndInputObject(2, new Output("Output 2 2", 1)),
              new IndentationAndInputObject(2, new Output("Output 2 3")),
              new IndentationAndInputObject(3, new Answer(NOT_RIGHT_NOW)),
              new IndentationAndInputObject(4, new Conclusion("Conclusion 4 1")),
              new IndentationAndInputObject(3, new Answer(YES_UPGRADE)),
              new IndentationAndInputObject(4, new Conclusion("Conclusion 4 2")),
              new IndentationAndInputObject(1, new Answer(YES)),
              new IndentationAndInputObject(2, new Goto(1))),
            Arrays.asList(NO, NOT_RIGHT_NOW));
        System.out.println();
        new ConversationTree()
          .printConversation(
            Arrays.asList(
              new IndentationAndInputObject(0, new Output("Output 0 1")),
              new IndentationAndInputObject(0, new Output("Output 0 2")),
              new IndentationAndInputObject(1, new Answer(NO)),
              new IndentationAndInputObject(2, new Output("Output 2 1")),
              new IndentationAndInputObject(2, new Output("Output 2 2", 1)),
              new IndentationAndInputObject(2, new Output("Output 2 3")),
              new IndentationAndInputObject(3, new Answer(NOT_RIGHT_NOW)),
              new IndentationAndInputObject(4, new Conclusion("Conclusion 4 1")),
              new IndentationAndInputObject(3, new Answer(YES_UPGRADE)),
              new IndentationAndInputObject(4, new Conclusion("Conclusion 4 2")),
              new IndentationAndInputObject(1, new Answer(YES)),
              new IndentationAndInputObject(2, new Goto(1))),
            Arrays.asList(YES, NOT_RIGHT_NOW));
        System.out.println();
        new ConversationTree()
          .printConversation(
            Arrays.asList(
              new IndentationAndInputObject(0, new Output("Output 0 1")),
              new IndentationAndInputObject(0, new Output("Output 0 2")),
              new IndentationAndInputObject(1, new Answer(NO)),
              new IndentationAndInputObject(2, new Output("Output 2 1")),
              new IndentationAndInputObject(2, new Output("Output 2 2", 1)),
              new IndentationAndInputObject(2, new Output("Output 2 3")),
              new IndentationAndInputObject(3, new Answer(NOT_RIGHT_NOW)),
              new IndentationAndInputObject(4, new Conclusion("Conclusion 4 1")),
              new IndentationAndInputObject(3, new Answer(YES_UPGRADE)),
              new IndentationAndInputObject(4, new Conclusion("Conclusion 4 2")),
              new IndentationAndInputObject(1, new Answer(YES)),
              new IndentationAndInputObject(2, new Goto(1))),
            Arrays.asList(YES, YES_UPGRADE));
        System.out.println();
        new ConversationTree()
          .printConversation(
            Arrays.asList(
              new IndentationAndInputObject(0, new Output("Output 0 1")),
              new IndentationAndInputObject(0, new Output("Output 0 2")),
              new IndentationAndInputObject(1, new Answer(NO)),
              new IndentationAndInputObject(2, new Output("Output 2 1")),
              new IndentationAndInputObject(2, new Output("Output 2 2", 1)),
              new IndentationAndInputObject(2, new Output("Output 2 3", 2)),
              new IndentationAndInputObject(3, new Answer(NOT_RIGHT_NOW)),
              new IndentationAndInputObject(4, new Conclusion("Conclusion 4 1")),
              new IndentationAndInputObject(3, new Answer(YES_UPGRADE)),
              new IndentationAndInputObject(4, new Conclusion("Conclusion 4 2")),
              new IndentationAndInputObject(1, new Answer(YES)),
              new IndentationAndInputObject(2, new Goto(1)),
              new IndentationAndInputObject(1, new Answer("IDK")),
              new IndentationAndInputObject(2, new Goto(2))),
            Arrays.asList("IDK", NOT_RIGHT_NOW));
        System.out.println();
        new ConversationTree()
          .printConversation(
            Arrays.asList(
              new IndentationAndInputObject(0, new Output("Output 0 1")),
              new IndentationAndInputObject(0, new Output("Output 0 2")),
              new IndentationAndInputObject(1, new Answer(NO)),
              new IndentationAndInputObject(2, new Output("Output 2 1")),
              new IndentationAndInputObject(2, new Output("Output 2 2", 1)),
              new IndentationAndInputObject(2, new Output("Output 2 3", 2)),
              new IndentationAndInputObject(3, new Answer(NOT_RIGHT_NOW)),
              new IndentationAndInputObject(4, new Conclusion("Conclusion 4 1")),
              new IndentationAndInputObject(3, new Answer(YES_UPGRADE)),
              new IndentationAndInputObject(4, new Conclusion("Conclusion 4 2")),
              new IndentationAndInputObject(1, new Answer(YES)),
              new IndentationAndInputObject(2, new Goto(1)),
              new IndentationAndInputObject(1, new Answer("IDK")),
              new IndentationAndInputObject(2, new Goto(2))),
            Arrays.asList("afdas", "", "IDK", NOT_RIGHT_NOW));
        System.out.println();
        new ConversationTree()
          .printConversation(
            Arrays.asList(
              new IndentationAndInputObject(0, new Output("Output 0 1")),
              new IndentationAndInputObject(0, new Output("Output 0 2")),
              new IndentationAndInputObject(1, new Answer(NO)),
              new IndentationAndInputObject(2, new Output("Output 2 1")),
              new IndentationAndInputObject(2, new Output("Output 2 2", 1)),
              new IndentationAndInputObject(2, new Output("Output 2 3", 2)),
              new IndentationAndInputObject(3, new Answer(NOT_RIGHT_NOW)),
              new IndentationAndInputObject(4, new Conclusion("Conclusion 4 1")),
              new IndentationAndInputObject(3, new Answer(YES_UPGRADE)),
              new IndentationAndInputObject(4, new Conclusion("Conclusion 4 2")),
              new IndentationAndInputObject(1, new Answer(YES)),
              new IndentationAndInputObject(2, new Goto(1)),
              new IndentationAndInputObject(1, new Answer("IDK")),
              new IndentationAndInputObject(2, new Goto(2))),
            Arrays.asList("afdas", "", "IDK", "12312", NOT_RIGHT_NOW));
        //            try(BufferedReader reader = new BufferedReader(new InputStreamReader(System.in)))
        // {
        //                Solution solution = new Solution();
        //
        //                String line;
        //                boolean processingExamples = false;
        //                List<String> userAnswers = new ArrayList<>();
        //                List<IndentationAndInputObject> flatTree = new ArrayList<>();
        //
        //                while((line = reader.readLine()) != null) {
        //                    if(line.equals("---")) {
        //                        processingExamples = true;
        //                    } else if(processingExamples) {
        //                        userAnswers.add(line);
        //                    } else {
        //                        flatTree.add(solution.parseLine(line));
        //                    }
        //                }
        //
        //                solution.printConversation(flatTree, userAnswers);
        //            }
    }

    public void printConversation(
      List<IndentationAndInputObject> flatTree, List<String> userAnswers) {
        if (flatTree == null || flatTree.isEmpty() || userAnswers == null || userAnswers.isEmpty()) {
            return;
        }

        Map<Integer, List<IndentationAndInputObject>> indentation2AnsList = new HashMap<>();
        Map<Integer, IndentationAndInputObject> label2OutputObject = new HashMap<>();
        Map<IndentationAndInputObject, Node> indent2Node = new HashMap<>();
        Set<String> set = new HashSet<>();

        for (IndentationAndInputObject iaio : flatTree) {
            if (iaio.getInputObject() instanceof Answer) {
                if (!indentation2AnsList.containsKey(iaio.getIndentation())) {
                    indentation2AnsList.put(iaio.indentation, new ArrayList<>());
                }
                indentation2AnsList.get(iaio.indentation).add(iaio);
                set.add(iaio.getInputObject().getText());
            }
            if (iaio.getInputObject() instanceof Output && iaio.inputObject.getLabel().isPresent()) {
                label2OutputObject.put(iaio.inputObject.getLabel().getAsInt(), iaio);
            }
            indent2Node.put(iaio, new Node(iaio));
        }

        Set<Node> visited = new HashSet<>();
        Node root = new Node(flatTree.get(0));
        Node current = root;

        for (int i = 1; i < flatTree.size(); i++) {
            IndentationAndInputObject nextIaio = flatTree.get(i);
            Node nextNode = indent2Node.get(nextIaio);

            if (visited.contains(nextNode)) {
                current = nextNode;
                continue;
            }
            visited.add(nextNode);

            if (nextIaio.getInputObject() instanceof Output) {
                current.nexts.add(nextNode);
            } else if (nextIaio.getInputObject() instanceof Answer) {
                for (IndentationAndInputObject ans : indentation2AnsList.get(nextIaio.getIndentation())) {
                    Node ansNode = indent2Node.get(ans);
                    current.nexts.add(ansNode);
                    visited.add(ansNode);
                }
            } else if (nextIaio.getInputObject() instanceof Conclusion) {
                current.nexts.add(nextNode);
                continue;
            } else if (nextIaio.getInputObject() instanceof Goto) {
                nextNode =
                  indent2Node.get(
                    label2OutputObject.get(nextIaio.getInputObject().getLabel().getAsInt()));
                current.nexts.add(nextNode);
            }
            current = nextNode;
        }

        Node pn = root;
        int ui = 0;
        while (pn != null) {
            IndentationAndInputObject iaio = pn.object;
            if (iaio.getInputObject() instanceof Output) {
                System.out.println(HOPPER_MESSAGE_PREFIX + iaio.getInputObject().getText());
                if (pn.nexts.size() > 1) {
                    String ans = userAnswers.get(ui++);
                    while (!set.contains(ans)) {
                        ans = userAnswers.get(ui++);
                    }
                    for (Node n : pn.nexts) {
                        if (n.object.getInputObject().getText().equals(ans)) {
                            pn = n;
                            break;
                        }
                    }
                } else {
                    pn = pn.nexts.stream().findFirst().orElse(null);
                }
            } else if (iaio.getInputObject() instanceof Answer) {
                System.out.println(USER_MESSAGE_PREFIX + iaio.getInputObject().getText());
                pn = pn.nexts.stream().findFirst().get();
            } else if (iaio.getInputObject() instanceof Conclusion) {
                System.out.println(CONCLUSION_MESSAGE_PREFIX + iaio.getInputObject().getText());
                break;
            }
        }
    }

    public IndentationAndInputObject parseLine(String line) {
        int indentation = line.indexOf(line.trim());
        return new IndentationAndInputObject(
          indentation, parseInputObject(line.substring(indentation)));
    }

    public InputObject parseInputObject(String line) {
        if (line.charAt(0) == '-') {
            return new Answer(line.substring(1));
        } else if (line.charAt(0) == '=') {
            return new Conclusion(line.substring(1));
        } else if (line.charAt(0) == '>') {
            return new Goto(Integer.parseInt(line.substring(1)));
        } else {
            return parseOutput(line);
        }
    }

    public Output parseOutput(String line) {
        boolean labelFound = false;
        int labelDelimiter = -1;
        for (int i = 0; i < line.length(); i++) {
            if (!Character.isDigit(line.charAt(i))) {
                if (line.charAt(i) == ':') {
                    labelFound = true;
                    labelDelimiter = i;
                }
                break;
            }
        }

        if (labelFound) {
            return new Output(
              line.substring(labelDelimiter + 1), Integer.parseInt(line.substring(0, labelDelimiter)));
        } else {
            return new Output(line);
        }
    }

    interface InputObject {

        String getText();

        OptionalInt getLabel();
    }

    static class Output implements InputObject {

        private final String text;
        private final OptionalInt label;

        public Output(String text) {
            this.text = text;
            this.label = OptionalInt.empty();
        }

        public Output(String text, int label) {
            this.text = text;
            this.label = OptionalInt.of(label);
        }

        @Override
        public String toString() {
            return String.format(
              "Output(text='%s', label=%d)",
              this.text, this.label.isPresent() ? this.label.getAsInt() : 0);
        }

        @Override
        public String getText() {
            return this.text;
        }

        @Override
        public OptionalInt getLabel() {
            return this.label;
        }
    }

    static class Answer implements InputObject {

        private final String text;

        public Answer(String text) {
            this.text = text;
        }

        @Override
        public String toString() {
            return String.format("Answer(text='%s')", this.text);
        }

        @Override
        public String getText() {
            return this.text;
        }

        @Override
        public OptionalInt getLabel() {
            throw new UnsupportedOperationException();
        }
    }

    static class Conclusion implements InputObject {

        private final String text;

        public Conclusion(String text) {
            this.text = text;
        }

        @Override
        public String toString() {
            return String.format("Conclusion(text='%s')", this.text);
        }

        @Override
        public String getText() {
            return this.text;
        }

        @Override
        public OptionalInt getLabel() {
            throw new UnsupportedOperationException();
        }
    }

    static class Goto implements InputObject {

        private final int label;

        public Goto(int label) {
            this.label = label;
        }

        @Override
        public String toString() {
            return String.format("Goto(label=%d)", this.label);
        }

        @Override
        public String getText() {
            throw new UnsupportedOperationException();
        }

        @Override
        public OptionalInt getLabel() {
            return OptionalInt.of(this.label);
        }
    }

    static class IndentationAndInputObject {

        private final int indentation;
        private final InputObject inputObject;

        public IndentationAndInputObject(int indentation, InputObject inputObject) {
            this.indentation = indentation;
            this.inputObject = inputObject;
        }

        @Override
        public String toString() {
            return String.format(
              "IndentationAndInputObject(indentation=%d, inputObject=%s)",
              this.indentation, this.inputObject);
        }

        public int getIndentation() {
            return this.indentation;
        }

        public InputObject getInputObject() {
            return this.inputObject;
        }
    }

    class Node {

        IndentationAndInputObject object;
        Set<Node> nexts = new HashSet<>();

        Node(IndentationAndInputObject object) {
            this.object = object;
        }
    }
}
