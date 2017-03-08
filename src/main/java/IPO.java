import java.util.*;

/**
 * Suppose LeetCode will start its IPO soon. In order to sell a good price of its shares to Venture Capital, LeetCode would like to work on some projects to increase its capital before the IPO. Since it has limited resources, it can only finish at most k distinct projects before the IPO. Help LeetCode design the best way to maximize its total capital after finishing at most k distinct projects.

 You are given several projects. For each project i, it has a pure profit Pi and a minimum capital of Ci is needed to start the corresponding project. Initially, you have W capital. When you finish a project, you will obtain its pure profit and the profit will be added to your total capital.

 To sum up, pick a list of at most k distinct projects from given projects to maximize your final capital, and output your final maximized capital.

 Example 1:
 Input: k=2, W=0, Profits=[1,2,3], Capital=[0,1,1].

 Output: 4

 Explanation: Since your initial capital is 0, you can only start the project indexed 0.
 After finishing it you will obtain profit 1 and your capital becomes 1.
 With capital 1, you can either start the project indexed 1 or the project indexed 2.
 Since you can choose at most 2 projects, you need to finish the project indexed 2 to get the maximum capital.
 Therefore, output the final maximized capital, which is 0 + 1 + 3 = 4.
 * Created by Ruochen on 04/02/2017.
 */
public class IPO {
    private static int max = 0;
    public int findMaximizedCapital(int k, int W, int[] Profits, int[] Capital) {
        findSolution(k, W, Profits, Capital, new HashSet<>(), 0);
        return max;
    }

    private void findSolution(int nbProjects, int currentCapital, int[] Profits, int[] Capital, Set<Integer> projectsDone, int benefits) {
        if (nbProjects == 0) {
            max = Math.max(benefits, max);
            return;
        }

        for (int i = 0; i < Profits.length; i++) {
            if (!projectsDone.contains(i) && Capital[i] <= currentCapital) {
                projectsDone.add(i);
                findSolution(nbProjects - 1, currentCapital - Capital[i] + Profits[i], Profits, Capital, projectsDone, benefits + Profits[i]);
                projectsDone.remove(i);
            }
        }
    }

    //solution by priority queue
    public int findMaximizedCapital1(int k, int W, int[] Profits, int[] Capital) {
        PriorityQueue<int[]> pqCap = new PriorityQueue<>((a, b) -> (a[0] - b[0]));
        PriorityQueue<int[]> pqPro  = new PriorityQueue<>((a, b) -> (b[1] - a[1]));

        for (int i = 0; i < Profits.length; i++) {
            pqCap.add(new int[] {Capital[i], Profits[i]});
        }

        for (int i = 0; i < k; i++) {
            while (!pqCap.isEmpty() && pqCap.peek()[0] <= W) {
                pqPro.add(pqCap.poll());
            }

            if (pqPro.isEmpty()) break;

            W += pqPro.poll()[1];
        }

        return W;
    }

    public class Solution {
        public int findMaximizedCapital(int k, int W, int[] Profits, int[] Capital) {
            if (Profits == null || Profits.length == 0) return 0;
            int n = Profits.length;
            PriorityQueue<Tuple> q = new PriorityQueue();
            for (int i = 0; i < n; i++) {
                q.add(new Tuple(Profits[i], Capital[i]));
            }
            while (!q.isEmpty() && k-- > 0) {
                Queue<Tuple> tmp = new ArrayDeque();
                while (!q.isEmpty() && q.peek().cap > W) tmp.add(q.poll());
                if (q.isEmpty()) return W;
                Tuple cur = q.poll();
                W += cur.pro;
                while (!tmp.isEmpty()) q.add(tmp.poll());
            }
            return W;
        }

        class Tuple implements Comparable<Tuple> {
            int pro, cap;
            public Tuple(int pro, int cap) {
                this.pro = pro;
                this.cap = cap;
            }

            public int compareTo(Tuple that) {
                return that.pro - this.pro;
            }
        }
    }

    public class Solution2 {


        public int findMaximizedCapital(int k, int W, int[] Profits, int[] Capital) {
            if (Profits == null || Capital == null) {
                return 0;
            }
            ArrayList<Pair> projects = new ArrayList<>();
            int n = Profits.length;
            for (int i = 0; i < n; i++) {
                projects.add(new Pair(Profits[i], Capital[i]));
            }
            // sort all the project with capital ascending order
            // make it convenient to check all the projects that satisfy current capital constrain
            Collections.sort(projects, new Comparator<Pair>() {
                public int compare(Pair p1, Pair p2) {
                    int diff = p1.cap - p2.cap;
                    if (diff == 0) {
                        diff = p2.prf - p1.prf;
                    }
                    return diff;
                }
            });

            // maxheap : always garantee that the top of pq has maximual profit
            PriorityQueue<Pair> pq = new PriorityQueue<>(new Comparator<Pair>() {
                public int compare(Pair p1, Pair p2) {
                    int diff = p2.prf - p1.prf;
                    if (diff == 0) {
                        diff = p1.cap - p1.cap;
                    }
                    return diff;
                }
            });

            // the potential project we start to look at
            int i = 0;
            // loop for k round
            int maxCapital = W;
            for (int j = 0; j < k; j++) {
                // initialization for each round
                // put all the projects that satisfy current capital constrain into PQ
                for (; i < n; i++) {
                    if (projects.get(i).cap <= maxCapital) {
                        pq.add(projects.get(i));
                    } else {
                        break;
                    }
                }
                // the top of PQ would be our best choice of this round
                if (!pq.isEmpty()) {
                    maxCapital += pq.poll().prf;
                }
            }
            return maxCapital;
        }
    }

    class Pair {
        int prf;
        int cap;
        public Pair(int prf, int cap) {
            this.prf = prf;
            this.cap = cap;
        }
    }

}
