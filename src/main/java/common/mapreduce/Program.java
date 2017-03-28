package common.mapreduce;

import java.util.Iterator;

/**
 * A MapReduce program.
 */
public interface Program {

  void map(String key, String value, Collector collector);

  void reduce(String key, Iterator<String> values, Collector collector);

}
