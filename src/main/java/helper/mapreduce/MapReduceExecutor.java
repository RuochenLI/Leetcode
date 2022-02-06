package helper.mapreduce;

import com.google.common.collect.Lists;

import java.util.Collections;
import java.util.List;

/**
 * An extremely basic and naive MapReduce framework.
 */
public final class MapReduceExecutor {

  /**
   * Executes the specified programs using the supplied input data. If more than one program is specified the output
   * from the previous program is fed into the next.
   */
  public List<KeyValue> execute(Program program, List<KeyValue> inputData) {
    final List<KeyValue> mapOutput = Lists.newArrayList();

    Collector mapCollector = (key, value) -> mapOutput.add(new KeyValue(key, value));

    for (KeyValue keyValue : inputData) {
      program.map(keyValue.getKey(), keyValue.getValue(), mapCollector);
    }

    Collections.sort(mapOutput);

    final List<KeyValue> reduceOutput = Lists.newArrayList();
    Collector reduceCollector = (key, value) -> reduceOutput.add(new KeyValue(key, value));

    String previousKey = null;
    List<String> values = Lists.newArrayList();
    for (KeyValue keyValue : mapOutput) {
      String key = keyValue.getKey();
      String value = keyValue.getValue();
      if (previousKey == null || previousKey.equals(keyValue.getKey())) {
        values.add(value);
      } else {
        program.reduce(previousKey, values.iterator(), reduceCollector);
        values.clear();
        values.add(value);
      }
      previousKey = key;
    }
    if (!values.isEmpty()) {
      program.reduce(previousKey, values.iterator(), reduceCollector);
    }

    return reduceOutput;
  }

}
