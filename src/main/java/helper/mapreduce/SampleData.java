package helper.mapreduce;


import com.google.common.collect.ImmutableList;
import helper.mapreduce.KeyValue;

import java.util.List;

public final class SampleData {

  public static List<KeyValue> TEXT_CORPUS = new ImmutableList.Builder<KeyValue>()
      .add(new KeyValue("01", "Business groups have praised the Trump administration's move but environmental campaigners have condemned it."))
      .add(new KeyValue("02", "Flanked by coal miners as he signed the order, the president said: \"My administration is putting an end to the war on coal."))
      .add(new KeyValue("03", "\"With today's executive action I am taking historic steps to lift the restrictions on American energy, to reverse government intrusion and to cancel job-killing regulations.\""))
      .add(new KeyValue("04", "During the campaign, he vowed to pull the US out of the Paris climate deal agreed in December 2015."))
      .build().asList();

  private SampleData() {
  }

}
