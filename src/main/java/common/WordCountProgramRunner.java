package common;


import common.mapreduce.KeyValue;
import common.mapreduce.MapReduceExecutor;
import common.mapreduce.Program;

import java.util.List;


public class WordCountProgramRunner {

  public static void main(String[] args) {
    Program program = new WordCountProgram();
    List<KeyValue> output = new MapReduceExecutor().execute(program, SampleData.TEXT_CORPUS);
    System.out.println("Output: " + output);
  }

}
