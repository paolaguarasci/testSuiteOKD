package org.osm;

import java.util.concurrent.Executors;

public class ThreadPoolExample {
  public static void main(String[] args) {
    var poolSize = 1000;
    var numberTask = 10000;
    var executor = Executors.newFixedThreadPool(poolSize);
    var query = "select * from developers";
    for (int i = 0; i <= numberTask; i++) {
      var task = new Task("Task " + i, query);
      executor.execute(task);
    }
    executor.shutdown();
  }
}