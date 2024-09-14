import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

class jUnitMainTest2 {

    jUnitMain jUnitMain;
    @Before
    public void setup() throws Exception {
        jUnitMain = new jUnitMain(2, 5);
    }

    @Test
    public void testMath() {
        Assert.assertEquals(7, jUnitMain.add());
    }
}
