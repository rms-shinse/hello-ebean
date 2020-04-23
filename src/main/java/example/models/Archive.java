package example.models;

import io.ebean.Finder;
import io.ebean.Model;
import io.ebean.annotation.CreatedTimestamp;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import java.util.Date;

@Entity
public class Archive extends Model {
  public static Finder<Long, Archive> find = new Finder<Long, Archive>(Archive.class) {};

  @Id public Long id;

  @Column(columnDefinition = "varchar(255)")
  public String classname;

  @Column(columnDefinition = "longtext")
  public String data = "";

  @CreatedTimestamp public Date createdate;

  public Archive(String classname, String data) {
    this.classname = classname;
    this.data = data;
  }
}
