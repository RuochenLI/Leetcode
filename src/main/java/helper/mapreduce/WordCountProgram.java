package helper.mapreduce;

import helper.mapreduce.Collector;
import helper.mapreduce.Program;

import java.util.Iterator;


public class WordCountProgram implements Program {

  public void map(String key, String value, Collector collector) {
    String[] words = value.split("\\W+");
    for (String word : words) {
      collector.write(word.toLowerCase(), null);
    }
  }

  public void reduce(String key, Iterator<String> values, Collector collector) {
    int count = 0;
    while (values.hasNext()) {
      values.next();
      count++;
    }
    collector.write(key, Integer.toString(count));
  }

}
