package helper.mapreduce;


import java.util.List;


public class WordCountProgramRunner {

  public static void main(String[] args) {
    Program program = new WordCountProgram();
    List<KeyValue> output = new MapReduceExecutor().execute(program, SampleData.TEXT_CORPUS);
    System.out.println("Output: " + output);
  }

}
