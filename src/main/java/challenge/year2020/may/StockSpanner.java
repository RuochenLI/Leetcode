package challenge.year2020.may;

public class StockSpanner {

    private int[] pricesStack;
    private int[] spansStack;
    private int top;

    public StockSpanner() {
        pricesStack = new int[10000];
        spansStack = new int[10000];
        top = -1;
    }

    public int next(int price) {
        int span = 1;
        while (0 <= top && pricesStack[top] <= price) {
            span += spansStack[top--];
        }
        top++;
        pricesStack[top] = price;
        spansStack[top] = span;
        return span;
    }
}

/**
 * Your StockSpanner object will be instantiated and called as such:
 * StockSpanner obj = new StockSpanner();
 * int param_1 = obj.next(price);
 */
