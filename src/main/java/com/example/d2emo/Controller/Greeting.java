package com.example.d2emo.Controller;

public class Greeting {

  private final long id;
  private final String content;

  public long getId() {
    return this.id;
  }

  public String getContent() {
    return this.content;
  }

  @Override
  public String toString() {
    return "{" +
      " id='" + getId() + "'" +
      ", content='" + getContent() + "'" +
      "}";
  }

  public Greeting(long id, String content) {
    this.id = id;
    this.content = content;
  }


}