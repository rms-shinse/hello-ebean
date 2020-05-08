import example.EbeanUtil;
import example.models.Archive;
import io.ebean.DB;
import io.ebean.Database;
import io.ebean.SqlRow;
import org.junit.Assert;
import org.junit.Test;

public class MyFirstTest {
    @Test
    public void testSum() {
        int a = 1 + 1;
        Assert.assertEquals(2, a);
    }


    @Test
    public void testEbean_withModel() {
        EbeanUtil.DatabaseFactory.create("default");
        final Archive a = new Archive("classname", "datda");
        a.save();
        Assert.assertNotNull(a.id);
    }

    @Test
    public void testEbean() {
        Database db = DB.getDefault();
        SqlRow result = db.sqlQuery("select 1;").findOne();

        Assert.assertNotNull(result);
    }
}