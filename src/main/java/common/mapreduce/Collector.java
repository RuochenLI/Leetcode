package common.mapreduce;

/**
 * Collects values from the map and reduce phases.
 */
public interface Collector {

  void write(String key, String value);

}
