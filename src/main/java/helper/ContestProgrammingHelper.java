package helper;

import java.util.*;

/**
 * Created by Ruochen on 04/02/2017.
 */
public final class ContestProgrammingHelper {

    public static <K, V extends Comparable<? super V>> Map<K, V> sortByValue(Map<K, V> unsortMap, boolean asc) {
        List<Map.Entry<K, V>> list =
                new LinkedList<>(unsortMap.entrySet());

        if (asc) {
            list.sort(Map.Entry.comparingByValue());
        } else {
            list.sort((o1, o2) -> (o2.getValue()).compareTo(o1.getValue()));//des order
        }

        Map<K, V> result = new LinkedHashMap<>();
        for (Map.Entry<K, V> entry : list) {
            result.put(entry.getKey(), entry.getValue());
        }

        return result;
    }
}
