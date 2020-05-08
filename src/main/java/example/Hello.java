package example;

import example.models.Archive;

public class Hello {
  public static void main(String[] args) {
    System.out.println("hello, world!");
    EbeanUtil.DatabaseFactory.create("default");
    Archive.find.query().where().in("id", 3393, 3309).asUpdate().set("data", 123).update();
    Archive.find.query().where().in("id", 3380, 3383).delete();
  }
}