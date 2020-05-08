import example.EbeanUtil;
import example.models.Archive;
import org.junit.Assert;
import org.junit.Test;

public class MyFirstTest {
    @Test
    public void testSum() {
        int a = 1 + 1;
        Assert.assertEquals(2, a);
    }

    @Test
    public void testEbean() {
        EbeanUtil.DatabaseFactory.create("default");
        final Archive a = new Archive("classname", "datda");
        a.save();
        System.out.println(String.format("id: %s", a.id));
        Assert.assertNotNull(a.id);
    }
}