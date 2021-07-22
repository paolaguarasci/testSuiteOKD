package org.osm;

public class Task implements Runnable {
  private final String name;
  private final String query;
  
  public Task(String name, String query) {
    this.name = name;
    this.query = query;
  }
  
  public String getName() {
    return name;
  }
  
  public void run() {
    DB.connect(this.query);
  }
}