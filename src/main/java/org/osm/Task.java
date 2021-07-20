package org.osm;

import java.util.concurrent.TimeUnit;

public class Task implements Runnable {
  private final String name;
  
  public Task(String name) {
    this.name = name;
  }
  
  public String getName() {
    return name;
  }
  
  public void run() {
    try {
      var duration = (long) (Math.random() * 10);
      
      DB.connect("select * from developers");
      
      TimeUnit.SECONDS.sleep(duration);
    } catch (InterruptedException e) {
      e.printStackTrace();
    }
  }
}