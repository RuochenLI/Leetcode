package exercises.leetcode1201_1400;

import java.util.ArrayList;
import java.util.List;

/**
 * 1352. Product of the Last K Numbers
 */
public class ProductOfNumbers {
    List<Integer> product = new ArrayList<>() {{
        add(1);
    }};

    public void add(int a) {
        if (a > 0) {
            product.add(product.get(product.size() - 1) * a);
        } else {
            product = new ArrayList<>();
            product.add(1);
        }
    }

    public int getProduct(int k) {
        int n = product.size();
        return k < n ? product.get(n - 1) / product.get(n - k - 1) : 0;
    }
}
